### MVC简介
### Spring MVC基本概念
### Spring MVC项目搭建
1. 在pom.xml文件中添加以下依赖
```xml
  <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>4.2.5.RELEASE</version>
        </dependency>
         <dependency>
                    <groupId>javax.servlet</groupId>
                    <artifactId>jstl</artifactId>
                    <version>1.2</version>
                    <scope>runtime</scope>
                </dependency>
                <dependency>
                    <groupId>javaee</groupId>
                    <artifactId>javaee-api</artifactId>
                    <version>5</version>
                </dependency>
```
2. 添加web.xml配置文件中关于SpringMVC的配置
```xml
  <display-name>Archetype Created Web Application</display-name>
    <servlet>
        <servlet-name>dispatcherServlet</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:spring-config.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>
    
    <servlet-mapping>
        <servlet-name>dispatcherServlet</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
```
3. 在资源文件 resources 中添加 spring-config.xml 配置文件
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans
        xmlns="http://www.springframework.org/schema/beans"
        xmlns:context="http://www.springframework.org/schema/context"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns:aop="http://www.springframework.org/schema/aop"
        xmlns:mvc="http://www.springframework.org/schema/mvc"
        xmlns:jee="http://www.springframework.org/schema/jee"
        xmlns:tx="http://www.springframework.org/schema/tx"
        xsi:schemaLocation="
    http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
    http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd
    http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop.xsd
    http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc.xsd
    http://www.springframework.org/schema/jee http://www.springframework.org/schema/jee/spring-jee.xsd
    http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx.xsd">
    <!-- 开启spring的扫描注入，使用如下注解 -->
    <!-- @Component,@Repository,@Service,@Controller-->
    <context:component-scan base-package="com.ai.springmvc"></context:component-scan>
    <!-- 开启springMVC的注解驱动，使得url可以映射到对应的controller -->
    <mvc:annotation-driven />
    <!-- 视图解析 -->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/WEB-INF/jsps/"/>
        <property name="suffix" value=".jsp"/>
    </bean>
</beans>

```
4. 在WEB-INF创建一个jsps的文件夹,存放jsp视图.也创建一个hello.jsp,在body随便写点文字.
5. create package and controller,such as



### 用Spring MVC开发
