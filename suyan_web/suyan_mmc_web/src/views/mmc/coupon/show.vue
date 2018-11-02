<template>

  <div style="padding-right: 20px;">
    <Button @click="$router.push({name: 'mmcCouponIndex'});">返回优惠券列表</Button>
    <Card style="margin-top: 20px;">
      <p slot="title">优惠券详情</p>
      <p>状态：{{formCoupon.couponStatusDesc}}</p>
      <p>名称：{{formCoupon.couponName}}</p>
      <p>类型：{{formCoupon.typeDesc}}</p>
      <p>优惠信息：{{formCoupon.promotion}}</p>
      <p>生效时间：{{formCoupon.startTime}} - {{formCoupon.endTime}}</p>
      <p>每人可领张数：{{formCoupon.personLimit}}</p>
      <p>订单可以使用张数：{{formCoupon.orderLimit}}</p>
    </Card>
    <Card style="margin-top: 20px;">
      <p slot="title">发券详情</p>
      <p>发券总数量：{{formCoupon.issueTotalAmount}}</p>
      <p>发券时间：{{formCoupon.issueStartTime }} - {{formCoupon.issueEndTime}}</p>
      <p>每人可领张数：{{formCoupon.personLimit}}</p>
      <p>订单可以使用张数：{{formCoupon.orderLimit}}</p>
    </Card>
  </div>



</template>
<script>
  import {dateFormat} from '@/utils';
  export default {
    data () {
      return {
        loadingSave: false,
        loadingOnline: false,
        formCoupon: {
          id: null,
          couponName: '默认名称',
          typeId: '',
          typeDesc: '',
          couponStatusDesc: '',
          promotion: '',
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
            this.formCoupon.startTime = dateFormat(this.formCoupon.startTime);
            this.formCoupon.endTime = dateFormat(this.formCoupon.endTime);
            this.formCoupon.issueStartTime = dateFormat(this.formCoupon.issueStartTime);
            this.formCoupon.issueEndTime = dateFormat(this.formCoupon.issueEndTime);

            if (this.formCoupon.typeId === 1) {
              this.formCoupon.promotion = '立减' + this.formCoupon.promotionAmount + '元';
            } else if (this.formCoupon.typeId === 2) {
              var promotion = '订单满' + this.formCoupon.orderFullAmount + '元减' + this.formCoupon.promotionAmount + '元';
              if (this.formCoupon.promotionMaxAmount) {
                promotion += '，封顶'+ this.formCoupon.promotionMaxAmount +'元';
              }
              this.formCoupon.promotion = promotion;
            } else if (this.formCoupon.typeId === 3) {
              var promotion = '订单每满' + this.formCoupon.orderFullAmount + '元减' + this.formCoupon.promotionAmount + '元';
              if (this.formCoupon.promotionMaxAmount) {
                promotion += '，封顶'+ this.formCoupon.promotionMaxAmount +'元';
              }
              this.formCoupon.promotion = promotion;
            } else if (this.formCoupon.typeId === 4) {
              this.formCoupon.discountAmount = this.formCoupon.discountAmount * 10;
              var promotion = '订单满' + this.formCoupon.orderFullAmount + '元' + this.formCoupon.discountAmount + '折';
              if (this.formCoupon.promotionMaxAmount) {
                promotion += '，封顶'+ this.formCoupon.promotionMaxAmount +'元';
              }
              this.formCoupon.promotion = promotion;
            }
          }
        });
      }
    },
    methods: {
    }
  }
</script>
