<template>
  <Form style="margin-top: 10px; padding-right: 20px;" ref="createCouponForm" :rules="ruleValidate" :model="formCoupon" :label-width="150">
    <Cascader :data="data" v-model="value1"></Cascader>
  </Form>
</template>
<script>
  export default {
    data () {
      return {
        formCoupon:{},
        ruleValidate: {},
        value1: [],
        data: [{
          value: 'beijing',
          label: '北京',
          children: [
            {
              value: 'gugong',
              label: '故宫'
            },
            {
              value: 'tiantan',
              label: '天坛'
            },
            {
              value: 'wangfujing',
              label: '王府井'
            }
          ]
        }, {
          value: 'jiangsu',
          label: '江苏',
          children: [
            {
              value: 'nanjing',
              label: '南京',
              children: [
                {
                  value: 'fuzimiao',
                  label: '夫子庙',
                }
              ]
            },
            {
              value: 'suzhou',
              label: '苏州',
              children: [
                {
                  value: 'zhuozhengyuan',
                  label: '拙政园',
                },
                {
                  value: 'shizilin',
                  label: '狮子林',
                }
              ]
            }
          ],
        }]
      }
    },
    created () {
      let id = this.$route.params.id;
      if (id) {
        this.$http({
          url: this.$http.adornUrl('coupon/getCoupon/' + id),
          method: 'get',
          data: this.$http.adornData()
        }).then(({data}) => {
          if (data && data.code === 200 && data.dataMap) {
            this.formCoupon.id = id;
            this.formCoupon = data.dataMap;
            this.formCoupon.typeId = data.dataMap.typeId + '';
            this.formCoupon.useType = data.dataMap.useType + '';
            this.formCoupon.issueTime = [this.formCoupon.issueStartTime, this.formCoupon.issueEndTime];
            this.formCoupon.time = [this.formCoupon.startTime, this.formCoupon.endTime];
            this.formCoupon.discountAmount = this.formCoupon.discountAmount * 10;
            console.log(this.formCoupon)
          }
        });
      }
    },
    methods: {
      handleSubmit (name, couponStatus) {
        let t = this;
        this.$refs[name].validate((valid) => {
          if (valid) {
            var typeId = this.formCoupon.typeId;
            var promotionAmount = this.formCoupon.promotionAmount;
            var orderFullAmount = this.formCoupon.orderFullAmount;
            var discountAmount = this.formCoupon.discountAmount;
            var promotionMaxAmount = this.formSubPromotion.promotionMaxAmount;
            if (typeId = 1 && !promotionAmount) {
              this.$Message.error({content: '促销金额不能为空', duration: 2});
              return;
            }
            if (typeId == 2) {
              if (!orderFullAmount) {
                this.$Message.error({content: '订单满金额不能为空', duration: 2});
                return;
              }
              if (!promotionAmount) {
                this.$Message.error({content: '促销金额不能为空', duration: 2});
                return;
              }
              if (orderFullAmount <= promotionAmount) {
                this.$Message.error({content: '订单满金额必须大于促销金额', duration: 2});
                return;
              }
              if (!!promotionMaxAmount) {
                if (promotionMaxAmount < promotionAmount) {
                  this.$Message.error({content: '封顶金额不能小于促销金额', duration: 2});
                  return;
                }
                if (promotionMaxAmount % promotionAmount != 0) {
                  this.$Message.error({content: '封顶金额必须是促销金额的整数倍', duration: 2});
                  return;
                }
              }
            }
            if (typeId == 3) {
              if (!orderFullAmount) {
                this.$Message.error({content: '订单每满金额不能为空', duration: 2});
                return;
              }
              if (!promotionAmount) {
                this.$Message.error({content: '促销金额不能为空', duration: 2});
                return;
              }
              if (orderFullAmount <= promotionAmount) {
                this.$Message.error({content: '订单满金额必须大于促销金额', duration: 2});
                return;
              }
              if (!!promotionMaxAmount) {
                if (promotionMaxAmount < promotionAmount) {
                  this.$Message.error({content: '封顶金额不能小于促销金额', duration: 2});
                  return;
                }
                if (promotionMaxAmount % promotionAmount != 0) {
                  this.$Message.error({content: '封顶金额必须是促销金额的整数倍', duration: 2});
                  return;
                }
              }
            }
            if (typeId == 4) {
              if (!orderFullAmount) {
                this.$Message.error({content: '订单满金额不能为空', duration: 2});
                return;
              }
              if (!discountAmount) {
                this.$Message.error({content: '折扣金额不能为空', duration: 2});
                return;
              }
            }
            if (!this.formCoupon.issueTime[0] || !this.formCoupon.issueTime[1]) {
              this.$Message.error({content: '请选择发券时间', duration: 2});
              return;
            }
            if (!this.formCoupon.time[0] || !this.formCoupon.time[1]) {
              this.$Message.error({content: '请选择生效时间', duration: 2});
              return;
            }
            this.formCoupon.issueStartTime = this.formCoupon.issueTime[0];
            this.formCoupon.issueEndTime = this.formCoupon.issueTime[1];
            this.formCoupon.startTime = this.formCoupon.time[0];
            this.formCoupon.endTime = this.formCoupon.time[1];
            if (this.formCoupon.issueStartTime > this.formCoupon.startTime) {
              this.$Message.error({
                content: '发券开始时间必须小于等于生效开始时间',
                duration: 2
              });
              return;
            }
            if (this.formCoupon.issueEndTime > this.formCoupon.endTime) {
              this.$Message.error('发券结束时间必须小于等于生效结束时间');
              return;
            }
            var issueTotalAmount = this.formCoupon.issueTotalAmount;
            if (!issueTotalAmount) {
              this.$Message.error('发券总数量不能为空');
              return;
            }
            var personLimit = this.formCoupon.personLimit;
            if (!personLimit) {
              this.$Message.error('每人可领张数不能为空');
              return;
            }
            var orderLimit = this.formCoupon.orderLimit;
            if (!orderLimit) {
              this.$Message.error('发券总数量不能为空');
              return;
            }

            if (couponStatus == 1) {
              this.loadingSave = true;
            } else {
              this.loadingOnline = true;
            }
            this.formCoupon.couponStatus = couponStatus;
            console.log(this.formCoupon.id)
            this.$http({
              url: this.$http.adornUrl(`coupon/${!this.formCoupon.id ? 'createCoupon' : 'updateCoupon'}`),
              method: 'post',
              data: this.$http.adornData(this.formCoupon)
            }).then(({data}) => {
              if (data && data.code === 200) {
                this.$Message.success({
                  content: '操作成功',
                  duration: 2,
                  onClose: function () {
                    t.$router.push({name: 'mmcCouponIndex'});
                  }
                });
              } else {
                if (couponStatus == 1) {
                  this.loadingSave = false;
                } else {
                  this.loadingOnline = false;
                }
              }
            })

          }
        })
      }
    }
  }
</script>
