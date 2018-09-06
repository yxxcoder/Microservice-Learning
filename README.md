# Microservice-Learning
微服务架构相关的使用案例，包括服务网关Zuul、服务注册发现Eureka+Ribbon、服务配置中心Apollo、服务配置中心Apollo、服务框架Spring MVC/Boot等等，持续更新中...

## 1. 分布式事务 Apache ServiceComb Saga
Apache ServiceComb (incubating) Saga 是华为开源的微服务应用的数据最终一致性解决方案。Saga会直接提交事务，后续rollback阶段则通过反向的补偿操作来完成。
