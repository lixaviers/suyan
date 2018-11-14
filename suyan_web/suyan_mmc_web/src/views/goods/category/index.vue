<template>
  <div style="padding-right: 20px;">
    <Modal
      :closable="false"
      v-model="modal"
      title="操作类目"
      footer-hide
      :mask-closable="false">
      <Form style="margin-top: 10px;" ref="createCategoryForm" :model="formCategory" :label-width="120">
        <FormItem label="名称" prop="name" :rules="{required: true, message: '名称不能为空', trigger: 'blur'}">
          <Input v-model="formCategory.name" placeholder="名称" style="width: 240px"/>
        </FormItem>
        <FormItem v-show="!formCategory.id" label="上级类目">
          <Select @on-change="change" v-model="formCategory.parentId1" style="width:150px">
            <Option v-for="category in firstCategorys" :value="category.id" :key="category.id">{{ category.name }}
            </Option>
          </Select>
          <Select v-model="formCategory.parentId2" style="width:150px">
            <Option v-for="category in secondCategorys" :value="category.id" :key="category.id">{{ category.name }}
            </Option>
          </Select>
        </FormItem>
        <FormItem>
          <Button :loading="loading" type="primary" @click="handleSubmit('createCategoryForm')">保 存</Button>
          <Button @click="modal = false" style="margin-left: 10px;">取 消</Button>
        </FormItem>
      </Form>
    </Modal>
    <div class="drag-box-card">
      <Row>
        <Button v-if="isAuth('goods:category:add:button')" @click="showAdd(null)" style="margin-left: 10px;">新增类目</Button>
        <b>这儿只是随便写写，方便一开始录入数据，主要的重心不在这儿，设置一次万年不变，三个类目直接不能相互拖拽，修改数据也不会自动刷新，有兴趣的可以自己去实现</b>
      </Row>
      <Row>
        <Col span="8">
        <h3>一级类目</h3>
        <draggable class="drop-box1 drop-box" :options="options" :value="dataList" @input="handleListChange($event)"
                   @end="handleEnd($event)">
          <div class="drag-list-item" v-for="(item, index) in dataList" :key="`drag_li1_${index}`">
            <Card class="drag-item">{{ item.name}}
              <a @click="chooseFirst(item.id)" style="float:right;">选择</a>
              <a v-if="isAuth('goods:category:edit:button')" @click="showAdd(item.id)" style="float:right;margin-right: 10px;">修改</a>
            </Card>
          </div>
        </draggable>
        </Col>
        <Col span="8">
        <h3>二级类目</h3>
        <draggable class="drop-box1 drop-box" :options="options" :value="dataListSecond"
                   @input="handleListChange1($event)"
                   @end="handleEnd1($event)">
          <div class="drag-list-item" v-for="(item, index) in dataListSecond" :key="`drag_li1_${index}`">
            <Card class="drag-item" slot="left">{{ item.name}}
              <a @click="chooseSencod(item.id)" style="float:right;">选择</a>
              <a v-if="isAuth('goods:category:edit:button')" @click="showAdd(item.id)" style="float:right;margin-right: 10px;">修改</a>
            </Card>
          </div>
        </draggable>
        </Col>
        <Col span="8">
        <h3>三级类目</h3>
        <draggable class="drop-box1 drop-box" :options="options" :value="dataListThird"
                   @input="handleListChange2($event)"
                   @end="handleEnd2($event)">
          <div class="drag-list-item" v-for="(item, index) in dataListThird" :key="`drag_li1_${index}`">
            <Card class="drag-item" slot="left">{{ item.name}}
              <a v-if="isAuth('goods:category:edit:button')" @click="showAdd(item.id)" style="float:right;margin-right: 10px;">修改</a></Card>
          </div>
        </draggable>
        </Col>
      </Row>
    </div>
  </div>
