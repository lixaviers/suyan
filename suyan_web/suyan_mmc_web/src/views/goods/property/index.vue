<template>
  <div>
    <Row>
      <Cascader @on-change="change" :data="data" style="width: 320px;float: left;"
                placeholder="请选择类目"></Cascader>
      <Button v-show="property.categoryId && property.categoryId != null" @click="show"
              style="float: left;margin-left: 10px;">新增属性
      </Button>
    </Row>
    <Row style="margin-right: 20px;">
      <Table border :columns="columns" :data="dataList" :loading="loading" style="margin-top: 20px;"/>
    </Row>
    <Modal
      :closable="false"
      v-model="modal"
      title="操作属性"
      footer-hide
      :mask-closable="false">
      <Form style="margin-top: 10px;" inline ref="createPropertyNameForm" :model="property" :label-width="120">
        <FormItem label="名称" prop="name" :rules="{required: true, message: '名称不能为空', trigger: 'blur'}">
          <Input v-model="property.name" placeholder="名称" style="width: 240px"/>
        </FormItem>
        <FormItem label="是否允许别名">
          <i-switch v-model="property.isAllowAlias" size="large">
            <span slot="open">是</span>
            <span slot="close">否</span>
          </i-switch>
        </FormItem>
        <FormItem label="是否颜色属性">
          <i-switch v-model="property.isColorAttribute" size="large">
            <span slot="open">是</span>
            <span slot="close">否</span>
          </i-switch>
        </FormItem>
        <FormItem label="是否枚举属性">
          <i-switch v-model="property.isEnumAttribute" size="large">
            <span slot="open">是</span>
            <span slot="close">否</span>
          </i-switch>
        </FormItem>
        <FormItem label="是否输入属性">
          <i-switch v-model="property.isInputAttribute" size="large">
            <span slot="open">是</span>
            <span slot="close">否</span>
          </i-switch>
        </FormItem>
        <FormItem label="是否销售属性">
          <i-switch v-model="property.isSalesProperty" size="large">
            <span slot="open">是</span>
            <span slot="close">否</span>
          </i-switch>
        </FormItem>
        <FormItem label="是否搜索字段">
          <i-switch v-model="property.isSearchField" size="large">
            <span slot="open">是</span>
            <span slot="close">否</span>
          </i-switch>
        </FormItem>
        <FormItem label="是否必选">
          <i-switch v-model="property.isWillChoose" size="large">
            <span slot="open">是</span>
            <span slot="close">否</span>
          </i-switch>
        </FormItem>
        <FormItem label="是否多选">
          <i-switch v-model="property.isMultiSelect" size="large">
            <span slot="open">是</span>
            <span slot="close">否</span>
          </i-switch>
        </FormItem>
        <FormItem>
          <Button :loading="loading" type="primary" @click="handleSubmit('createPropertyNameForm', 1)">保 存</Button>
          <Button @click="modal = false" style="margin-left: 10px;">取 消</Button>
        </FormItem>
      </Form>
    </Modal>
    <Modal
      :closable="false"
      v-model="propertyValueModal"
      title="操作属性值"
      footer-hide
      :mask-closable="false">
      <Form style="margin-top: 10px;" inline ref="createPropertyValueForm" :model="propertyValue" :label-width="120">
        <FormItem label="名称" prop="name" :rules="{required: true, message: '名称不能为空', trigger: 'blur'}">
          <Input v-model="propertyValue.name" placeholder="名称" style="width: 240px"/>
        </FormItem>
        <FormItem>
          <Button :loading="loading" type="primary" @click="handleSubmit('createPropertyValueForm', 2)">保 存</Button>
          <Button @click="propertyValueModal = false" style="margin-left: 10px;">取 消</Button>
        </FormItem>
      </Form>
    </Modal>
    <Modal
      v-model="propertyValueListModal"
      title="属性值列表"
      footer-hide
      :mask-closable="false">
      <p v-for="(item, index) in propertyValueList">{{item.name}}</p>
    </Modal>
  </div>
