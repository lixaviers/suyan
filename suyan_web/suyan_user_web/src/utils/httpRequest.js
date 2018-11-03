import Vue from 'vue';
import {Message} from 'element-ui';
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
  // config.headers['XSRF-TOKEN'] = "bf95ec30-4f11-417e-ba65-6c247270d844";
  // config.headers['XSRF-TOKEN'] = Vue.cookie.get('XSRF-TOKEN');

  // config.headers['ajax'] = true;
  var token = sessionStorage.getItem('access_token');
  var token_type = sessionStorage.getItem('token_type');
  if (token) {
    config.headers['Authorization'] = token_type + ' ' +token;
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
      Message({message: response.data.message, type: 'error'});
    }
  }
  return response;
}, function (error) {
  console.log(error)
  if (403 === error.response.status) {
    console.log('forbidden')
  } else if (400 === error.response.status) {
    Message({message: '用户名和密码不匹配', type: 'error'});
    error.code = 500;
    return Promise.reject(error);
  } else if(401 === error.response.status) {
    router.push({name: '401'});
  } else {
    router.push({name: '504'});
  }
});

/**
 * 请求地址处理
 * @param {*} actionName action方法名称
 */
http.adornUrl = (actionName, type = 1) => {
  if (type === 0) {
    return '/api/user/' + actionName;
  }
  return '/api/urms/' + actionName;
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

