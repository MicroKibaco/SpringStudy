### 什么是ORM
写SQL语句有什么不好?
1. 不同的数据库使用的SQL语法不同.比如:PL/SQL与T/SQL
2. 同样的功能在不同的数据库中有不同的实现方式.比如:分页SQL

### 什么是Hibernate
- Hibernate是Java领域的一款开源的ORM技术
- Hibernate对JDBC进行了非常轻量级的对象封装

### 其他主流框架
- MyBatis: 前身就是著名的iBatis
- TopLink: 后被Oracle收购,并重新包装为Oracle AS TopLink
- EJB: 本身就是JavaEE规范 

### Hibernate入门
- 创建一个Hibernate的配置文件
- 创建持久化类
- 创建对象-关系映射文件
- 通过Hibernate API编写访问数据库代码

### session简介
session是数据库的操作对象
- 如何获得session对象
1) openSession
需要手动关闭,每次都创建了新的Session对象
2) getCurrentSession
在事务提交或者回滚之后自动关闭,使用现有的Session对象 

### 单一主键
- assigned 由java应用程序负责生产(手工赋值)
- native 由底层数据库自动生成标志符,如果是MySQL就是increment,如果Oracle就是sequene等等