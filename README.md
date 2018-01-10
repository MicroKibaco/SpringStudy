### 什么是框架?
![框架](docs/spring-overview.png)
### Spring简介
#### 如何学习Spring?
- 掌握用法
- 深入理解
- 不断实践
- 反复总结
- 再次深入理解与实践
#### Spring是什么?
* Spring是一个开源框架,最初是为了解决企业应用开发的复杂性而创建的,但现在已经不止应用于企业应用
* 是一个轻量级的控制反转(IOC)和面向切面(AOP)的容器框架
  - 从大小和开销方面而言Spring都是轻量的
  - 通过控制反转(IOC)的技术达到松耦合的目的
  - 提供了面向切面编程的丰富支持, 允许通过分离应用的业务逻辑与系统服务进行内聚性的开发
  - 包含并管理应用对象的配置和生命周期,这个意义上是一种容器
  - 将简单的组件配置,组合为复杂的应用,这个意义上是一个框架
#### 为什么是Spring?
1. 简单,方便,便捷
2. Spring带来了复杂的JavaEE开发的春天
#### Spring作用
- 容器
- 提供了对多种技术的支持
 - JMS
 - MQ支持
- AOP(事物管理,日志等)
- 提供了众多方便应用的辅助类(JDBC Template等)
- 对主流应用框架(Hibernate等)提供良好的支持
#### 适用范围
- 构建企业应用(SpringMVC + Spring + Hibernate/Mybatis)
- 单独适用Bean容器
- 单独使用AOP进行切面处理
- 其他的Spring功能,如: 对消息的支持等
- 在互联网中的应用....
### IOC(配置,注解)
- 接口,及面向接口编程
- 什么是IOC
  - **IOC: 控制反转,**控制权在转移,应用程序本身不负责依赖对象的创建和维护,而是由外部容器负责创建和维护
  - **DL(依赖注入)是其一种实现方式**
  - **目的:**创建对象并且组装对象的关系

![配置](docs/container-magic.png)
- Spring的Bean配置
- Bean的初始化
- Spring常用注入方式
 - Spring注入是指启动Spring容器加载bean配置的时候,完成对变量的赋值行为
 - 常用两种注入方式:
        - 设置注入
        - 构造注入
### Bean(配置,注解)
- Bean的配置项
  - Id
  - Class
  - Scope
  - Constructor arguments
  - Properties
  - Autowiring mode
  - lazy-initialzation mode
  - initialzation/destruction method
- Bean的作用域
  - singleton: 单例,指一个Bean容器只存一份
  - prototype: 每次请求(每次使用)创建新的实例, destory方式不生效
  - request: 每次http请求创建一个实例且仅在当前request内有效
  - session: 同上,每次http请求创建,当前session内有效
  - global session: 基于portlet的web内有效(portlet定义了global session),如果在web中,同为session
- Bean的生命周期
- Bean的自动装配
- Resource & ResourceLoader
### AOP(配置,注解,AspectJ,API)

