import Vue from 'vue';
import Notice from 'iview/src/components/notice';
import Router from 'vue-router';
import http from '@/utils/httpRequest';

Vue.use(Router);

const _import = require('./import-' + process.env.NODE_ENV);


const router = new Router({
  routes: [
    {
      path: '/',
      name: 'main',
      component: _import('mmc/coupon/index'),
      redirect: {name: 'mmcCouponIndex'},
      children: [
        {path: 'mmc/coupon/index', component: _import('mmc/coupon/index'), name: 'mmcCouponIndex'},
      ]
    },
    {
      path: '/mmc/coupon/create',
      name: 'mmcCouponCreate',
      component: _import('mmc/coupon/create')
    },
    {
      path: '/mmc/coupon/show',
      name: 'mmcCouponShow',
      component: _import('mmc/coupon/show')
    },
    {
      path: '/mmc/subPromotion/index',
      name: 'mmcSubPromotionIndex',
      component: _import('mmc/subPromotion/index')
    },
    {
      path: '/mmc/subPromotion/show',
      name: 'mmcSubPromotionShow',
      component: _import('mmc/subPromotion/show')
    },
    {
      path: '/mmc/subPromotion/create',
      name: 'mmcSubPromotionCreate',
      component: _import('mmc/subPromotion/create')
    },


    {
      path: '/goods/create',
      name: 'goodsCreate',
      component: _import('goods/create')
    },
    {
      path: '/goods/category/index',
      name: 'goodsCategoryIndex',
      component: _import('goods/category/index')
    },
    {
      path: '/goods/brand/index',
      name: 'goodsBrandIndex',
      component: _import('goods/brand/index')
    },
    {
      path: '/goods/brand/create',
      name: 'goodsBrandCreate',
      component: _import('goods/brand/create')
    },
    {
      path: '/goods/brand/show',
      name: 'goodsBrandShow',
      component: _import('goods/brand/show')
    },
  ]
});


router.beforeEach((to, from, next) => {
  var token = sessionStorage.getItem('access_token');
  if (!token) {
    token = getParam('token');
    var token_type = getParam('token_type');
    if (!token) {
      Notice.error({
        title: '用户未登录，在此处跳转登录页'
      });
    }
    sessionStorage.setItem('access_token', token);
    sessionStorage.setItem('token_type', token_type);
  }
  var permissions = sessionStorage.getItem('permissions');
  if (!permissions) {
    // 获取权限
    http({
      url: http.adornUrl('resource/nav', 0),
      method: 'get'
    }).then(({data}) => {
      if (data && data.code === 200) {
        sessionStorage.setItem('permissions', JSON.stringify(data.dataMap.permissions || '[]'));
        sessionStorage.setItem('isAdmin', data.dataMap.isAdmin);
      } else {
        sessionStorage.setItem('permissions', '[]');
        sessionStorage.setItem('isAdmin', false);
      }
    }).catch((e) => {
      Notice.error({
        title: '请求菜单列表和权限失败,请刷新重试'
      });
    });
  }

  next()
});

/**
 * 获取指定的URL参数值
 * URL:http://www.aaa.com/index?name=aaa
 * 参数：paramName URL参数
 * 调用方法:getParam("name")
 * 返回值:tyler
 */
function getParam(paramName) {
  var name, value;
  var str = location.href; //取得整个地址栏
  var num = str.indexOf("?")
  str = str.substr(num + 1); //取得所有参数

  var arr = str.split("&"); //各个参数放到数组里
  console.log(arr)
  for (var i = 0; i < arr.length; i++) {
    num = arr[i].indexOf("=");
    if (num > 0) {
      name = arr[i].substring(0, num);
      if (name == paramName) {
        return arr[i].substr(num + 1);
      }
    }
  }
  return null;
}


export default router


