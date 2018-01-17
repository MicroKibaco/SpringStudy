package com.ai.test.transaction;

import com.ai.spring.transaction.AccountServiceImpl;
import com.ai.test.base.UnitTestBase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * 转账案例的测试
 */

@RunWith(BlockJUnit4ClassRunner.class)
public class TestTransaction extends UnitTestBase {

    public TestTransaction() {
        super("classpath:spring-transaction.xml");
    }

    @Test
    public void testAccountService() {
        AccountServiceImpl accountService = super.getBean("accountService");
        accountService.transfer("aaa", "bbb", 200d);

    }

}
