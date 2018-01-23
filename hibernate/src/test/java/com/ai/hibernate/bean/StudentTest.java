package com.ai.hibernate.bean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;


public class StudentTest {

    private SessionFactory mSessionFactory;
    private Session mSession;
    private Transaction mTransaction;

    @Before
    public void init() {
        // 创建配置对象
        Configuration config = new Configuration().configure();

        // 创建服务注册对象
        mSessionFactory = config.buildSessionFactory();

        // 创建会话对象
        mSession = mSessionFactory.openSession();

        // 开启事务
        mTransaction = mSession.beginTransaction();

    }


    @After
    public void destory() {
        mTransaction.commit();
        // 关闭会话
        mSession.close();
        // 关闭会话工厂
        mSessionFactory.close();

    }

    @Test
    public void testSaveStudent() {

        // 生成学生对象
        Student s = new Student(4, "小木箱", "女", new Date(), "衡阳");

        mSession.doWork(new Work() {
            public void execute(Connection connection) throws SQLException {
                connection.setAutoCommit(false);
            }
        });

        // 保存对象进数据库
        mSession.save(s);
        mSession.flush();


    }

}
