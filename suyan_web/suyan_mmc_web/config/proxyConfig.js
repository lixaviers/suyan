module.exports = {
  '/apiMmc': {
    // 测试环境
    target: 'http://192.168.226.111:10000/',  // 接口域名
    changeOrigin: true,  //是否跨域
    pathRewrite: {
      '^/apiMmc': ''   //需要rewrite重写的,
    }
  },
  '/apiGoods': {
    // 测试环境
    target: 'http://192.168.226.111:10000/',  // 接口域名
    changeOrigin: true,  //是否跨域
    pathRewrite: {
      '^/apiGoods': ''   //需要rewrite重写的,
    }
  },
  '/apiUrms': {
    // 测试环境
    target: 'http://192.168.226.111:10000/',  // 接口域名
    changeOrigin: true,  //是否跨域
    pathRewrite: {
      '^/apiUrms': ''   //需要rewrite重写的,
    }
  },
  '/apiUpload': {
    // 测试环境
    target: 'https://www.lidongxian.com/',  // 接口域名
    changeOrigin: true,  //是否跨域
    pathRewrite: {
      '^/apiUpload': ''   //需要rewrite重写的,
    }
  }
}
