package com.ai.springboot.classloader;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 加载Manager的工厂
 */
public class ManagerFactory {

    // 记录热加载类的加载信息
    private static final Map<String, LoadInfo> loadTimeMap = new HashMap<>();

    // 要加载的类的classpath
    public static final String CLASS_PATH = "Study/Spring/SpringStudy/spring-boot/target/classes/com/ai/springboot/classloader/bin";

    // 定义一个类的全路径,全名称
    public static final String MY_MANAGER = "com.ai.springboot.classloader.MyManager";

    public static BaseManager getManager(String className) {

        File loadFile = new File(CLASS_PATH + className.replaceAll("\\.", "/") + ".class");
        long lastModified = loadFile.lastModified();

        // loadTimeMap不包含className为key的LoadInfo信息.证明这个类没有被加载,那么需要加载这个类到JVM
        if (loadTimeMap.get(className) == null) {
            load(className, lastModified);


        }

        // 加载类的时间戳变化了,我们同样要加载这个类到jvm
        return loadTimeMap.get(className).getBaseManager();
    }

    private static void load(String className, long lastModified) {

        MyClassLoader myClassLoader = new MyClassLoader(CLASS_PATH);
        Class<?> loadClass = null;
        try {
            loadClass = myClassLoader.loadClass(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        BaseManager baseManager = newInstance(loadClass);
        LoadInfo loadInfo = new LoadInfo(myClassLoader, lastModified);
        loadInfo.setBaseManager(baseManager);
        loadTimeMap.put(className, loadInfo);


    }

    // 以反射的方式创建BaseManager子类对象
    private static BaseManager newInstance(Class<?> loadClass) {
        try {
            return (BaseManager) loadClass.getConstructor(new Class[]{}).newInstance(new Object[]{});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
