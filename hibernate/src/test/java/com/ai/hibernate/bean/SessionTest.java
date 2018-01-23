package com.ai.hibernate.bean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class SessionTest {


    @Test
    public void testOpenSession() {

        Configuration config = new Configuration().configure();
        SessionFactory factory = config.buildSessionFactory();

        // 创建会话对象
        Session session = factory.openSession();
        if (session != null) {
            System.out.println("session创建成功");
        } else {
            System.out.println("session创建失败");
        }


    }

    @Test
    public void testGetCurrentSession() {
        Configuration config = new Configuration().configure();
        SessionFactory factory = config.buildSessionFactory();
        // 创建会话对象
        Session session = factory.getCurrentSession();
        if (session != null) {
            System.out.println("session创建成功");
        } else {
            System.out.println("session创建失败");
        }
    }

}
