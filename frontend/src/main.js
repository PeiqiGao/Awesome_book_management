// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import 'element-ui/lib/theme-chalk/index.css';
import { Loading } from 'element-ui';
import axios from 'axios';


//将axios挂载到原型上
Vue.prototype.$axios = axios;

Vue.config.productionTip = false
let loading;
let reqnum=0
Vue.use(Loading)
// axios发起请求时，显示loading
axios.interceptors.request.use((config) => {
  reqnum=reqnum+1;
  loading=Loading.service({
          lock: true,
          text: 'Loading',
          spinner: 'el-icon-loading',
          background: 'rgba(0, 0, 0, 0.7)'
  });
  return config
}, (err) => {
  return Promise.reject(err)
})

// axios请求完成后，隐藏loading
axios.interceptors.response.use((response) => {
  reqnum=reqnum-1;
  if(reqnum==0){
  loading.close();}// 关闭loading
  return response
}, (err) => {
  return Promise.reject(err)
})



/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
