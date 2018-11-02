<template>
  <Form style="margin-top: 10px; padding-right: 20px;" ref="createSubPromotionForm" :rules="ruleValidate" :model="formSubPromotion"
        :label-width="150">
    <FormItem label="订单促销名称" prop="name">
      <Input v-model="formSubPromotion.name" placeholder="订单促销名称" style="width: 240px"/>
    </FormItem>
    <FormItem label="订单促销类型" prop="typeId">
      <Select v-model="formSubPromotion.typeId" style="width: 240px">
        <Option value="51">订单满减</Option>
        <Option value="52">订单叠加满减</Option>
        <Option value="53">订单折扣</Option>
      </Select>
    </FormItem>
    <FormItem v-show="formSubPromotion.typeId == 51 || formSubPromotion.typeId == 52">
      <label v-show="formSubPromotion.typeId == 51">订单满
        <InputNumber :max="100000000" :min="0.01" placeholder="订单满金额" v-model="formSubPromotion.orderFullAmount"
                     style="width: 120px"/>
        元</label>
      <label v-show="formSubPromotion.typeId == 52">订单每满
        <InputNumber :max="100000000" :min="0.01" placeholder="订单每满金额" v-model="formSubPromotion.orderFullAmount"
                     style="width: 120px"/>
        元</label>
      <label style="padding-left: 10px;">减
        <InputNumber :max="100000000" :min="0.01" placeholder="促销金额" v-model="formSubPromotion.promotionAmount"
                     style="width: 120px"/>
        元</label>
      <label style="padding-left: 10px;">封顶
        <InputNumber :max="100000000" :min="0.01" placeholder="封顶金额" v-model="formSubPromotion.promotionMaxAmount"
                     style="width: 120px"/>
        元</label>
    </FormItem>
    <FormItem v-show="formSubPromotion.typeId == 53">
      <label>订单满
        <InputNumber v-model="formSubPromotion.orderFullAmount" placeholder="订单满金额" :max="100000000" :min="0.01"
                     style="width: 120px"/>
        元</label>
      <label style="padding-left: 10px;">
        <InputNumber v-model="formSubPromotion.discountAmount" placeholder="折扣金额" :max="100000000" :min="0.01"
                     style="width: 120px"/>
        折</label>
    </FormItem>
    <FormItem label="生效时间" prop="time">
      <DatePicker v-model="formSubPromotion.time" type="datetimerange" format="yyyy-MM-dd HH:mm" placeholder="生效时间"
                  style="width: 300px"></DatePicker>
    </FormItem>
    <FormItem v-show="formSubPromotion.useType == 2" label="价格" prop="price">
      <InputNumber :max="100000000" :min="0.01" v-model="formSubPromotion.price" placeholder="价格" style="width: 240px"/>
      元
    </FormItem>
    <FormItem>
      <Button :loading="loadingSave" type="primary" @click="handleSubmit('createSubPromotionForm', 1)">保 存</Button>
      <Button :loading="loadingOnline" type="success" @click="handleSubmit('createSubPromotionForm', 2)"
              style="margin-left: 15px;">上 线
      </Button>
      <Button @click="$router.push({name: 'mmcSubPromotionIndex'});" style="margin-left: 15px;">返回订单促销列表</Button>
    </FormItem>
  </Form>
</template>
<script>
  export default {
    data () {
      return {
        loadingSave: false,
        loadingOnline: false,
        formSubPromotion: {
          id: null,
          name: '默认名称',
          typeId: '51',
          promotionAmount: null,
          orderFullAmount: null,
          promotionMaxAmount: null,
          discountAmount: null,
          time: '',
          startTime: '',
          endTime: '',
          price: null,
          promotionStatus: 1,
        },
        ruleValidate: {
          name: [
            {required: true, message: '订单促销名称不能为空', trigger: 'blur'}
          ],
          typeId: [
            {required: true, message: '订单促销类型不能为空', trigger: 'blur'}
          ],
        }
      }
    },
    created () {
      let id = this.$route.params.id;
      if (id) {
        this.$http({
          url: this.$http.adornUrl('subPromotion/getSubPromotion/' + id),
          method: 'get',
          data: this.$http.adornData()
        }).then(({data}) => {
          if (data && data.code === 200 && data.dataMap) {
            this.formSubPromotion.id = id;
            this.formSubPromotion = data.dataMap;
            this.formSubPromotion.typeId = data.dataMap.typeId + '';
            this.formSubPromotion.time = [this.formSubPromotion.startTime, this.formSubPromotion.endTime];
            this.formSubPromotion.discountAmount = this.formSubPromotion.discountAmount * 10;
            console.log(this.formSubPromotion)
          }
        });
      }
    },
    methods: {
      handleSubmit (name, promotionStatus) {
        let t = this;
        this.$refs[name].validate((valid) => {
          if (valid) {
            var typeId = this.formSubPromotion.typeId;
            var promotionAmount = this.formSubPromotion.promotionAmount;
            var orderFullAmount = this.formSubPromotion.orderFullAmount;
            var discountAmount = this.formSubPromotion.discountAmount;
            var promotionMaxAmount = this.formSubPromotion.promotionMaxAmount;
            if (typeId == 51) {
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
            if (typeId == 52) {
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
            if (typeId == 53) {
              if (!orderFullAmount) {
                this.$Message.error({content: '订单满金额不能为空', duration: 2});
                return;
              }
              if (!discountAmount) {
                this.$Message.error({content: '折扣金额不能为空', duration: 2});
                return;
              }
            }
            if (!this.formSubPromotion.time[0] || !this.formSubPromotion.time[1]) {
              this.$Message.error({content: '请选择生效时间', duration: 2});
              return;
            }
            this.formSubPromotion.startTime = this.formSubPromotion.time[0];
            this.formSubPromotion.endTime = this.formSubPromotion.time[1];

            if (promotionStatus == 1) {
              this.loadingSave = true;
            } else {
              this.loadingOnline = true;
            }
            this.formSubPromotion.promotionStatus = promotionStatus;
            console.log(this.formSubPromotion.id)
            this.$http({
              url: this.$http.adornUrl(`subPromotion/${!this.formSubPromotion.id ? 'createSubPromotion' : 'updateSubPromotion'}`),
              method: 'post',
              data: this.$http.adornData(this.formSubPromotion)
            }).then(({data}) => {
              if (data && data.code === 200) {
                this.$Message.success({
                  content: '操作成功',
                  duration: 2,
                  onClose: function () {
                    t.$router.push({name: 'mmcSubPromotionIndex'});
                  }
                });
              } else {
                if (promotionStatus == 1) {
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
