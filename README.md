# SpringCloud Learn

## 分布式架构需要考虑的问题
1. 服务拆分粒度如何
2. 服务集群地址如何维护
3. 服务之间如何实现远程调用
4. 服务健康状态如何感知

## 微服务
### 设么是微服务
- 一种良好的分布式架构方案

### 微服务特点
#### 基本特点
- **单一职责**
- **面向服务**：微服务对外暴露接口
- **自治**：团队独立、技术独立、数据独立(使用不同的数据库)、部署独立
- **隔离性**：服务做好隔离、容错、降级、避免级联问题

#### 优缺点
<p style="color: red; font-weight: bold">优点：拆分粒度更小、服务更独立、耦合度更低</p>
<p style="color: greenyellow; font-weight: bold">缺点：架构非常复杂；运维、监控、部署难度高</p>

## 单体架构与分布式架构的区别
### 单体架构特点
- 简单方便、高度耦合、扩展性差、是和小型项目。例：学生管理系统

### 分布式架构特点
- 解耦合、扩展性好、结构复杂难度大、适合大型互联网项目。例：京东、淘宝

## 服务拆分及远程调用
### 服务拆分注意事项
1. 不同微服务，不要重复开发相同业务
2. 微服务数据独立，不要访问其他微服务的数据库
3. 微服务可以将自己的业务暴露为接口，供其他微服务调用

## 服务的调用关系
- 服务提供者：暴露接口给其他微服务调用
- 服务消费者：调用其他微服务提供的接口
- 提供者与消费者角色是相对的

## Eureka注册中心
- EurekaServer：服务端，注册中心
  - 记录服务信息
  - 心跳监控
- EurekaClient：客户端
  - Provider：服务提供者
    - 注册自己的信息到 EurekaServer
    - 每隔 30s 向 Eureka 发送心跳
  - Consumer：服务消费者
    - 根据服务名称从 EurekaServer 拉去服务列表
    - 基于服务列表做负载均衡，选中后发起远程调用

### 搭建 EurekaServer
- 引入依赖
- 启动类添加 `@EnableEurekaServer` 注解
- 配置 `application.yml`

### 搭建 EurekaClient
- 引入依赖
- 配置 `application.yml`

### 服务的发现
- 引入 eureka-client 依赖
- 配置 eureka 地址
- RestTemplate 添加 @LoadBalance 注解
- 将 ip 替换为服务名称

## Ribbon 负载均衡
### 流程
1. service 发起请求
2. Ribbon 拦截
3. 调用注册中心
4. 进行负载均衡
5. 调用其他 service

### 饥饿加载
- Ribbon 默认采用懒加载
- 饥饿加载在项目启动时进行加载
- 配置
```yaml
ribbon:
  eager-load:
    enabled: true # 开启饥饿加载
    clients: user-service # 指定服务对该服务进行饥饿加载
```
```yaml
# 配置多个
ribbon:
  eager-load:
    enabled: true # 开启饥饿加载
    clients:
      - user-service
      - xxx-service
```

### 总结
1. Ribbon 负载均衡规则
   - 规则接口是 IRule
   - 默认实现是 ZoneAvoidanceRule，根据 zone 选择服务列表，然后轮询
2. 负载均衡自定义方式
   - 代码方式
   - 配置方式
3. 饥饿加载
   - 开启饥饿加载
   - 指定饥饿加载的微服务名称

## Nacos
1. Nacos 服务搭建
   - 下载
   - 解压
   - 执行命令
   ```shell
    sh ./startup.sh -m standalone # 单机启动
   # Windows
   startup.cmd -m standalone
   ```
2. Nacos 服务注册或发现
   - 引入 nacos.discovery 依赖
   - 配置 nacos 地址 spring.cloud.nacos.server-addr
3. Nacos 服务分集存储模型
    - 服务-》集群-》实例
4. 设置实例集群属性
   - 修改 application.yml 文件，添加 spring.cloud.nacos.discovery.cluster-name 属性
5. NacosRule 负载均衡策略
   - 优先选择统计群服务实例列表
   - 本地集群找不到提供者，才去其他集群寻找，并且会告警
   - 确定可用实例列表后再采用随机负载均衡挑选实例
