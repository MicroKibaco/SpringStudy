package com.ai.springboot.classloader;

/**
 * BaseManager的子类,此类需要实现java类的热加载
 */
public class MyManager implements BaseManager {
    @Override
    public void logic() {
        System.out.println("手把手教你实现类加载");
        System.out.println("天道酬勤");
    }
}
