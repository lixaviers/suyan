<template>

  <div>
    <Button @click="$router.push({name: 'subPromotionIndex'});">返回订单促销列表</Button>
    <Card style="margin-top: 20px;">
      <p slot="title">订单促销详情</p>
      <p>状态：{{formSubPromotion.promotionStatusDesc}}</p>
      <p>名称：{{formSubPromotion.name}}</p>
      <p>类型：{{formSubPromotion.typeDesc}}</p>
      <p>优惠信息：{{formSubPromotion.promotion}}</p>
      <p>生效时间：{{formSubPromotion.startTime}} - {{formSubPromotion.endTime}}</p>
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
        formSubPromotion: {
          id: null,
          couponName: '默认名称',
          typeId: '',
          typeDesc: '',
          promotionStatusDesc: '',
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
          promotionStatus: 1,
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
          url: this.$http.adornUrl('subPromotion/getSubPromotion/' + id),
          method: 'get',
          data: this.$http.adornData()
        }).then(({data}) => {
          if (data && data.code === 200 && data.dataMap) {
            this.formSubPromotion.id = id;
            this.formSubPromotion = data.dataMap;
            this.formSubPromotion.startTime = dateFormat(this.formSubPromotion.startTime);
            this.formSubPromotion.endTime = dateFormat(this.formSubPromotion.endTime);

            if (this.formSubPromotion.typeId === 51) {
              var promotion = '订单满' + this.formSubPromotion.orderFullAmount + '元减' + this.formSubPromotion.promotionAmount + '元';
              if (this.formSubPromotion.promotionMaxAmount) {
                promotion += '，封顶'+ this.formSubPromotion.promotionMaxAmount +'元';
              }
              this.formSubPromotion.promotion = promotion;
            } else if (this.formSubPromotion.typeId === 52) {
              var promotion = '订单每满' + this.formSubPromotion.orderFullAmount + '元减' + this.formSubPromotion.promotionAmount + '元';
              if (this.formSubPromotion.promotionMaxAmount) {
                promotion += '，封顶'+ this.formSubPromotion.promotionMaxAmount +'元';
              }
              this.formSubPromotion.promotion = promotion;
            } else if (this.formSubPromotion.typeId === 53) {
              this.formSubPromotion.discountAmount = this.formSubPromotion.discountAmount * 10;
              var promotion = '订单满' + this.formSubPromotion.orderFullAmount + '元' + this.formSubPromotion.discountAmount + '折';
              if (this.formSubPromotion.promotionMaxAmount) {
                promotion += '，封顶'+ this.formSubPromotion.promotionMaxAmount +'元';
              }
              this.formSubPromotion.promotion = promotion;
            }
          }
        });
      }
    },
    methods: {
    }
  }
</script>
