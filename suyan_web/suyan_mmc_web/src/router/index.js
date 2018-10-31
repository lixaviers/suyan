import Vue from 'vue';
import Router from 'vue-router';

Vue.use(Router);

const _import = require('./import-' + process.env.NODE_ENV);


export default new Router({
  routes: [
    {
      path: '/',
      name: 'main',
      component : _import('coupon/index'),
      redirect: {name: 'couponIndex'},
      children:[
        {path: 'coupon/index', component: _import('coupon/index'), name: 'couponIndex'},
      ]
    },
    {
      path: '/coupon/create',
      name: 'couponCreate',
      component : _import('coupon/create')
    },
    {
      path: '/coupon/show',
      name: 'couponShow',
      component : _import('coupon/show')
    },
    {
      path: '/subPromotion/index',
      name: 'subPromotionIndex',
      component : _import('subPromotion/index')
    },
    {
      path: '/subPromotion/show',
      name: 'subPromotionShow',
      component : _import('subPromotion/show')
    },
    {
      path: '/subPromotion/create',
      name: 'subPromotionCreate',
      component : _import('subPromotion/create')
    }
  ]
})

