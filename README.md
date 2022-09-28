# 使用手则

1. **Simple-Project** 即简单的项目，旨在把复杂项目中的各个技术栈拆分成单个项目，方便理解和使用
2. **nacos-service-registry**(nacos服务注册中心)和**nacos-service-configuration**(nacos服务配置中心)组合使用
3. **spring-cloud-config-server**(springconfig配置中心)和**spring-cloud-config-consumer**(springconfig获取配置)组合使用
4. **netflix-eureka-server**(eureka注册中心)和**netflix-eureka-client**(eureka服务提供者)和**netflix-eureka-consumer**(eureka服务消费者)组合使用

# 项目作用

## 1.nacos-service-configuration nacos服务配置中心
+ 等待更新……

## 2.nacos-service-registry nacos服务注册中心
+ 预先下载nacos 为防止版本问题 建议下载nacos-server-2.0.3
+ openfeign服务间调用+loadBalancer负载均衡
+ localhost:9001/service访问nacos-consumer服务，通过openfeign调用nacos-provider服务中暴露的接口
+ 完善计划
	1. openfeign相关配置
	2. loadBalancer相关配置
	3. nacos相关配置

## 3.spring-cloud-config-server springconfig配置中心
+ git部署配置中心
+ 完善计划
	1. springconfig配置含义

## 4.spring-cloud-config-consumer springconfig获取配置
+ localhost:8081/getConfig POST获取信息

## 5.netflix-eureka-server eureka注册中心
+ 127.0.0.1:8080 访问注册中心管理页面
+ 完善计划
	1. eureka配置含义

## 6.netflix-eureka-client eureka服务提供者
+ eureka服务提供者模拟集群+注册中心服务清单的同步实现：
> https://blog.csdn.net/weixin_55883492/article/details/124196724

## 7.netflix-eureka-consumer eureka服务消费者
+ openfeign进行服务间调用+ribbon负载均衡
+ 完善计划
	1. ribbon相关配置
	
# 更新计划
+ 注册中心
	+ eureka：详情见**netflix-eureka-server**
	+ nacos：详情见**nacos-service-registry**
	+ zookeeper
	+ consul
+ 服务调用
	+ ribbon：详情见**netflix-eureka-consumer**
	+ loadbalancer：详情见**nacos-service-registry**
	+ openfeign：详情见**nacos-service-registry**
+ 服务降级
	+ hystrix
	+ sentinel
+ 服务网关
	+ zuul
	+ gateway
+ 服务配置
	+ springconfig：详情见**spring-cloud-config-consumer**
	+ nacos
+ 服务总线
	+ bus
	+ nacos
+ 消息队列
	+ rabbitmq
+ 其他
	+ sso单点登录
	+ jacoob文字转语音