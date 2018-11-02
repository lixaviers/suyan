<template>
  <Form style="margin-top: 10px; padding-right: 20px;" ref="createCouponForm" :rules="ruleValidate" :model="formCoupon" :label-width="150">
    <FormItem label="优惠券名称" prop="couponName">
      <Input v-model="formCoupon.couponName" placeholder="优惠券名称" style="width: 240px"/>
    </FormItem>
    <FormItem label="优惠券类型" prop="typeId">
      <Select v-model="formCoupon.typeId" style="width: 240px">
        <Option value="1">无门槛现金抵用券</Option>
        <Option value="2">满减券</Option>
        <Option value="3">每满减券</Option>
        <Option value="4">折扣券</Option>
      </Select>
    </FormItem>
    <FormItem v-show="formCoupon.typeId == 1">
      减
      <InputNumber :max="100000000" :min="0.01" placeholder="促销金额" v-model="formCoupon.promotionAmount"
                   style="width: 120px"/>
      元
    </FormItem>
    <FormItem v-show="formCoupon.typeId == 2 || formCoupon.typeId == 3">
      <label v-show="formCoupon.typeId == 2">订单满
        <InputNumber :max="100000000" :min="0.01" placeholder="订单满金额" v-model="formCoupon.orderFullAmount"
                     style="width: 120px"/>
        元</label>
      <label v-show="formCoupon.typeId == 3">订单每满
        <InputNumber :max="100000000" :min="0.01" placeholder="订单每满金额" v-model="formCoupon.orderFullAmount"
                     style="width: 120px"/>
        元</label>
      <label style="padding-left: 10px;">减
        <InputNumber :max="100000000" :min="0.01" placeholder="促销金额" v-model="formCoupon.promotionAmount"
                     style="width: 120px"/>
        元</label>
      <label style="padding-left: 10px;">封顶
        <InputNumber :max="100000000" :min="0.01" placeholder="封顶金额" v-model="formCoupon.promotionMaxAmount"
                     style="width: 120px"/>
        元</label>
    </FormItem>
    <FormItem v-show="formCoupon.typeId == 4">
      <label>订单满
        <InputNumber v-model="formCoupon.orderFullAmount" placeholder="订单满金额" :max="100000000" :min="0.01"
                     style="width: 120px"/>
        元</label>
      <label style="padding-left: 10px;">
        <InputNumber v-model="formCoupon.discountAmount" placeholder="折扣金额" :max="100000000" :min="0.01"
                     style="width: 120px"/>
        折</label>
    </FormItem>
    <FormItem label="发券时间" prop="issueTime">
      <DatePicker v-model="formCoupon.issueTime" type="datetimerange" format="yyyy-MM-dd HH:mm" placeholder="发券时间"
                  style="width: 300px"></DatePicker>
    </FormItem>
    <FormItem label="生效时间" prop="time">
      <DatePicker v-model="formCoupon.time" type="datetimerange" format="yyyy-MM-dd HH:mm" placeholder="生效时间"
                  style="width: 300px"></DatePicker>
    </FormItem>
    <FormItem label="使用类型" prop="useType">
      <RadioGroup v-model="formCoupon.useType">
        <Radio label="1">免费</Radio>
        <Radio label="2">付费</Radio>
      </RadioGroup>
    </FormItem>
    <FormItem v-show="formCoupon.useType == 2" label="价格" prop="price">
      <InputNumber :max="100000000" :min="0.01" v-model="formCoupon.price" placeholder="价格" style="width: 240px"/>
      元
    </FormItem>
    <FormItem label="发券总数量" prop="issueTotalAmount">
      <InputNumber :max="1000000" :min="1" v-model="formCoupon.issueTotalAmount" style="width: 240px"/>
    </FormItem>
    <FormItem label="每人可领张数" prop="personLimit">
      <InputNumber :max="10000" :min="1" v-model="formCoupon.personLimit" style="width: 240px"/>
    </FormItem>
    <FormItem label="每订单可以使用张数" prop="orderLimit">
      <InputNumber :max="10000" :min="1" v-model="formCoupon.orderLimit" style="width: 240px"/>
    </FormItem>
    <FormItem>
      <Button :loading="loadingSave" type="primary" @click="handleSubmit('createCouponForm', 1)">保 存</Button>
      <Button :loading="loadingOnline" type="success" @click="handleSubmit('createCouponForm', 2)"
              style="margin-left: 15px;">上 线
      </Button>
      <Button @click="$router.push({name: 'mmcCouponIndex'});" style="margin-left: 15px;">返回优惠券列表</Button>
    </FormItem>
  </Form>
</template>
<script>
  export default {
    data () {
      return {
        loadingSave: false,
        loadingOnline: false,
        formCoupon: {
          id: null,
          couponName: '默认名称',
          typeId: '1',
          promotionAmount: null,
          orderFullAmount: null,
          promotionMaxAmount: null,
          discountAmount: null,
          issueStartTime: '',
          issueEndTime: '',
          issueTime: '',
          time: '',
          startTime: '',
          endTime: '',
          useType: '1',
          price: null,
          issueTotalAmount: 1,
          personLimit: 1,
          orderLimit: 1,
          couponStatus: 1,
        },
        ruleValidate: {
          couponName: [
            {required: true, message: '优惠券名称不能为空', trigger: 'blur'}
          ],
          typeId: [
            {required: true, message: '优惠券类型不能为空', trigger: 'blur'}
          ],
        }
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
