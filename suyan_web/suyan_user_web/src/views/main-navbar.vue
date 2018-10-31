<template>
  <nav class="site-navbar">
    <div class="site-navbar__header">
      <h1 class="site-navbar__brand" @click="$router.push({ name: 'home' })">
        <a class="site-navbar__brand-lg" href="javascript:;">素焉管理后台</a>
        <a class="site-navbar__brand-mini" href="javascript:;">素焉</a>
      </h1>
    </div>
    <div class="site-navbar__body clearfix">
      <el-menu class="site-navbar__menu" mode="horizontal">
        <el-menu-item class="site-navbar__switch" index="0" @click="sidebarFold = !sidebarFold">
          <icon-svg name="zhedie"></icon-svg>
        </el-menu-item>
      </el-menu>
      <el-menu class="site-navbar__menu site-navbar__menu--right" mode="horizontal">
        <el-menu-item class="float-right" index="1">11112e</el-menu-item>
        <el-menu-item class="site-navbar__avatar" index="2">
          <el-dropdown :show-timeout="0" placement="bottom">
            <span class="el-dropdown-link">
              <img src="~@/assets/img/avatar.png" :alt="userName">{{ userName }}
            </span>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item @click.native="updatePasswordHandle()">修改密码</el-dropdown-item>
              <el-dropdown-item @click.native="logoutHandle()">退出</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </el-menu-item>
      </el-menu>
    </div>
  </nav>
</template>


<style>
</style>

<script>
  export default {
    data () {
      return {
        loading: true,
      }
    },
    components: {},
    computed: {
      sidebarFold: {
        get () { return this.$store.state.common.sidebarFold },
        set (val) { this.$store.commit('common/updateSidebarFold', val) }
      },
      mainTabs: {
        get () { return this.$store.state.common.mainTabs },
        set (val) { this.$store.commit('common/updateMainTabs', val) }
      },
      userName: {
        get () { return this.$store.state.user.name }
      }
    },
    methods: {
      logoutHandle() {
        this.$confirm(`确定要退出吗?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$http({
            url: this.$http.adornUrl('user/logout', 0),
            method: 'post',
          }).then(({data}) => {
            sessionStorage.setItem('access_token', '');
            sessionStorage.setItem('token_type', '');
            sessionStorage.setItem('isAdmin', false);

            this.$cookie.delete('JSESSIONID');

            console.log(this.$cookie.get('JSESSIONID'))

            sessionStorage.setItem('menuList', []);
            sessionStorage.setItem('permissions', []);
            location.href = "/";
          });
        });
      }
    }
  }
</script>