</template>
<script>
  import {treeDataTranslate} from '@/utils';
  export default {
    data () {
      return {
        data: [],
        dataList: [],
        propertyValueList: [],
        loading: false,
        modal: false,
        propertyValueModal: false,
        propertyValueListModal: false,
        propertyValue: {
          id: null,
          categoryId: null,
          propertyNameId: null,
          name: '',
        },
        property: {
          id: null,
          categoryId: null,
          name: '',
          isAllowAlias: false,
          isColorAttribute: false,
          isEnumAttribute: false,
          isInputAttribute: false,
          isSalesProperty: false,
          isSearchField: false,
          isWillChoose: false,
          isMultiSelect: false,
        },
        columns: [
          {
            title: 'id', key: 'id', width: 80,
          },
          {
            title: '属性名', key: 'name'
          },
          {
            title: '是否允许别名', key: 'isAllowAlias',
            render: (h, params) => {
              if (params.row.isAllowAlias) {
                var label = [h('label', {
                  style: {
                    color: 'green'
                  }
                }, '是')];
                return label;
              } else {
                var label = [h('label', {
                  style: {
                    color: 'red'
                  }
                }, '否')];
                return label;
              }
            }
          },
          {
            title: '是否颜色属性', key: 'isColorAttribute',
            render: (h, params) => {
              if (params.row.isColorAttribute) {
                var label = [h('label', {
                  style: {
                    color: 'green'
                  }
                }, '是')];
                return label;
              } else {
                var label = [h('label', {
                  style: {
                    color: 'red'
                  }
                }, '否')];
                return label;
              }
            }
          },
          {
            title: '是否枚举属性', key: 'isEnumAttribute',
            render: (h, params) => {
              if (params.row.isEnumAttribute) {
                var label = [h('label', {
                  style: {
                    color: 'green'
                  }
                }, '是')];
                return label;
              } else {
                var label = [h('label', {
                  style: {
                    color: 'red'
                  }
                }, '否')];
                return label;
              }
            }
          },
          {
            title: '是否输入属性', key: 'isInputAttribute',
            render: (h, params) => {
              if (params.row.isInputAttribute) {
                var label = [h('label', {
                  style: {
                    color: 'green'
                  }
                }, '是')];
                return label;
              } else {
                var label = [h('label', {
                  style: {
                    color: 'red'
                  }
                }, '否')];
                return label;
              }
            }
          },
          {
            title: '是否销售属性', key: 'isSalesProperty',
            render: (h, params) => {
              if (params.row.isSalesProperty) {
                var label = [h('label', {
                  style: {
                    color: 'green'
                  }
                }, '是')];
                return label;
              } else {
                var label = [h('label', {
                  style: {
                    color: 'red'
                  }
                }, '否')];
                return label;
              }
            }
          },
          {
            title: '是否搜索字段', key: 'isSearchField',
            render: (h, params) => {
              if (params.row.isSearchField) {
                var label = [h('label', {
                  style: {
                    color: 'green'
                  }
                }, '是')];
                return label;
              } else {
                var label = [h('label', {
                  style: {
                    color: 'red'
                  }
                }, '否')];
                return label;
              }
            }
          },
          {
            title: '是否必选', key: 'isWillChoose',
            render: (h, params) => {
              if (params.row.isWillChoose) {
                var label = [h('label', {
                  style: {
                    color: 'green'
                  }
                }, '是')];
                return label;
              } else {
                var label = [h('label', {
                  style: {
                    color: 'red'
                  }
                }, '否')];
                return label;
              }
            }
          },
          {
            title: '是否多选', key: 'isMultiSelect',
            render: (h, params) => {
              if (params.row.isMultiSelect) {
                var label = [h('label', {
                  style: {
                    color: 'green'
                  }
                }, '是')];
                return label;
              } else {
                var label = [h('label', {
                  style: {
                    color: 'red'
                  }
                }, '否')];
                return label;
              }
            }
          },
          {
            title: '操作',
            key: 'action',
            fixed: 'right',
            width: 260,
            render: (h, params) => {

              var actionButtons = [];
              if (this.isAuth('goods:property:edit:button')) {
                actionButtons.push(h('Button', {
                  props: {
                    type: 'info',
                    size: 'small'
                  },
                  on: {
                    click: () => {
                      this.property.id = params.row.id;
                      this.show();
                    }
                  }
                }, '编辑'));
              }
              actionButtons.push(h('Button', {
                style: {
                  marginLeft: '10px'
                },
                props: {
                  size: 'small'
                },
                on: {
                  click: () => {
                    this.$http({
                      url: this.$http.adornUrl('propertyValues/queryPropertyValues', 2),
                      method: 'post',
                      data: this.$http.adornData({
                        'categoryId': this.property.categoryId,
                        'propertyNameId': params.row.id,
                        'isDeleted': false,
                        'orderBy': 'sort_number asc, id asc',
                      })
                    }).then(({data}) => {
                      if (data && data.code === 200 && data.dataMap) {
                        this.propertyValueList = data.dataMap.records;
                        this.propertyValueListModal = true;
                      } else {
                        this.propertyValueList = [];
                      }
                    });
                  }
                }
              }, '查看属性值'));
              if (this.isAuth('goods:property:edit:button')) {
                actionButtons.push(h('Button', {
                  style: {
                    marginLeft: '10px'
                  },
                  props: {
                    type: 'info',
                    size: 'small'
                  },
                  on: {
                    click: () => {
                      this.propertyValue.propertyNameId = params.row.id;
                      this.propertyValue.categoryId = this.property.categoryId;
                      this.propertyValueModal = true;
                    }
                  }
                }, '添加属性值'));
              }

              return h('div', actionButtons);
            }
          }
        ],
      }
    },
    created () {
      this.$http({
        url: this.$http.adornUrl('category/queryCategoryCascader', 2),
        method: 'get',
        data: this.$http.adornData()
      }).then(({data}) => {
        if (data && data.code === 200 && data.dataMap) {
          var data = data.dataMap;
          this.data = treeDataTranslate(data);
        }
      });


    },
    methods: {
      show(){
        this.modal = true;
        if (this.property.id) {
          this.$http({
            url: this.$http.adornUrl('propertyName/getPropertyName/' + this.property.id, 2),
            method: 'get',
          }).then(({data}) => {
            if (data && data.code === 200 && data.dataMap) {
              this.property = data.dataMap;
            }
          });
        }
      },
      change(value){
        console.log(value);
        if (value && value.length > 0) {
          this.property.categoryId = value[value.length - 1];
          this.getDateList();
        } else {
          this.property.categoryId = null;
          this.dataList = [];
        }
      },
      getDateList(){
        this.loading = true;
        this.$http({
          url: this.$http.adornUrl('propertyName/queryPropertyName', 2),
          method: 'post',
          data: this.$http.adornData({
            'categoryId': this.property.categoryId,
            'isDeleted': false,
            'orderBy': 'sort_number asc, id asc',
          })
        }).then(({data}) => {
          if (data && data.code === 200 && data.dataMap.totalRecords > 0) {
            this.dataList = data.dataMap.records;
          } else {
            this.dataList = []
          }
          this.loading = false;
        })
      },
      handleSubmit (name, type) {
        let t = this;
        this.$refs[name].validate((valid) => {
          if (valid) {
            if (type == 1) {
              if (!this.property.categoryId) {
                this.$Message.error({content: '请选择所属类目', duration: 2});
                return;
              }
              this.$http({
                url: this.$http.adornUrl(`propertyName/${!this.property.id ? 'createPropertyName' : 'updatePropertyName'}`, 2),
                method: 'post',
                data: this.$http.adornData(this.property)
              }).then(({data}) => {
                if (data && data.code === 200) {
                  this.$Message.success({
                    content: '操作成功',
                    duration: 2,
                    onClose: function () {
                      t.modal = false;
                      t.getDateList();
                    }
                  });
                } else {
                  this.loading = false;
                }
              })
            } else if (type == 2) {
              if (!t.propertyValue.categoryId) {
                t.$Message.error({content: '请选择所属类目', duration: 2});
                return;
              }
              if (!t.propertyValue.propertyNameId) {
                t.$Message.error({content: '请选择所属属性名', duration: 2});
                return;
              }
              t.$http({
                url: t.$http.adornUrl(`propertyValues/${!t.propertyValue.id ? 'createPropertyValues' : 'updatePropertyValues'}`, 2),
                method: 'post',
                data: t.$http.adornData(this.propertyValue)
              }).then(({data}) => {
                if (data && data.code === 200) {
                  t.$Message.success({
                    content: '操作成功',
                    duration: 2,
                    onClose: function () {
                        t.propertyValue.name = '';


                      // t.propertyValueModal = false;
                    }
                  });
                } else {
                  this.loading = false;
                }
              })
            }

          }
        })
      }
    }
  }
</script>
