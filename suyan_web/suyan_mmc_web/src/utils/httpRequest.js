import Vue from 'vue';
import Notice from 'iview/src/components/notice';
import axios from 'axios';
import merge from 'lodash/merge';
import router from '@/router';
import qs from 'qs';
axios.defaults.baseURL = "/";
const http = axios.create({
  timeout: 1000 * 30,
  withCredentials: false,
  headers: {
    'Content-Type': 'application/json; charset=utf-8'
  }
})

/**
 * 请求拦截
 */
http.interceptors.request.use(config => {
  var token = sessionStorage.getItem('access_token');
  var token_type = sessionStorage.getItem('token_type');
  if (token) {
    config.headers['Authorization'] = token_type + ' ' + token;
  }

  return config
}, error => {
  return Promise.reject(error)
})

http.interceptors.response.use((response) => {
  console.log(response)
  if (response.data.access_token) {
    return response;
  }
  if (response && response.data.code != 200) {
    if (response.data.code == 404) {
      console.log('未登录');
      router.push({name: 'login'});
    } else {
      Notice.error({
        title: response.data.message
      });
    }
  }
  return response;
}, function (error) {
  console.log(error)
  if (403 === error.response.status) {
    console.log('forbidden')
  } else if (500 === error.response.status) {
    Notice.error({
      title: '服务器异常，请稍后再试'
    });
  } else {
    return Promise.reject(error);
  }
});

/**
 * 请求地址处理
 * @param {*} actionName action方法名称
 * @param {*} type 类型 0.权限中心 1.营销中心 2.商品中心
 */
http.adornUrl = (actionName, type = 1) => {
  if (type == 1) {
    return '/apiMmc/mmc/' + actionName;
  } else if (type == 2) {
    return '/apiGoods/goods/' + actionName;
  } else if (type == 0) {
    return '/apiUrms/urms/' + actionName;
  }
}

http.adornParams = (params = {}, openDefultParams = true) => {
  var defaults = {
    't': new Date().getTime()
  }
  return openDefultParams ? merge(defaults, params) : params
}

/**
 * post请求数据处理
 * @param {*} data 数据对象
 * @param {*} openDefultdata 是否开启默认数据?
 * @param {*} contentType 数据格式
 *  json: 'application/json; charset=utf-8'
 *  form: 'application/x-www-form-urlencoded; charset=utf-8'
 */
http.adornData = (data = {}, openDefultdata = true, contentType = 'json') => {
  var defaults = {
    't': new Date().getTime()
  }
  data = openDefultdata ? merge(defaults, data) : data
  return contentType === 'json' ? JSON.stringify(data) : qs.stringify(data)
}

function checkStatus(response) {
  if (response.data.code != 200) {
    if (response.data.code === 404) {
      // 未登录
      router.push({name: 'login'});
    }
  }
  return response.data;
}

function checkError(error) {
  console.log(error);
}

export default http

