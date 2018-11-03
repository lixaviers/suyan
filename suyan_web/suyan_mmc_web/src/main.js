import Vue from 'vue'
import App from './App'
import router from './router'
import iView from 'iview';
import 'iview/dist/styles/iview.css';
import httpRequest from '@/utils/httpRequest';
import { isAuth } from '@/utils';

Vue.use(iView, {
  transfer: true,
  size: 'large'
});
Vue.config.productionTip = false;

Vue.prototype.$http = httpRequest; // ajax请求方法
Vue.prototype.isAuth = isAuth     // 权限方法


new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
