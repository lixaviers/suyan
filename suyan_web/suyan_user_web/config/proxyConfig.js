
module.exports = {
  '/api': {
    // 测试环境
    target: 'http://192.168.226.111:10000/',  // 接口域名
    changeOrigin: true,  //是否跨域
    pathRewrite: {
      '^/api': ''   //需要rewrite重写的,
    }
  }
}
