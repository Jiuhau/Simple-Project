# 使用手则

1. **Simple-Project** 即简单的项目，旨在把复杂项目中的各个技术栈拆分成单个项目，方便理解和使用
2. **nacos-service-registry**(nacos服务注册中心)和**nacos-service-configuration**(nacos服务配置中心)组合使用
3. **spring-cloud-config-server**(springconfig配置中心)和**spring-cloud-config-consumer**(springconfig获取配置)组合使用

# 项目作用

## 1.nacos-service-configuration nacos服务配置中心
+ 暂无

## 2.nacos-service-registry nacos服务注册中心
+ openfeign进行服务间调用

## 3.spring-cloud-config-server springconfig配置中心
+ git部署配置中心

## 4.spring-cloud-config-consumer springconfig获取配置
+ localhost:8081/getConfig POST获取信息

## 5.netflix-eureka-server eureka注册中心
+ http://127.0.0.1:8080 访问注册中心管理页面

## 6.netflix-eureka-client eureka服务提供者
+ :-)

# 后续更新
+ zuul
+ gateway
+ hystrix
+ ribbon
+ sso单点登录
+ rabbitmq
+ jacoob文字转语音