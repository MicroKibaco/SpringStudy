package com.ai.springboot.classloader;

/**
 * 测试java类的热加载
 */
public class ClassLoaderTest  {

    public static void main(String [] args){
        new Thread(new MsgHandler()).start();
    }

}
