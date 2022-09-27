# 使用手则

1. Simple-Project 即简单的项目，旨在把复杂项目中的各个技术栈拆分成单个项目，方便理解和使用
2. nacos-service-registry(nacos服务注册中心)和nacos-service-configuration(nacos服务配置中心)组合使用
3. spring-cloud-config-server(springconfig配置中心)和spring-cloud-config-consumer(springconfig获取配置)组合使用

# 项目作用

## 1.nacos-service-registry nacos服务注册中心
+ 用openfeign进行服务间调用

## 2.nacos-service-configuration nacos服务配置中心
+ 暂无

## 3.eureka 注册中心
+ 暂无

## 4.spring-cloud-config-server springconfig配置中心
+ 用git部署配置中心

## 5.spring-cloud-config-consumer springconfig获取配置
+ /getConfig() POST获取信息

# 后续更新
+ zuul
+ gateway
+ hystrix
+ ribbon
+ sso单点登录