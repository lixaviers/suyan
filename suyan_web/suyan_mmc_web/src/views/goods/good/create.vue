<template>
  <div>
    <Button @click="$router.push({name: 'goodsGoodPublish', params: {categoryId: categoryId}});" :disabled="disabled"
            type="primary">我已阅读以下规则，现在发布宝贝
    </Button>
    <Row style="margin-top: 20px;">
      <div class="first-category">
        <h3 class="title">一级类目</h3>
        <a v-on:click="click(item.id, item.name, 1)" v-for="(item, index) in dataList"
           class="drag-item">{{ item.name}}</a>
      </div>
      <div v-show="dataListSecond && dataListSecond.length > 0" class="second-category">
        <h3 class="title">{{ title }}</h3>
        <a v-on:click="click(item.id, item.name, 2)" v-for="(item, index) in dataListSecond"
           class="drag-item">{{ item.name}}</a>
      </div>
      <div v-show="dataListThird && dataListThird.length > 0" class="second-category">
        <h3 class="title">{{ title1 }}</h3>
        <a v-on:click="click(item.id, item.name, 3)" v-for="(item, index) in dataListThird"
           class="drag-item">{{ item.name}}</a>
      </div>
    </Row>
  </div>
</template>
<script>
  export default {
    data () {
      return {
        dataList: [],
        dataListSecond: [],
        dataListThird: [],
        title: '',
        title1: '',
        disabled: true,
        categoryId: null,
      }
    },
    created () {
      this.getDataList();
    },
    methods: {
      click(id, name, type){
        this.disabled = true;
        if (type == 3) {
          this.categoryId = id;
          this.disabled = false;
          return;
        } else if (type == 1) {
          this.title = name;
        } else if (type == 2) {
          this.title1 = name;
        }
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
          if (type == 1) {
            if (data && data.code === 200 && data.dataMap.totalRecords > 0) {
              this.dataListSecond = data.dataMap.records;
            } else {
              this.dataListSecond = [];
            }
          } else if (type == 2) {
            if (data && data.code === 200) {
              if (data.dataMap.totalRecords > 0) {
                this.dataListThird = data.dataMap.records;
              } else {
                this.categoryId = id;
                this.disabled = false;
              }
            } else {
              this.dataListThird = [];
            }
          }


        });
      },
      getDataList(){
        this.$http({
          url: this.$http.adornUrl('category/queryCategory', 2),
          method: 'post',
          data: this.$http.adornData({
            'pageSize': 1000000,
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
      }
    }
  }
</script>

<style lang="less">
  .second-category {
    margin-left: 20px;
  }

  .first-category, .second-category {
    width: 240px;
    float: left;
    border: 1px solid #dcdee2;
    border-radius: 4px;
    .title {
      margin: 10px 20px;
    }
    .drag-item {
      display: block;
      margin: 10px 20px;
      border: 1px solid #dcdee2;
      border-radius: 4px;
      padding: 10px;
    }
    .drag-item.active {
      background: #eee;
    }
    .drag-item:hover {
      box-shadow: 0 1px 6px rgba(0, 0, 0, .2);
      border-color: #eee;
    }
  }

</style>
