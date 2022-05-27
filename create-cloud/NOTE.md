# 创建 SpringCloud 项目
## 创建分布式架构
- maven 聚合项目

## 使用框架版本
- 基本框架版本
| Spring Cloud Alibaba Version | Spring Cloud Version     | Spring Boot Version |
|------------------------------|--------------------------|---------------------|
| 2.2.7.RELEASE                | Spring Cloud Hoxton.SR12 | 2.3.12.RELEASE      |

- 框架依赖组件版本

| Spring Cloud Alibaba Version | Sentinel Version | Nacos Version | RocketMQ Version | Dubbo Version | Seata Version |
|------------------------------|------------------|---------------|------------------|---------------|---------------|
| 2.2.7.RELEASE                | 1.8.1            | 2.0.3         | 4.6.1            | 2.7.13        | 1.3.0         |

## 父工程添加依赖
```xml
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-alibaba-dependencies</artifactId>
            <version>2.2.7.RELEASE</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```
