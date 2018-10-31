import Vue from 'vue';
import Router from 'vue-router';
import http from '@/utils/httpRequest';
import {isURL} from '@/utils/validate';

Vue.use(Router);

const _import = require('./import-' + process.env.NODE_ENV)

// 全局路由(无需嵌套上左右整体布局)
const globalRoutes = [
  {
    path: '/404', component: _import('common/404'), name: '404', meta: {title: '404未找到'}
  },
  {
    path: '/401', component: _import('common/401'), name: '401', meta: {title: '401未授权'}
  },
  {
    path: '/504', component: _import('common/504'), name: '504', meta: {title: '504未授权'}
  },
  {
    path: '/login', name: 'login', component: _import('common/login'), meta: {title: '登录'}
  }
]

const mainRoutes = {
  path: '/',
  component: _import('main'),
  name: 'main',
  redirect: {name: 'home'},
  meta: {title: '主入口整体布局'},
  children: [
    {path: '/home', component: _import('common/home'), name: 'home', meta: {title: '首页'}},
  ],
  beforeEnter (to, from, next) {
    // 判断是否登录
    /*let XSRF-TOKEN = Vue.cookie.get('XSRF-TOKEN')
     if (!XSRF-TOKEN || !/\S/.test(XSRF-TOKEN)) {
     clearLoginInfo()
     next({ name: 'login' })
     }*/
    next()
  }
}


const router = new Router({
  mode: 'hash',
  scrollBehavior: () => ({y: 0}),
  isAddDynamicMenuRoutes: false, // 是否已经添加动态(菜单)路由
  routes: globalRoutes.concat(mainRoutes)
});


router.beforeEach((to, from, next) => {
  // 添加动态(菜单)路由
  // 1. 已经添加 or 全局路由, 直接访问
  // 2. 获取菜单列表, 添加并保存本地存储
  if (router.options.isAddDynamicMenuRoutes || fnCurrentRouteType(to, globalRoutes) === 'global') {
    next()
  } else {
    http({
      url: http.adornUrl('resource/nav'),
      method: 'get'
    }).then(({data}) => {
      console.log(1)
      if (data && data.code === 200) {
        fnAddDynamicMenuRoutes(data.dataMap.menuList);
        router.options.isAddDynamicMenuRoutes = true;
        sessionStorage.setItem('menuList', JSON.stringify(data.dataMap.menuList || '[]'));
        sessionStorage.setItem('permissions', JSON.stringify(data.dataMap.permissions || '[]'));
        sessionStorage.setItem('isAdmin', data.dataMap.isAdmin);
        next({...to, replace: true});
      } else {
        sessionStorage.setItem('menuList', '[]');
        sessionStorage.setItem('permissions', '[]');
        sessionStorage.setItem('isAdmin', false);
        next()
      }
    }).catch((e) => {
      console.log(`%c${e} 请求菜单列表和权限失败，跳转至登录页！！`, 'color:blue')
      router.push({name: 'login'})
    });
  }
});


/**
 * 判断当前路由类型, global: 全局路由, main: 主入口路由
 * @param {*} route 当前路由
 */
function fnCurrentRouteType(route, globalRoutes = []) {
  var temp = []
  for (var i = 0; i < globalRoutes.length; i++) {
    if (route.path === globalRoutes[i].path) {
      return 'global'
    } else if (globalRoutes[i].children && globalRoutes[i].children.length >= 1) {
      temp = temp.concat(globalRoutes[i].children)
    }
  }
  return temp.length >= 1 ? fnCurrentRouteType(route, temp) : 'main'
}


/**
 * 添加动态(菜单)路由
 * @param {*} menuList 菜单列表
 * @param {*} routes 递归创建的动态(菜单)路由
 */
function fnAddDynamicMenuRoutes(menuList = [], routes = []) {
  var temp = [];
  for (var i = 0; i < menuList.length; i++) {
    if (menuList[i].children && menuList[i].children.length >= 1) {
      temp = temp.concat(menuList[i].children)
    } else if (menuList[i].url && /\S/.test(menuList[i].url)) {
      menuList[i].url = menuList[i].url.replace(/^\//, '')
      var route = {
        path: menuList[i].url.replace('/', '-'),
        component: null,
        name: menuList[i].url.replace('/', '-'),
        meta: {
          id: menuList[i].id,
          title: menuList[i].name,
          isDynamic: true,
          isTab: true,
          iframeUrl: ''
        }
      }
      // url以http[s]://开头, 通过iframe展示
      if (isURL(menuList[i].url)) {
        route['path'] = `i-${menuList[i].id}`;
        route['name'] = `i-${menuList[i].id}`;
        route['meta']['iframeUrl'] = menuList[i].url;
      } else {
        try {
          route['component'] = _import(`page/${menuList[i].url}`) || null;
        } catch (e) {
        }
      }
      routes.push(route)
    }
  }
  if (temp.length >= 1) {
    fnAddDynamicMenuRoutes(temp, routes)
  } else {
    mainRoutes.name = 'main-dynamic'
    mainRoutes.children = routes
    router.addRoutes([
      mainRoutes,
      {path: '*', redirect: {name: '404'}}
    ])
    sessionStorage.setItem('dynamicMenuRoutes', JSON.stringify(mainRoutes.children || '[]'))
    console.log('\n')
    console.log('%c!<-------------------- 动态(菜单)路由 s -------------------->', 'color:blue')
    console.log(mainRoutes)
    console.log('%c!<-------------------- 动态(菜单)路由 e -------------------->', 'color:blue')
  }

}

export default router

