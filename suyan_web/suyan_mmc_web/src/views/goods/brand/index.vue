<template>
  <div style="padding-right: 20px;">
    <Form :model="dataForm" inline>
      <FormItem>
        <Input type="text" v-model="dataForm.id" placeholder="品牌id">
        </Input>
      </FormItem>
      <FormItem>
        <Input type="text" v-model="dataForm.nameLike" placeholder="品牌名称">
        </Input>
      </FormItem>
      <FormItem>
        <Button @click="getDataList()">查询</Button>
        <Button v-if="isAuth('goods:brand:add:button')" type="primary" @click="$router.push({name: 'goodsBrandCreate'});" style="margin-left: 10px;">创建品牌
        </Button>
      </FormItem>
    </Form>
    <Table border :columns="columns" :data="dataList" :loading="loading"/>
    <Page :total="totalRecords" @on-change="currentChangeHandle" @on-page-size-change="sizeChangeHandle"
          show-elevator show-sizer show-total style="margin-top: 20px;"/>

  </div>
</template>

<script>
  import {dateFormat} from '@/utils';
  export default {
    data () {
      return {
        dataForm: {
          id: '',
          nameLike: '',
        },
        dataList: [],
        loading: false,
        pageIndex: 1,
        pageSize: 10,
        totalRecords: 0,
        columns: [
          {
            title: 'id', key: 'id', width: 80,
          },
          {
            title: '名称', key: 'name'
          },
          {
            title: '英文名称', key: 'nameEn'
          },
          {
            title: '操作',
            key: 'action',
            fixed: 'right',
            width: 240,
            render: (h, params) => {

              var actionButtons = [h('Button', {
                props: {
                  size: 'small'
                },
                on: {
                  click: () => {
                    this.$router.push({name: 'mmcSubPromotionShow', params: {id: params.row.id}});
                  }
                }
              }, '查看')];
              if(this.isAuth('goods:brand:edit:button')) {
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
                      this.$router.push({name: 'goodsBrandCreate', params: {id: params.row.id}});
                    }
                  }
                }, '编辑'));
              }

              return h('div', actionButtons);
            }
          }
        ],
      }
    },
    mounted () {
      let token = this.$route.query.token;
      if (token) {
        sessionStorage.setItem('access_token', token);
      }
      this.getDataList();
    },
    methods: {
      // 获取数据列表
      getDataList () {
        this.loading = true;
        this.$http({
          url: this.$http.adornUrl('brand/queryBrand', 2),
          method: 'post',
          data: this.$http.adornData({
            'pageNo': this.pageIndex,
            'pageSize': this.pageSize,
            'isDeleted': false,
            'orderBy': 'id',
            'order': 'desc',
            'id': this.dataForm.id,
            'nameLike': this.dataForm.nameLike,
          })
        }).then(({data}) => {
          if (data && data.code === 200 && data.dataMap.totalRecords > 0) {
            this.dataList = data.dataMap.records;
            this.totalRecords = data.dataMap.totalRecords;
          } else {
            this.dataList = []
            this.totalRecords = 0
          }
          this.loading = false;
        })
      },
      // 每页数
      sizeChangeHandle (val) {
        this.pageSize = val
        this.pageIndex = 1
        this.getDataList()
      },
      // 当前页
      currentChangeHandle (val) {
        this.pageIndex = val
        this.getDataList()
      },
      // 新增 / 修改
      addOrUpdateHandle (id) {
        this.addOrUpdateVisible = true;
        this.$nextTick(() => {
          this.$refs.addOrUpdate.init(id);
        })
      },
      // 删除
      deleteHandle (id) {
        this.$confirm(`确定要进行删除操作?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$http({
            url: this.$http.adornUrl('role/deleteRole/' + id),
            method: 'post'
          }).then(({data}) => {
            if (data && data.code === 200) {
              this.$message({
                message: '操作成功',
                type: 'success',
                duration: 1000,
                onClose: () => {
                  this.getDataList()
                }
              })
            } else {
              this.$message.error(data.msg)
            }
          })
        }).catch(() => {
        })
      },
      //时间格式化
      dateFormat: function (row, column) {
        var date = row[column.property];
        if (date == undefined) {
          return "";
        }
        return dateFormat(date);
      }
    }
  }
</script>
