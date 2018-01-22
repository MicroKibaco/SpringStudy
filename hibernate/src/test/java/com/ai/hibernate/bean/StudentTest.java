package com.ai.hibernate.bean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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

        // 关闭会话
        mSession.close();

        // 关闭会话工厂
        mSessionFactory.close();
    }

    @Test
    public void testSaveStudent() {

        // 生成学生对象
        Student student = new Student(1, "杨正友", "男", new Date(), "长沙");

        // 保存对象进数据库
        mSession.save(student);


    }

}
