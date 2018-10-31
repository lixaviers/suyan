<template>
  <div class="site-wrapper site-page--login">
    <div class="site-content__wrapper">
      <div class="site-content">
        <div class="brand-info">
          <h2 class="brand-info__text">renren-fast-vue</h2>
          <p class="brand-info__intro">renren-fast-vue基于vue、element-ui构建开发，实现renren-fast后台管理前端功能，提供一套更优的前端解决方案。</p>
        </div>
        <div class="login-main">
          <h3 class="login-title">管理员登录</h3>
          <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()"
                   status-icon>
            <el-form-item prop="username">
              <el-input v-model="dataForm.username" placeholder="帐号"></el-input>
            </el-form-item>
            <el-form-item prop="password">
              <el-input v-model="dataForm.password" type="password" placeholder="密码"></el-input>
            </el-form-item>
            <!--<el-form-item prop="captcha">
              <el-row :gutter="20">
                <el-col :span="14">
                  <el-input v-model="dataForm.captcha" placeholder="验证码">
                  </el-input>
                </el-col>
                <el-col :span="10" class="login-captcha">
                  <img :src="captchaPath" @click="getCaptcha()" alt="">
                </el-col>
              </el-row>
            </el-form-item>-->
            <el-form-item>
              <el-button :loading="loading" class="login-btn-submit" type="primary" @click="dataFormSubmit()">登录
              </el-button>
            </el-form-item>
          </el-form>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  //  import {getUUID} from '@/utils'
  export default {
    data () {
      return {
        loading: false,
        dataForm: {
          username: 'lixavier',
          password: '123456',
          uuid: '',
          captcha: ''
        },
        dataRule: {
          username: [
            {required: true, message: '帐号不能为空', trigger: 'blur'}
          ],
          password: [
            {required: true, message: '密码不能为空', trigger: 'blur'}
          ],
          captcha: [
            {required: true, message: '验证码不能为空', trigger: 'blur'}
          ]
        },
        captchaPath: ''
      }
    },
    created () {
      this.getCaptcha();

      var access_token = sessionStorage.getItem('access_token');
      console.log(access_token)
      if(access_token && access_token != '') {
        this.$router.replace({name: 'home'});
      } else{
        sessionStorage.setItem('access_token', '');
        sessionStorage.setItem('token_type', '');
      }

    },
    methods: {
      // 提交表单
      dataFormSubmit () {
        let t = this;
        this.$refs['dataForm'].validate((valid) => {
            if (valid) {
              t.loading = true;
              t.$http({
                url: this.$http.adornUrl('oauth/token', 0),
                method: 'post',
                data: this.$http.adornData({
                  'grant_type': 'password',
                  'username': this.dataForm.username,
                  'password': this.dataForm.password,
                  'scope': 'all',
                }, false, 'form'),
                headers: {
                  'Content-Type': 'application/x-www-form-urlencoded',
                  'Authorization': 'Basic c3V5YW51c2VycmVzdDpzdXlhbnVzZXJyZXN0c2VjcmV0'
                }
              }).then(({data}) => {

                sessionStorage.setItem('access_token', data.token_type + ' ' + data.access_token);
                sessionStorage.setItem('token_type', data.token_type);
                this.$router.replace({name: 'home'});

              }).catch(function (error) {
                t.loading = false;
              });
            }
          }
        )
      },
      // 获取验证码
      getCaptcha() {
        /*this.dataForm.uuid = getUUID()
         this.captchaPath = this.$http.adornUrl(`/captcha.jpg?uuid=${this.dataForm.uuid}`)*/
      }
    }
  }
</script>

<style lang="scss">
  .site-wrapper.site-page--login {
    position: absolute;
    top: 0;
    right: 0;
    bottom: 0;
    left: 0;
    background-color: rgba(38, 50, 56, .6);
    overflow: hidden;
    &:before {
      position: fixed;
      top: 0;
      left: 0;
      z-index: -1;
      width: 100%;
      height: 100%;
      content: "";
      background-image: url(~@/assets/img/login_bg.jpg);
      background-size: cover;
    }
    .site-content__wrapper {
      position: absolute;
      top: 0;
      right: 0;
      bottom: 0;
      left: 0;
      padding: 0;
      margin: 0;
      overflow-x: hidden;
      overflow-y: auto;
      background-color: transparent;
    }
    .site-content {
      min-height: 100%;
      padding: 30px 500px 30px 30px;
    }
    .brand-info {
      margin: 220px 100px 0 90px;
      color: #fff;
    }
    .brand-info__text {
      margin: 0 0 22px 0;
      font-size: 48px;
      font-weight: 400;
      text-transform: uppercase;
    }
    .brand-info__intro {
      margin: 10px 0;
      font-size: 16px;
      line-height: 1.58;
      opacity: .6;
    }
    .login-main {
      position: absolute;
      top: 0;
      right: 0;
      padding: 150px 60px 180px;
      width: 470px;
      min-height: 100%;
      background-color: #fff;
    }
    .login-title {
      font-size: 16px;
      margin-bottom: 10px;
    }
    .login-captcha {
      overflow: hidden;
      > img {
        width: 100%;
        cursor: pointer;
      }
    }
    .login-btn-submit {
      width: 100%;
      margin-top: 38px;
    }
  }
</style>
