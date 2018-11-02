import Vue from 'vue';
import Router from 'vue-router';

Vue.use(Router);

const _import = require('./import-' + process.env.NODE_ENV);


export default new Router({
  routes: [
    {
      path: '/',
      name: 'main',
      component : _import('mmc/coupon/index'),
      redirect: {name: 'mmcCouponIndex'},
      children:[
        {path: 'mmc/coupon/index', component: _import('mmc/coupon/index'), name: 'mmcCouponIndex'},
      ]
    },
    {
      path: '/mmc/coupon/create',
      name: 'mmcCouponCreate',
      component : _import('mmc/coupon/create')
    },
    {
      path: '/mmc/coupon/show',
      name: 'mmcCouponShow',
      component : _import('mmc/coupon/show')
    },
    {
      path: '/mmc/subPromotion/index',
      name: 'mmcSubPromotionIndex',
      component : _import('mmc/subPromotion/index')
    },
    {
      path: '/mmc/subPromotion/show',
      name: 'mmcSubPromotionShow',
      component : _import('mmc/subPromotion/show')
    },
    {
      path: '/mmc/subPromotion/create',
      name: 'mmcSubPromotionCreate',
      component : _import('mmc/subPromotion/create')
    },


    {
      path: '/goods/create',
      name: 'goodsCreate',
      component : _import('goods/create')
    },
    {
      path: '/goods/category/index',
      name: 'goodsCategoryIndex',
      component : _import('goods/category/index')
    },
  ]
})


