package com.ai.spring.transaction;

/**
 * 转账案例的Dao层接口
 */
public interface AccountDao {

    public void outMoney(String out,Double money);


    public void inMoney(String in,Double money);
}
