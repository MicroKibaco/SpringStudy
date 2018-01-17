package com.ai.spring.transaction;

/**
 * 转账业务层的实现类
 */
public class AccountServiceImpl implements AccountService {

    // 注入我们转账的DAO类

    public AccountDao getAccountDao() {
        return mAccountDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        mAccountDao = accountDao;
    }

    private AccountDao mAccountDao;

    public AccountServiceImpl(AccountDao accountDao) {
        mAccountDao = accountDao;
    }

    public AccountServiceImpl() {
    }


    /**
     * @param out   :转出的账号
     * @param in    :转入的账号
     * @param money :转账金额
     */
    public void transfer(String out, String in, Double money) {
        mAccountDao.outMoney(out, money);
        mAccountDao.inMoney(in, money);
    }
}