</template>
<script>
  import draggable from 'vuedraggable';
  export default {
    components: {
      draggable,
    },
    data () {
      return {
        loading: false,
        formCategory: {
          id: null,
          name: '',
          parentId: 0,
          parentId1: null,
          parentId2: null,
        },
        options: {group: 'drag_list'},
        modal: false,
        dataList: [],
        dataListSecond: [],
        dataListThird: [],
        dataList1: [],
        firstCategorys: [],
        secondCategorys: [],
      }
    },
    methods: {
      change(id) {
        this.$http({
          url: this.$http.adornUrl('category/queryCategory', 2),
          method: 'post',
          data: this.$http.adornData({
            'pageSize': 1000000,
            'parentId': id,
            'isDeleted': false,
          })
        }).then(({data}) => {
          if (data && data.code === 200 && data.dataMap.totalRecords > 0) {
            this.secondCategorys = data.dataMap.records;
          } else {
            this.secondCategorys = [];
          }
        });
      },
      chooseFirst(id){
        this.dataListThird = [];
        this.$http({
          url: this.$http.adornUrl('category/queryCategory', 2),
          method: 'post',
          data: this.$http.adornData({
            'pageSize': 100000,
            'parentId': id,
            'isDeleted': false,
          })
        }).then(({data}) => {
          if (data && data.code === 200 && data.dataMap.totalRecords > 0) {
            this.dataListSecond = data.dataMap.records;
          } else {
            this.dataListSecond = [];
          }
        });
      },
      chooseSencod(id){
        this.$http({
          url: this.$http.adornUrl('category/queryCategory', 2),
          method: 'post',
          data: this.$http.adornData({
            'pageSize': 100000,
            'parentId': id,
            'isDeleted': false,
          })
        }).then(({data}) => {
          if (data && data.code === 200 && data.dataMap.totalRecords > 0) {
            this.dataListThird = data.dataMap.records;
          } else {
            this.dataListThird = [];
          }
        });
      },
      showAdd(id){
        let t = this;
        t.loading = false;
        t.modal = true;
        t.formCategory.id = id;

        t.$http({
          url: t.$http.adornUrl('category/queryCategory', 2),
          method: 'post',
          data: this.$http.adornData({
            'pageSize': 1000000,
            'parentId': 0,
            'isDeleted': false,
          })
        }).then(({data}) => {
          if (data && data.code === 200 && data.dataMap.totalRecords > 0) {
            t.firstCategorys = data.dataMap.records;
          } else {
            t.firstCategorys = [];
          }
        }).then(function () {
          if (id) {
            t.$http({
              url: t.$http.adornUrl(`category/getCategory/` + id, 2),
              method: 'get',
              data: t.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 200) {
                t.formCategory.name = data.dataMap.name;
                t.formCategory.parentId = data.dataMap.parentId;
                t.formCategory.parentId1 = data.dataMap.parentId;
                t.formCategory.parentId2 = data.dataMap.parentId;
              }
            });
          } else {
            t.formCategory.name = '';
            t.formCategory.parentId = 0;
            t.formCategory.parentId1 = null;
            t.formCategory.parentId2 = null;
          }
        });


      },
      handleSubmit(name) {
        let t = this;
        this.$refs[name].validate((valid) => {
          if (valid) {
            t.loading = true;
            if (t.formCategory.parentId2) {
              t.formCategory.parentId = t.formCategory.parentId2;
            } else if (t.formCategory.parentId1) {
              t.formCategory.parentId = t.formCategory.parentId1;
            }
            if (this.formCategory.id) {
              t.formCategory.parentId = null;
            }
            this.$http({
              url: this.$http.adornUrl(`category/${!this.formCategory.id ? 'createCategory' : 'updateCategory'}`, 2),
              method: 'post',
              data: this.$http.adornData(this.formCategory)
            }).then(({data}) => {
              if (data && data.code === 200) {
                this.$Message.success({
                  content: '操作成功',
                  duration: 2,
                  onClose: function () {
                    t.modal = false;
                    t.getDataList();
                  }
                });
              } else {
                t.loading = false;
              }
            });
          }
        });
      },
      getDataList(){
        this.$http({
          url: this.$http.adornUrl('category/queryCategory', 2),
          method: 'post',
          data: this.$http.adornData({
            'pageSize': 100000,
            'parentId': 0,
            'isDeleted': false,
          })
        }).then(({data}) => {
          if (data && data.code === 200 && data.dataMap.totalRecords > 0) {
            this.dataList = data.dataMap.records;
          } else {
            this.dataList = [];
          }
        })
      },
      handleListChange (value) {
        this.dataList = value;
      },
      handleEnd (event) {
        this.$http({
          url: this.$http.adornUrl('category/sort', 2),
          method: 'post',
          data: this.dataList
        }).then(({data}) => {
          if (data && data.code === 200) {
          } else {
          }
        })
      },
      handleListChange1 (value) {
        this.dataListSecond = value;
      },
      handleEnd1 (event) {
        this.$http({
          url: this.$http.adornUrl('category/sort', 2),
          method: 'post',
          data: this.dataListSecond
        }).then(({data}) => {
          if (data && data.code === 200) {
          } else {
          }
        })
      },
      handleListChange2 (value) {
        this.dataListThird = value;
      },
      handleEnd2 (event) {
        this.$http({
          url: this.$http.adornUrl('category/sort', 2),
          method: 'post',
          data: this.dataListThird
        }).then(({data}) => {
          if (data && data.code === 200) {
          } else {
          }
        })
      },
    },
    mounted () {
      this.getDataList();
    }
  }
</script>
<style lang="less">
  .drag-box-card {
    .drag-item {
      margin: 15px 20px;
      .ivu-card-body {
        padding: 10px;
      }
    }
    h3 {
      padding: 10px 15px;
    }
    .drop-box {
      border: 1px solid #eeeeee;
      border-radius: 5px;
    }
    .left-drop-box {
      margin-right: 10px;
    }
    .right-drop-box {
      //
    }
  }
</style>
