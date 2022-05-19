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
