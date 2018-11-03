<template>
  <Form style="margin-top: 10px; padding-right: 20px;" ref="createBrandForm" :rules="ruleValidate" :model="formBrand"
        :label-width="120">
    <FormItem label="品牌名称" prop="name">
      <Input v-model="formBrand.name" placeholder="品牌名称" style="width: 320px"/>
    </FormItem>
    <FormItem label="品牌英文名称" prop="nameEn">
      <Input v-model="formBrand.nameEn" placeholder="品牌英文名称" style="width: 320px"/>
    </FormItem>
    <FormItem label="所属类目">
      <Cascader :data="data" v-model="formBrand.categoryIds" style="width: 320px"></Cascader>
    </FormItem>
    <FormItem label="品牌描述" prop="description">
      <Input v-model="formBrand.description" type="textarea" :autosize="{minRows: 3,maxRows: 5}" placeholder="品牌描述"/>
    </FormItem>
    <FormItem>
      <Button :loading="loading" type="primary" @click="handleSubmit('createBrandForm', 1)">提 交</Button>
      <Button @click="$router.push({name: 'goodsBrandIndex'});" style="margin-left: 15px;">返回品牌列表</Button>
    </FormItem>
  </Form>
</template>
<script>
  import {treeDataTranslate} from '@/utils';
  export default {
    data () {
      return {
        data: [],
        loading: false,
        formBrand: {
          id: null,
          categoryId: null,
          categoryIds: [],
          name: '',
          nameEn: '',
          description: '',
        },
        ruleValidate: {
          name: [
            {required: true, message: '品牌名称不能为空', trigger: 'blur'}
          ],
        },
      }
    },
    created () {
      let id = this.$route.params.id, t = this;
      this.$http({
        url: this.$http.adornUrl('category/queryCategoryCascader', 2),
        method: 'get',
        data: this.$http.adornData()
      }).then(({data}) => {
        if (data && data.code === 200 && data.dataMap) {
          var data = data.dataMap;
          this.data = treeDataTranslate(data);
          console.log(this.data)
        }
      }).then(function () {
        if (id) {
          t.$http({
            url: t.$http.adornUrl('brand/getBrand/' + id, 2),
            method: 'get',
            data: t.$http.adornData()
          }).then(({data}) => {
            if (data && data.code === 200 && data.dataMap) {
              t.formBrand.id = id;
              t.formBrand = data.dataMap;
              t.formBrand.categoryIds = data.dataMap.categoryIds.split('-');
            }
          });
        }
      });


    },
    methods: {
      handleSubmit (name) {
        let t = this;
        this.$refs[name].validate((valid) => {
          if (valid) {
            if (!this.formBrand.categoryIds || this.formBrand.categoryIds.length == 0) {
              this.$Message.error({content: '请选择所属类目', duration: 2});
              return;
            }
            this.loading = true;
            this.formBrand.categoryId = this.formBrand.categoryIds[this.formBrand.categoryIds.length - 1];
            this.$http({
              url: this.$http.adornUrl(`brand/${!this.formBrand.id ? 'createBrand' : 'updateBrand'}`, 2),
              method: 'post',
              data: this.$http.adornData(this.formBrand)
            }).then(({data}) => {
              if (data && data.code === 200) {
                this.$Message.success({
                  content: '操作成功',
                  duration: 2,
                  onClose: function () {
                    t.$router.push({name: 'goodsBrandIndex'});
                  }
                });
              } else {
                this.loading = false;
              }
            })

          }
        })
      }
    }
  }
</script>
