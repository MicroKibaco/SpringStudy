# 浅尝辄止Spring
### 什么是Spring框架？
Spring框架是一个为java应用程序的开发提供了综合,广泛基础性支持的java平台.
Spring帮助开发者解决开发中的基础性问题,使得开发人员可以专注于应用程序的开发,Spring框架本身是按照设计模式精心打造,这使得我们安心集成Spring框架,不用担心Spring框架,不必担心Spring是如何在后台进行工作的
### Spring框架有哪些模块?
Spring框架至今已集成了20多个模块.这些模块主要被划分如下图所示的核心容器,数据访问/集成,
web,AOP(面向切面),工具,消息和测试模块

![框架](./spring/docs/spring-overview.png)
### Spring简介
#### 如何学习Spring?
- 掌握用法
- 深入理解
- 不断实践
- 反复总结
- 再次深入理解与实践
#### Spring是什么?
  ![Spring](http://p2je16s75.bkt.clouddn.com/spring.png)
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
3. Dependency Injection(DI) 方法使得构造器 和 JavaBean properties 文件中的依赖一目了然
4. 与EJB容器相比较,IOC容器更趋向于轻量型,这样一来IOC容器在有限的内存和CPU资源情况下进行应用程序的开发和发布就变得十分有利
5. Spring没有闭门造车,Spring利用了已有的技术,比如ORM框架,logging框架,J2EE,Quartz和JDK Timer,以及其他视图技术
6. Spring框架是按照模块的形式组织的.由包和类的编号就可以看出其所属的模块.开发者仅仅需要选用他们需要的模块即可
7. Spring 的web框架亦是一个精心设计的web MVC架构,为开发者在web框架的选择提供了一个除了主流框架比如 Struts,过度设计的,不流行的web框架的以外的有利选项
8. Spring提供一个便捷的事物管理接口,使用于小型本地事物处理(比如在单DB环境的环境下)和复杂的事物处理(比如利用JTA和复杂DB环境)
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
### 控制反转IOC(配置,注解)
- 接口,及面向接口编程
- 什么是IOC
  - **IOC: 控制反转,** 控制权在转移,应用程序本身不负责依赖对象的创建和维护,而是由外部容器负责创建和维护
  - **DL(依赖注入)是其一种实现方式**
  - **目的:** 创建对象并且组装对象的关系

![配置](./spring/docs/container-magic.png)
- Spring的Bean配置
- Bean的初始化
- Spring常用注入方式
 - Spring注入是指启动Spring容器加载bean配置的时候,完成对变量的赋值行为
 - 常用三种注入方式:
        - 设置注入(setter)
        - 构造注入
        - 接口注入
        
### 请解释一下Spring 框架中的 IOC
- Spring中的 org.springframework.beans 包和 org.springframework.context包构成了spring
框架 IOC 容器基础        
- BeanFactory 接口提供了一个先进的配置机制,使得任何对象的配置成为了可能,ApplicationContex接口对BeanFactory（是一个子接口）进行了扩展
,扩展 BeanFactory ,Spring 与 AOP 集成更加简洁,提供处理Message resource机制(用于国际化),事件传播以及应用层的特别配置,比如针对
webApplicationContext,因此BeanFactory接口是Spring IOC容器核心接口

![IOC](http://p2je16s75.bkt.clouddn.com/ioc.png)
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
  - 定义
  - 初始化
  1. 实现org.springframework.beans.factory.InitalizingBean接口,覆盖afterPropertiesSet方法
  2. 配置init-method
  - 使用
  - 销毁
- Bean的自动装配
- Resource & ResourceLoader

![bean-config](http://p2je16s75.bkt.clouddn.com/bean-config.jpg)
### AOP(配置,注解,AspectJ,API)
- 什么是AOP及实现方式
- AOP基本概念
    - AOP: Aspect Oriented Programming 的缩写,意为:面向切面编程,通过预编译方式和运行期动态代理实现程序功能的统一维护的一种技术
    - 主要功能是: 日志记录,性能统计,安全控制,事物处理,异常处理等等
- String中的AOP
    - 纯java实现,无须特殊编译过程,不需要类加载器层次
    - 目前只支持方法执行连接点(通知Spring Bean的方法执行)
    - 不是为了提供完整的AOP实现(尽管非常强大);而是侧重于提供一种AOP实现和Spring IOC容器之间的整合,用于帮助企业解决企业应用中的常见问题
    - Spring AOP不会与AspectJ竞争,从而全面提供综合全面的AOP解决方案
- Schema-based AOP
    - <aop:config>
    - Pointcut
    - Advice
    - Introductions
    - Advisors
- Spring AOP API

```
 1. 这是Spring1.2历史用法,现在(V4.0)仍然支持
 2. 这是SpringAOP基础
 3. 现在用法也是基于历史的
```
   - Pointcut
   实现一: NameMatchMethodPointcut,根据方法名字进行匹配
   成员变量: mappedNames, 匹配的方法名集合
- AspectJ
- 有接口和无接口的Spring AOP实现区别
    - Spring AOP默认使用标准的javaSE动态代理作为AOP代理,这使得任何接口(或者接口集)都可以被代理
    - Spring AOP中也可以使用CGLIB代理(如果一个业务对象并没有实现一个接口)

![aop](http://p2je16s75.bkt.clouddn.com/aop.png)
### BeanFactory与ApplicationContext区别
ApplicationContext 比  BeanFactory 更加强大,
1. 提供了支持国际化文本消息
2. 统一资源文件读取方式
3. 已在监听器中注册bean对象

### Spring的几种配置方式
1. 基于XML的配置
2. 基于注解的配置
3. 基于Java的配置

![spring-config-way](http://p2je16s75.bkt.clouddn.com/spring-config-way.jpeg)
### 请举例解释@Required annotation？
- @Required注解适用于bean属性的setter方法
- 这个注解仅仅表示,受影响的bean属性必须配置时被填充,通过bean的定义或通过自动装配一个明确值
### 请举例解释@Autowired注解？
- 可以将@Autowired注解为传统的setter方法
- 可以通过构造器或成员变量
- 默认情况下,如果因找不到合适的bean将会导致autowiring失败抛出异常,可以通过下面的方式避免
- 每个类只能有一个构造器被标记为required = true
- @Autowired的必要属性,建议使用@Required注解
- 可以使用@Autowired注解那些众所周知的解析依赖性接口,比如: BeanFactory,ApplicationContext,
Enviroment,RessourceLoader,ApplicationEventPublisher,and MessageSource
- 可以通过添加注解给需要该类型的数组字段或方法,以提供ApplicationContext中所有特定类型的bean
- 可以用于装配key为String的map
- 如果希望数组有序,可以让bean实现org.springframework.core.Ordered接口或使用@Order注解
- @Autowired是由Spring BeanPostProcessor处理的,所以不能在自己的BeanPostProcessor或
BeanFactoryPostProcessor类型应用这些注解,这些类型必须通过XML或者Spring的@Bean注解加载
- 可以通过添加注解给需要该类型的数组或方法,以提供ApplicationContext中的所以特定类型的bean
- 可以用于装配key为String的map
- 如果希望数组有序,可以让bean实现org.springframework.core.Ordered接口或使用
@Ordered注解
![require](http://p2je16s75.bkt.clouddn.com/require.jpeg)
### 请举例说明@Qualifier注解？
- 按类型自动装配可能多个bean实例的情况,可以使用Spring的@Qualifier注解缩小范围(或指定唯一),也可以
用于指定单独的构造器参数或方法参数
- 可用于集合类型变量

### Spring事务
- 什么是事务?
事务指的是逻辑的一组操作,这组操作要么全部成功,要么全部失败
- 事务的特性:
1) 原子性
原子性是指事务是一个不可分割的工作单位,事务中的操作要么都全部发生,要么都不发生
2) 一致性
一致性指的是事务前后数据的完整性必须保持一致
3) 隔离性
隔离强调的是多个用户并发访问数据库时,一个用户的事务不能被其他用户的事务所干扰,多个并发事务之间的数据要相互隔离
4) 持久性
一个事务一旦被提交了,它对数据库中的数据改变就是永久性的,即数据库发生故障也不应该对其有任何影响

![事务](http://p2je16s75.bkt.clouddn.com/%E4%BA%8B%E5%8A%A1.png)
- Spring支持两种方式事务管理
1) 编程式的事务管理
   - 通过TransactionTemplate手动管理事务
2) 使用XML配置声明事务
   - Spring的声明事务是通过AOP实现的 
### 数组及Map的自动注入


### 其他问题
```
1. 如何在Spring中注入一个Java Collection？
2. 如何向Spring Bean中注入一个Java.util.Properties?
3. 请解释Spring Bean的自动装配？
4. 请解释自动装配模式的区别？
5. 如何开启基于注解的自动装配？
6. 构造方法注入和设值注入有什么区别？
7. Spring框架中有哪些不同类型的事件？
8. FileSystemResource和ClassPathResource有何区别？
9. Spring 框架中都用到了哪些设计模式？
```

