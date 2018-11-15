<template>
  <div style="margin-right: 20px;">
    <Row>
      <Card><strong>当前类目：{{categoryNames}}</strong></Card>
    </Row>
    <Form ref="createGoodForm" :model="formGood"
          :label-width="120" inline>
      <Row style="margin-top: 20px;">
        <Card>
          <p slot="title">基础信息</p>
          <FormItem label="商品名称" prop="name" :rules="{required: true, message: '名称不能为空', trigger: 'blur'}">
            <Input v-model="formGood.name" style="width: 320px"/>
          </FormItem>
          <FormItem label="品牌" prop="brandId" :rules="{required: true, message: '名称不能为空', trigger: 'blur'}">
            <Select v-model="formGood.brandId" style="width: 320px">
              <Option v-for="item in brandList" :value="item.id + ''" :key="item.id">{{ item.name }}</Option>
            </Select>
          </FormItem>
          <FormItem v-for="(item,index) in formGood.propertyList" :key="item.id" :label="item.name"
                    :prop="'propertyList.' + index + '.value'"
                    :rules="{required: item.isWillChoose, message: item.name + '不能为空', trigger: 'blur'}">
            <Input v-if="item.isInputAttribute" v-model="item.value"
                   style="width: 320px"/>
            <Select v-else-if="!item.isColorAttribute" v-model="item.value" style="width: 320px;">
              <Option v-for="valueItem in item.propertyValuesList" :value="valueItem.id + ''" :key="valueItem.id">
                {{ valueItem.name }}
              </Option>
            </Select>
          </FormItem>
        </Card>
      </Row>

      <Row style="margin-top: 20px;">
        <Card>
          <p slot="title">销售信息</p>
          <Row v-if="formGood.colorList && formGood.colorList.length > 0" v-for="(item,index) in formGood.colorList"
               :key="item.id">
            <FormItem :label="item.name" :prop="'colorList.' + index + '.value'"
                      :rules="{required: item.isWillChoose, message: item.name + '不能为空', trigger: 'blur'}">
              <AutoComplete
                v-model="item.value"
                placeholder="选择主色"
                @on-change="colorChange(index)"
                style="width:320px">
                <Col style="float: left;border-right: 1px solid #e5e5e5;padding-right: 20px;">
                <Row v-for="(item, index) in colorList" :key="item.id">
                  <a @mouseover="select(index)" href="javascript:;" class="color-dropdown-wrapper">
                    <div class="color-block" :style="'background:' + item.colorValue"></div>
                    <span>{{ item.colorName }}</span></a>
                </Row>
                </Col>
                <Col class="color-t" v-show="flag">
                <p style="margin: 10px 0;">常用标准颜色</p>
                <Option v-for="option in subColors" :value="option.colorName" :key="option.colorName">
                  <a class="color-dropdown-wrapper" href="javascript:;">
                    <div class="color-block" :style="'background:' + option.colorValue"></div>
                    <span>{{ option.colorName }}</span>
                  </a>
                </Option>
                </Col>
              </AutoComplete>
              <!--<Upload action="/apiUpload/common/fileUpload" style="float: right;margin-left: 20px;">
                <Button icon="ios-cloud-upload-outline">上传图片</Button>
              </Upload>-->
              <Input placeholder="图片" v-model="formGood.name" style="margin-left: 20px;width: 300px"/>
              <label style="color:#f90">这里请不要动，因为没有图片服务器~</label>
            </FormItem>
          </Row>

          <Row v-for="(item,index) in formGood.saleList" :key="item.id">
            <FormItem v-if="item.isEnumAttribute" :label="item.name"
                      :prop="'saleList.' + index + '.value'"
                      :rules="{ required: true, type: 'array', min: 1, message: '请选择' + item.name, trigger: 'change' }">
              <CheckboxGroup v-model="item.value" @on-change="saleChange">
                <Checkbox v-for="valueItem in item.propertyValuesList" :label="valueItem.id + ''" :key="valueItem.id">
                  {{valueItem.name}}
                </Checkbox>
              </CheckboxGroup>
            </FormItem>
          </Row>

          <Row>
            <FormItem label="销售规格" style="width: 100%;">
              <Table :data="salesSpecificationsData"
                     :columns="salesSpecificationsColumns">
              </Table>
            </FormItem>
          </Row>
          <FormItem label="列表价" prop="listPrice"
                    :rules="{required: true, type: 'number', message: '列表价不能为空', trigger: 'blur'}">
            <InputNumber :max="100000000" :precision="2" :min="0.01" :step="1" v-model="formGood.listPrice"
                         style="width: 320px"/>
          </FormItem>
        </Card>
      </Row>

      <Row style="margin-top: 20px;">
        <Card>
          <p slot="title">图文描述</p>
          <FormItem label="商品图片" prop="name" style="width: 100%;">
            <Input v-model="formGood.name" style="width: 500px"/>
            <label style="color:#f90">这里请不要动，因为没有图片服务器~</label>
          </FormItem>
          <FormItem label="">
            <Input v-model="formGood.name" style="width: 500px"/>
            <label style="color:#f90">这里请不要动，因为没有图片服务器~</label>
          </FormItem>
          <FormItem label="">
            <Input v-model="formGood.name" style="width: 500px"/>
            <label style="color:#f90">这里请不要动，因为没有图片服务器~</label>
          </FormItem>
          <FormItem label="">
            <Input v-model="formGood.name" style="width: 500px"/>
            <label style="color:#f90">这里请不要动，因为没有图片服务器~</label>
          </FormItem>
          <FormItem label="商品描述" style="width: 100%;">
            <editor ref="editor" :value="content" @on-change="handleChange"/>
          </FormItem>
        </Card>
      </Row>
      <Row style="margin-top: 30px;">
        <FormItem>
          <Button :loading="loading" type="primary" @click="handleSubmit('createGoodForm', 1)">提交商品信息</Button>
        </FormItem>
      </Row>
    </Form>
  </div>
