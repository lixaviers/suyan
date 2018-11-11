<template>

  <div style="padding-right: 20px;">
    <Button @click="$router.push({name: 'goodsBrandIndex'});">返回品牌列表</Button>
    <Card style="margin-top: 20px;">
      <p slot="title">品牌详情</p>
      <p>名称：{{formBrand.name}}</p>
      <p>英文名称：{{formBrand.nameEn}}</p>
      <p>所属类目：{{formBrand.categoryNames}}</p>
      <p>描述：{{formBrand.description}}</p>
    </Card>
  </div>



</template>
<script>
  import {dateFormat} from '@/utils';
  export default {
    data () {
      return {
        formBrand: {
          id: null,
          name: '',
          nameEn: '',
          categoryNames: '',
          description: '',
        },
      }
    },
    created () {
      let id = this.$route.params.id;
      if (id) {
        this.$http({
          url: this.$http.adornUrl('brand/getBrand/' + id, 2),
          method: 'get',
        }).then(({data}) => {
          if (data && data.code === 200 && data.dataMap) {
            this.formBrand.id = id;
            this.formBrand = data.dataMap;
          }
        });
      }
    },
    methods: {
    }
  }
</script>
