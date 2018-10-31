import Vue from 'vue';
import App from './App';
import store from '@/store';
import router from './router';
import '@/element-ui';
import '@/icons';
import 'element-ui/lib/theme-chalk/index.css';
import '@/assets/css/index.scss';
import httpRequest from '@/utils/httpRequest';
import { isAuth } from '@/utils'
import VueCookie from 'vue-cookie'            // api: https://github.com/alfhen/vue-cookie


Vue.use(VueCookie);
Vue.config.productionTip = false;

Vue.prototype.$http = httpRequest; // ajax请求方法
Vue.prototype.isAuth = isAuth     // 权限方法


/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
