# 使用手则
1. **Simple-Project** 即简单的项目，旨在把复杂项目中的各个技术栈拆分成单个项目，方便理解和使用
2. **nacos-service-registry**(nacos服务注册中心)和**nacos-service-configuration**(nacos服务配置中心)组合使用
3. **spring-cloud-config-server**(springconfig配置中心)和**spring-cloud-config-consumer**(springconfig获取配置)组合使用
4. **netflix-eureka-server**(eureka注册中心)和**netflix-eureka-client**(eureka服务提供者)和**netflix-eureka-consumer**(eureka服务消费者)组合使用
5. **netflix-eureka-server**(eureka注册中心)和**netflix-eureka-client**(eureka服务提供者)和**netflix-zuul-server**(zuul网关服务)组合使用

# 项目作用

## 0.miscellaneous 杂项 工具类测试、简单JDK的使用
+ 存放比较杂的API使用
+ api-test 以api包名分类，简单的API存放
+ jdk-jacob 仅支持windows系统使用 不支持语音切换
	+ 各版本下载 
		> https://github.com/freemansoft/jacob-project/releases
	+ 切换语音
		> https://www.likecs.com/show-205090277.html
	+ 将resources内的jacob.dll放在{java_path}/jdk/jre/bin/目录下
+ jdk-dozer 一个对象转换工具
	+ dozer详情
		> https://dozer.sourceforge.net/
+ algorithm 默写算法
+ annotation-test 手写注解
+ 完善计划
	+ jdk-jacob更新excel等操作

## ~~1.nacos-service-configuration nacos服务配置中心~~

## 2.nacos-service-registry nacos服务注册中心
+ 使用依赖
	+ spring-cloud-dependencies
	+ spring-cloud-starter-alibaba-nacos-discovery
	+ nacos-consumer服务
		+ spring-cloud-starter-openfeign
		+ spring-cloud-starter-loadbalancer
	+ nacos-provider服务
		+ spring-cloud-openfeign-core
+ 建议使用nacos-server-2.0.3
+ openfeign服务间调用+loadBalancer负载均衡
+ GET：localhost:9001/service访问nacos-consumer服务，通过openfeign调用nacos-provider服务中暴露的接口
+ 完善计划
	+ openfeign相关配置
	+ loadBalancer相关配置
	+ nacos相关配置

## 3.spring-cloud-config-server springconfig配置中心
+ 使用依赖
	+ spring-cloud-config-server
+ git部署配置中心
+ 服务器源码解读及SVN仓库配置
	> https://www.cnblogs.com/wuzhenzhao/p/10670580.html
+ springconfig配置含义
	> https://zhuanlan.zhihu.com/p/433201039 

## 4.spring-cloud-config-consumer springconfig获取配置
+ 使用依赖
	+ spring-boot-starter-web
	+ spring-cloud-config-client
	+ spring-cloud-starter-bootstrap
+ POST：localhost:8081/getConfig 验证是否获取成功

## 5.netflix-eureka-server eureka注册中心
+ 使用依赖
	+ spring-cloud-starter-netflix-eureka-server
+ 127.0.0.1:8080 访问注册中心管理页面
+ eureka配置含义
	> https://blog.csdn.net/JavaAndLI/article/details/125516594 

## 6.netflix-eureka-client eureka服务提供者
+ 使用依赖
	+ spring-cloud-dependencies
	+ spring-cloud-starter-netflix-eureka-client
	+ spring-boot-starter-web
+ eureka服务提供者模拟集群+注册中心服务清单的同步实现：
	> https://blog.csdn.net/weixin_55883492/article/details/124196724

## 7.netflix-eureka-consumer eureka服务消费者
+ 使用依赖
	+ spring-cloud-starter-netflix-eureka-client
	+ spring-boot-starter-web
	+ spring-cloud-starter-openfeign
+ localhost:8083/getInfo 访问client暴露的接口getInfo
+ openfeign进行服务间调用+ribbon负载均衡
+ openfeign内置ribbon，不需要额外引入依赖
+ 完善计划
	+ ribbon负载均衡相关配置

## 8.netflix-zuul-server zuul网关服务
+ 使用依赖
	+ spring-cloud-starter-netflix-eureka-client
	+ spring-boot-starter-web
	+ spring-cloud-starter-netflix-zuul
	+ lombok
+ 只注册到注册中心，并开启网关服务@EnableZuulProxy，即可自动代理
	+ 测试 localhost:8084/netflix-eureka-client/getInfo(http://ZUUL_HOST:ZUUL_PORT/微服务在注册中心上的serviced/*)
+ 访问任何接口都会500 可能是springboot版本过高
	> https://blog.csdn.net/qq_34383510/article/details/121512234
	
## 9.spring-aspects-aop springAOP服务
+ 使用依赖
	+ spring-boot-starter-web
	+ aspectjweaver

## 10.spring-rabbit rabbitMQ服务
+ 使用依赖
	+ spring-rabbit
	+ spring-boot-starter-web
	+ fastjson2
+ 安装rabbitmq和web管理页面后，打开此网页查看
	> http://127.0.0.1:15672/#/

## 11.spring-websocket websocket服务
+ 使用依赖
	+ spring-boot-starter
	+ tomcat-embed-core
+ 测试用网站
	> http://coolaf.com/tool/chattest

# 更新计划
+ spring
	+ aop：详情见**spring-aspects-aop**
+ 注册中心
	+ eureka：详情见**netflix-eureka-server**
	+ nacos：详情见**nacos-service-registry**
	+ zookeeper
	+ consul
+ 服务调用  
	+ ribbon
	+ openfeign：详情见**nacos-service-registry**
+ 负载均衡
	+ ribbon：详情见**netflix-eureka-consumer**
	+ loadbalancer：详情见**nacos-service-registry**
+ 服务降级
	+ hystrix
	+ sentinel
+ 服务网关
	+ zuul：详情见**netflix-zuul-server**
	+ gateway
+ 服务配置
	+ springconfig：详情见**spring-cloud-config-consumer**
	+ nacos
+ 服务总线
	+ bus
	+ nacos
+ 消息队列
	+ rabbitmq
+ 数据库
	+ redis
	+ mysql
+ 其他
	+ sso单点登录
	+ jacob文字转语音：详情见**miscellaneous**
	+ dozer对象转换工具：详情见**miscellaneous**
	+ websocket：详见**spring-websocket**
	+ k8s
	+ 24种设计模式
	
# ps:所谓更新计划与完善计划 实际上就是下次一定(狗头