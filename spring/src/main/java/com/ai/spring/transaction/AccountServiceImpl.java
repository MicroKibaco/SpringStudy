package com.ai.spring.transaction;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * 转账业务层的实现类
 */
public class AccountServiceImpl implements AccountService {

    // 注入我们转账的DAO类
    private AccountDao mAccountDao;

    // 注入事务管理的模板
    private TransactionTemplate mTransactionTemplate;


    public void setAccountDao(AccountDao accountDao) {
        mAccountDao = accountDao;
    }

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.mTransactionTemplate = transactionTemplate;
    }

    public AccountServiceImpl(AccountDao accountDao) {
        this.mAccountDao = accountDao;
    }

    public AccountServiceImpl() {
    }

    /**
     * @param out   :转出的账号
     * @param in    :转入的账号
     * @param money :转账金额
     */
    public void transfer(final String out, final String in, final Double money) {

        mTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                mAccountDao.outMoney(out, money);
            //    int i = 1 / 0;
                mAccountDao.inMoney(in, money);
            }
        });
    }


}
