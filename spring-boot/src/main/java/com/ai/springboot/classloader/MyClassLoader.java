package com.ai.springboot.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * 自定义java类加载器来实现java类的热加载
 */
public class MyClassLoader extends ClassLoader {

    // 要加载的java类的classpath
    private String mClassPath;

    public MyClassLoader( String classPath) {
        super(ClassLoader.getSystemClassLoader());
        this.mClassPath = classPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        byte[] data = this.loadClassData(name);

        return this.defineClass(name, data, 0, data.length);
    }

    /**
     * 加载class文件中的内容
     */
    private byte[] loadClassData(String name) {

        try {
            name = name.replace(".", "//");
            FileInputStream is = new FileInputStream(new File(mClassPath + name + ".class"));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int b = 0;
            while ((b = is.read()) != -1) {
                baos.write(b);
            }
            is.close();
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
