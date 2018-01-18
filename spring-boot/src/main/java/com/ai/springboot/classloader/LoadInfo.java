package com.ai.springboot.classloader;

/**
 * 封装加载类的信息
 */
public class LoadInfo  {

    // 自定义类加载器
   private MyClassLoader mLoader;

   // 记录要加载类的时间戳
    private long loadTime;

    // 自定义类加载器
    private BaseManager mBaseManager;

    public MyClassLoader getLoader() {
        return mLoader;
    }

    public void setLoader(MyClassLoader loader) {
        mLoader = loader;
    }

    public long getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(long loadTime) {
        this.loadTime = loadTime;
    }

    public BaseManager getBaseManager() {
        return mBaseManager;
    }

    public void setBaseManager(BaseManager baseManager) {
        mBaseManager = baseManager;
    }

    public LoadInfo(MyClassLoader loader, long loadTime) {
        super();
        this.mLoader = loader;
        this.loadTime = loadTime;
    }




}

