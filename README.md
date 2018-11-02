# 素焉SpringCloud完整项目
<br>
所用技术：
Spring Cloud、Spring Security JWT SSO
<br>
模块划分：
<br>
control_center api_gateway：zuul 统一网关 10000端口
<br>
control_center eureka：Spring Eureka 8761端口
<br>
suyan_user suyan_user_server 登录 60000端口
<br>
suyan_user suyan_user_rest urms系统 60001端口
<br>
suyan_mmc suyan_mmc_job 营销中心job 60002端口
<br>
suyan_mmc suyan_mmc_web 营销中心web 60003端口
<br>
suyan_goods suyan_goods_web 商品中心web 60005端口
<br>
<br>
<br>
<h2>前端</h2>
<br>
管理页面：使用人人开源，地址：https://gitee.com/renrenio/renren-security
<br>
suyan_user_web 60002端口
<br>
<br>
营销中心：vue iview
<br>
suyan_mmc_web 60004端口
<br>
<br>
由于使用了统一网关，所有接口请走10000端口，实现了SSO，本地配了静态IP，需要演示的童鞋请修改Eureka地址，我本机是http://192.168.226.111:8761/
<br>
<br>
项目演示：

登录页面：使用人人开源，地址：https://gitee.com/renrenio/renren-security

<img src="https://github.com/lixaviers/suyan/blob/master/suyan_java/view/1.png" />


<h2>首页</h2>
<img src="https://github.com/lixaviers/suyan/blob/master/suyan_java/view/2.png" />


用户管理
<img src="https://github.com/lixaviers/suyan/blob/master/suyan_java/view/3.png" />


角色管理
<img src="https://github.com/lixaviers/suyan/blob/master/suyan_java/view/4.png" />


资源管理
<img src="https://github.com/lixaviers/suyan/blob/master/suyan_java/view/5.png" />


系统管理
<img src="https://github.com/lixaviers/suyan/blob/master/suyan_java/view/6.png" />
<br>
<br>
<br>
<br>
<h2>营销中心</h2>

优惠券
<img src="https://github.com/lixaviers/suyan/blob/master/suyan_java/view/7.png" />


订单促销
<img src="https://github.com/lixaviers/suyan/blob/master/suyan_java/view/8.png" />
<br>
<br>
<br>
<br>
<br>
<br>
<h2>订单管理</h2>
<br>
<br>
<h2>商品管理</h2>
<br>
<br>
持续更新中，尽请期待。
