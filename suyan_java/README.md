# 素焉SpringCloud完整项目

所用技术：
Spring Cloud、Spring Security JWT SSO

模块划分：

control_center api_gateway：zuul 统一网关 10000端口

control_center eureka：Spring Eureka 8761端口

suyan_user suyan_user_server 登录 后续加进来 60000端口

suyan_user suyan_user_rest urms系统 后续加进来 60001端口

suyan_mmc suyan_mmc_job 营销中心job 60002端口

suyan_mmc suyan_mmc_web 营销中心web 60003端口
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


由于使用了统一网关，所有接口请走10000端口，实现了SSO，本地配了静态IP，需要演示的童鞋请修改Eureka地址

URMS做的时候没有在此父项目，先没有加进来，后面有时间一点点加入进来

项目演示：

登录页面：使用人人开源，地址：https://gitee.com/renrenio/renren-security

<img src="https://github.com/lixaviers/suyan/blob/master/view/1.png" />


<h2>首页</h2>
<img src="https://github.com/lixaviers/suyan/blob/master/view/2.png" />


用户管理
<img src="https://github.com/lixaviers/suyan/blob/master/view/3.png" />


角色管理
<img src="https://github.com/lixaviers/suyan/blob/master/view/4.png" />


资源管理
<img src="https://github.com/lixaviers/suyan/blob/master/view/5.png" />


系统管理
<img src="https://github.com/lixaviers/suyan/blob/master/view/6.png" />
<br>
<br>
<br>
<br>
<h2>营销中心</h2>

优惠券
<img src="https://github.com/lixaviers/suyan/blob/master/view/7.png" />


订单促销
<img src="https://github.com/lixaviers/suyan/blob/master/view/8.png" />
<br>
<br>
<br>
<br>
<br>
<br>
持续更新中，尽请期待。