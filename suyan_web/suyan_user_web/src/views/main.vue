<template>
  <div :class="{ 'site-sidebar--fold': sidebarFold }">
    <template v-if="!loading">
      <main-navbar/>
      <main-sidebar/>
      <div class="site-content__wrapper" :style="{ 'min-height': documentClientHeight + 'px' }">
        <main-content/>
      </div>
    </template>
  </div>
</template>


<style>
</style>

<script>
  import MainNavbar from './main-navbar'
  import MainSidebar from './main-sidebar'
  import MainContent from './main-content'
  export default {
    data () {
      return {
        loading: true,
      }
    },
    components: {
      MainNavbar,
      MainSidebar,
      MainContent,
    },
    computed: {
      documentClientHeight: {
        get () {
          return this.$store.state.common.documentClientHeight
        },
        set (val) {
          this.$store.commit('common/updateDocumentClientHeight', val)
        }
      },
      sidebarFold: {
        get () {
          return this.$store.state.common.sidebarFold
        },
        set (val) {
          this.$store.commit('common/updateSidebarFold', val)
        }
      },
      userId: {
        get () {
          return this.$store.state.user.id
        },
        set (val) {
          this.$store.commit('user/updateId', val)
        }
      },
      userName: {
        get () {
          return this.$store.state.user.name
        },
        set (val) {
          this.$store.commit('user/updateName', val)
        }
      }
    },
    created () {
      this.getUserInfo()
    },
    mounted () {
      this.resetDocumentClientHeight()
    },
    methods: {
      // 重置窗口可视高度
      resetDocumentClientHeight () {
        this.documentClientHeight = document.documentElement['clientHeight']
        window.onresize = () => {
          this.documentClientHeight = document.documentElement['clientHeight']
        }
      },
      // 获取当前管理员信息
      getUserInfo () {
        this.$http({
          url: this.$http.adornUrl('user/getUserInfo'),
          method: 'post'
        }).then(({data}) => {
          if (data && data.code === 200) {
            this.loading = false;
            this.userId = data.dataMap.openId;
            this.userName = data.dataMap.nickName;
          }
        });
      }
    }
  }
</script>