</template>


<script>
  import Editor from '@/components/editor'
  export default {
    components: {
      Editor
    },
    data () {
      return {
        salesSpecificationsColumns: [],
        salesSpecificationsData: [
          {name: 1, age: 1, price: 1, number: 1}
        ],
        content: '',
        flag: false,
        loading: false,
        categoryId: null,
        brandList: [],
        colorList: [],
        subColors: [],
        categoryNames: '',
        formGood: {
          name: '',
          listPrice: null,
          brandId: null,
          propertyList: [],
          saleList: [],
          colorList: [],
        },
        identify: {
          colorAttribute: false,
          enumAttribute: 0,
        },
        colorSelect: false,
      }
    },
    methods: {
      saleChange(obj) {
        let t = this;
        if (obj && obj.length > 0 && t.identify.colorAttribute && t.colorSelect) {
          t.showSalesSpecifications();
        }

      },
      colorChange(index){
        let t = this, value = t.formGood.colorList[index].value;
        console.log(t.identify.colorAttribute)
        if (value) {
          t.colorSelect = true;
          if (index == t.formGood.colorList.length - 1) {
            t.formGood.colorList.push({isWillChoose: false});
          }
        }
        for (var i = 0; i < this.formGood.saleList.length; i++) {
          var sale = this.formGood.saleList[i];
          if (sale.isWillChoose && !sale.value) {
            return;
          }
        }
        this.showSalesSpecifications();
      },
      // 显示销售规格
      showSalesSpecifications(){
        let t = this, salesSpecificationsData = [];// salesSpecificationsData
        t.salesSpecificationsColumns = [];

        for (var i = 0; i < this.formGood.colorList.length; i++) {
          let color = this.formGood.colorList[i];
          if (!color.value) {
            continue;
          }
          for (var j = 0; j < t.formGood.saleList.length; j++) {
            var sale = t.formGood.saleList[j];
            if (sale.value) {
              salesSpecificationsData.push({color: color.value, ['sale'+ j] :1});
            }
          }
        }
        t.salesSpecificationsData = salesSpecificationsData;

        if (t.identify.colorAttribute) {
          t.salesSpecificationsColumns.push({
            title: '颜色分类',
            key: 'color'
          });
        }
        if (t.identify.enumAttribute > 0) {
          for (var j = 0; j < t.formGood.saleList.length; j++) {
            var sale = t.formGood.saleList[j];
            t.salesSpecificationsColumns.push({
              title: sale.name,
              key: 'sale' + j
            });
          }
        }

        t.salesSpecificationsColumns.push(
          {
            title: '价格',
            key: 'price',
            render: (h, params) => {
              return h('Input', {
                style: {
                  width: '80px'
                },
                props: {
                  value: params.row.price
                },
                on: {
                  'on-change' (event) {
                    this.salesSpecificationsData[params.index].number = event.target.value;
                  }
                }
              });
            }
          });
        t.salesSpecificationsColumns.push({
          title: '数量',
          key: 'number',
          render: (h, params) => {
            return h('Input', {
              style: {
                width: '80px'
              },
              props: {
                value: params.row.number
              },
              on: {
                'on-change' (event) {
                  this.salesSpecificationsData[params.index].number = event.target.value;
                }
              }
            });
          }
        });
      },
      handleChange (html, text) {
        console.log(html)
      },
      select(index){
        this.subColors = this.colorList[index].subColors;
        this.flag = true;
      },
      handleSubmit(name) {
        let t = this;
        console.log(t.formGood)
        this.$refs[name].validate((valid) => {
          if (valid) {
            console.log(1)
          }
        });
      }
    },
    created() {
      let categoryId = this.$route.params.categoryId, t = this;
      if (!categoryId) {
        t.$router.push({name: 'goodCreate'});
      }
      t.$http({
        url: t.$http.adornUrl('category/getCategoryNames/' + categoryId, 2),
        method: 'get',
      }).then(({data}) => {
        if (data && data.code === 200 && data.dataMap) {
          t.categoryId = categoryId;
          t.categoryNames = data.dataMap;
        }
      }).then(function () {
        t.$http({
          url: t.$http.adornUrl('brand/queryBrand', 2),
          method: 'post',
          data: t.$http.adornData({
            'pageSize': 10000,
            'categoryId': t.categoryId,
            'isDeleted': false,
            'orderBy': 'id',
          })
        }).then(({data}) => {
          if (data && data.code === 200 && data.dataMap.totalRecords > 0) {
            t.brandList = data.dataMap.records;
          } else {
            t.brandList = []
          }
        })
      }).then(function () {
        t.$http({
          url: t.$http.adornUrl('propertyName/getPropertysByCategoryId/' + categoryId, 2),
          method: 'get',
        }).then(({data}) => {
          if (data && data.code === 200 && data.dataMap) {
            var saleList = [], propertyList = [], colorList = [], loadColorAttribute = false;
            for (var i = 0; i < data.dataMap.length; i++) {
              var obj = data.dataMap[i];
              if (obj.isColorAttribute) {
                loadColorAttribute = true;
                t.identify.colorAttribute = true;
                colorList.push(obj);
              } else if (obj.isEnumAttribute) {
                t.identify.enumAttribute = t.identify.enumAttribute + 1;
                saleList.push(obj);
              } else {
                propertyList.push(obj);
              }
            }
            t.formGood.propertyList = propertyList;
            t.formGood.saleList = saleList;
            t.formGood.colorList = colorList;
            if (loadColorAttribute) {
              // 加载颜色
              t.$http({
                url: t.$http.adornUrl('colorSeries/getAll', 2),
                method: 'get',
              }).then(({data}) => {
                if (data && data.code === 200 && data.dataMap) {
                  t.colorList = data.dataMap;

                }
              });
            }
          }
        });
      });
    },
  }
</script>
<style lang="less">
  .color-dropdown-wrapper {
    display: block;
    color: #333;
    width: 80px;
    padding: 0 10px;
    line-height: 30px;
    font-size: 12px;
    text-decoration: none;
    .color-block {
      border: 1px solid #ddd;
      width: 11px;
      height: 11px;
      display: inline-block;
      margin-right: 5px;
    }
  }

  .color-t {
    float: left;
    margin-left: 20px;
    .ivu-select-item {
      padding: 0 16px;
      .color-dropdown-wrapper {
        padding: 0;
      }
    }
  }

</style>
