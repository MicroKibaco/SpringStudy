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
     <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath:spring-context-config.xml</param-value>
    </context-param>
    <servlet>
        <servlet-name>springmvc</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:springmvc-servlet.xml</param-value>
        </init-param>
    </servlet>
    <servlet-mapping>
        <servlet-name>springmvc</servlet-name>
        <url-pattern>/*</url-pattern>
    </servlet-mapping>
    <filter>
        <filter-name>encoding</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
        <init-param>
            <param-name>encoding</param-name>
            <param-value>UTF-8</param-value>
        </init-param>
        <init-param>
            <param-name>forceEncoding</param-name>
            <param-value>true</param-value>
        </init-param>
    </filter>
    <filter-mapping>
        <filter-name>encoding</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
```
3. 在资源文件 resources 中添加 Spring容器的 spring-context-config.xml 配置文件
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
    <context:component-scan base-package="com.ai.springmvc">
        <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller"></context:exclude-filter>
    </context:component-scan>

</beans>


```
4. 在资源文件 resources 中添加 MVC容器的 springmvc-servlet.xml 配置文件
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
    <context:component-scan base-package="com.ai.springmvc">
        <context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"></context:include-filter>
    </context:component-scan>
    <!-- 开启springMVC的注解驱动，使得url可以映射到对应的controller -->
    <mvc:annotation-driven />
    <!-- 视图解析 -->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/WEB-INF/jsps/"/>
        <property name="suffix" value=".jsp"/>
    </bean>

    <mvc:default-servlet-handler></mvc:default-servlet-handler>
</beans>
```

5. 在WEB-INF创建一个jsps的文件夹,存放jsp视图.也创建一个hello.jsp,在body随便写点文字.
6. create package and controller,such as

```java
@Controller
// Said this is a controller, when the request will be scan to see if there is match RequestMapping
@RequestMapping("/hello") // Said mapping routing, said here is /hello/index
public class HelloMvcController {
    // http://localhost:8888/hello/home
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String index(HttpServletRequest request) {
        return "home"; //  表示使用的模版是index，也就是 webapp/index.jsp
    }
}
```
7. 启动服务器，键入 http://localhost:8080/路由名称/home.jsp

### 配置解析
- DispatcherServlet
DispatcherServlet 是前置控制器, 配置在web.xml文件中的.拦截配置请求,Servlet拦截匹配规则要自己定义
,把拦截请求下来的请求,依据相应的规则分发到目标Controller来处理,是配置Spring MVC的第一步

- InternalResourceViewResolver
视图拦截器

- SpringMVC常用注解
1) @Controller
负责注册一个bean 到spring 上下文中
2) @RequestMapping
注解为控制器指定可以处理哪些 URL 请求
3) @RequestBody
该注解用于读取Request请求的body部分数据,使用系统默认配置的HttpMessageConverter进行解析,然后将相应数据绑定到要返回的对象上,再把HttpMessageConverter返回对象数据绑定到controller中方法参数上
4) @ResponseBody
该注解用于将Controller的方法返回的对象,通过适当的HttpMessageConverter转化为指定格式后,写入到Response对象的boddy数据区
5) @ModelAttribute  
(I). 在方法定义上使用 @ModelAttribute注解: Spring MVC 在调用目标处理方法前, 会先逐个调查在方法级上标注了@ModelAttribute 的方法

   (II). 在方法入参上使用 @ModelAttribute注解: 可以从隐含对象中获取隐含的模型数据中获取对象, 再将请求参数-绑定到对象中,再传入入参中,在传入入参将方法入参对象添加到模型中
6) @RequestParam　
在处理方法入参使用 @RequestParam 可以把请求参数传递给请求方法
7) @PathVariable
绑定 URL 占位符 到入参
8) @ExceptionHandler
注解到方法上,出现异常时执行方法
9) @ControllerAdvice
使一个Controller成为全局异常处理类,类中用@ExceptionHandler方法注解的方法可以处理所有Controller发生的异常

 



### 用Spring MVC开发
