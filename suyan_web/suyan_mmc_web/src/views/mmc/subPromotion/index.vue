<template>
  <div style="padding-right: 20px;">
    <Form :model="dataForm" inline>
      <FormItem>
        <Input type="text" v-model="dataForm.id" placeholder="订单促销id">
        </Input>
      </FormItem>
      <FormItem>
        <Input type="text" v-model="dataForm.nameLike" placeholder="订单促销名称">
        </Input>
      </FormItem>
      <FormItem>
        <Button @click="getDataList()">查询</Button>
        <Button type="primary" @click="$router.push({name: 'mmcSubPromotionCreate'});" style="margin-left: 10px;">创建订单促销</Button>
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
            title: '类型', key: 'typeDesc'
          },
          {
            title: '生效时间', key: 'startTime', render: (h, params) => {
            return h('div',
              dateFormat(params.row.startTime)
            )
          }
          },
          {
            title: '失效时间', key: 'endTime', render: (h, params) => {
            return h('div',
              dateFormat(params.row.endTime)
            )
          }
          },
          {
            title: '状态', key: 'promotionStatusDesc', width: 120
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
              if (params.row.promotionStatus == 1) {
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
                      this.$router.push({name: 'mmcSubPromotionCreate', params: {id: params.row.id}});
                    }
                  }
                }, '编辑'));
                actionButtons.push(h('Button', {
                  style: {
                    marginLeft: '10px'
                  },
                  props: {
                    type: 'success',
                    size: 'small'
                  },
                  on: {
                    click: () => {
                      this.$Modal.confirm({
                        title: '提示 ',
                        content: '<p>确定要上线券id为'+params.row.id+'的优惠券吗？</p>',
                        onOk: () => {
                          this.$http({
                            url: this.$http.adornUrl('subPromotion/changeStatus/'+params.row.id+'/1'),
                            method: 'post'
                          }).then(({data}) => {
                            if (data && data.code === 200) {
                              this.$Message.info('操作成功');
                              this.getDataList();
                            } else {
                            }
                          })
                        },
                        onCancel: () => {}
                      });
                    }
                  }
                }, '上线'));
              }
              if (params.row.promotionStatus == 2) {
                actionButtons.push(h('Button', {
                  style: {
                    marginLeft: '10px'
                  },
                  props: {
                    type: 'warning',
                    size: 'small'
                  },
                  on: {
                    click: () => {
                      this.$Modal.confirm({
                        title: '提示 ',
                        content: '<p>确定要下线券id为'+params.row.id+'的优惠券吗？</p>',
                        onOk: () => {
                          this.$http({
                            url: this.$http.adornUrl('subPromotion/changeStatus/'+params.row.id+'/2'),
                            method: 'post'
                          }).then(({data}) => {
                            if (data && data.code === 200) {
                              this.$Message.info('操作成功');
                              this.getDataList();
                            } else {
                            }
                          })
                        },
                        onCancel: () => {}
                      });
                    }
                  }
                }, '下线'));
              }
              if (params.row.promotionStatus == 2 || params.row.promotionStatus == 3) {
                actionButtons.push(h('Button', {
                  style: {
                    marginLeft: '10px'
                  },
                  props: {
                    type: 'warning',
                    size: 'small'
                  },
                  on: {
                    click: () => {
                      this.$Modal.confirm({
                        title: '提示 ',
                        content: '<p>确定要中止券id为'+params.row.id+'的优惠券吗？</p>',
                        onOk: () => {
                          this.$http({
                            url: this.$http.adornUrl('subPromotion/changeStatus/'+params.row.id+'/3'),
                            method: 'post'
                          }).then(({data}) => {
                            if (data && data.code === 200) {
                              this.$Message.info('操作成功');
                              this.getDataList();
                            } else {
                            }
                          })
                        },
                        onCancel: () => {}
                      });
                    }
                  }
                }, '中止'));
              }
              if (params.row.promotionStatus == 2 || params.row.promotionStatus == 3 || params.row.promotionStatus == 4) {
                actionButtons.push(h('Button', {
                  style: {
                    marginLeft: '10px'
                  },
                  props: {
                    type: 'error',
                    size: 'small'
                  },
                  on: {
                    click: () => {
                      this.$Modal.confirm({
                        title: '提示 ',
                        content: '<p>确定要取消券id为'+params.row.id+'的优惠券吗？</p>',
                        onOk: () => {
                          this.$http({
                            url: this.$http.adornUrl('subPromotion/changeStatus/'+params.row.id+'/4'),
                            method: 'post'
                          }).then(({data}) => {
                            if (data && data.code === 200) {
                              this.$Message.info('操作成功');
                              this.getDataList();
                            } else {
                            }
                          })
                        },
                        onCancel: () => {}
                      });
                    }
                  }
                }, '取消'));
              }

              return h('div', actionButtons);
            }
          }
        ],
      }
    },
    mounted () {
      this.getDataList();
    },
    methods: {
      // 获取数据列表
      getDataList () {
        this.loading = true;
        this.$http({
          url: this.$http.adornUrl('subPromotion/querySubPromotion'),
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
