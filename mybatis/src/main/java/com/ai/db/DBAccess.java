package com.ai.db;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;


/**
 * 访问数据库
 */
public class DBAccess {

    public SqlSession getSqlSession() throws IOException {

        // 通过配置文件获取数据库链接信息
        Reader reader = Resources.getResourceAsReader("Configuration.xml");
        // 通过配置信息构建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
        // 通过SqlSessionFactory打开数据库会话
        return factory.openSession();
    }

}
