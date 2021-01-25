package com.bjpowernode.service.impl;

import com.bjpowernode.dao.IAccountDao;
import com.bjpowernode.pojo.Account;
import com.bjpowernode.service.IAccountService;

import java.util.List;

/**
 * 杨廷甲
 * 2020-12-07
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    public AccountServiceImpl setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
        return this;
    }

    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    @Override
    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }
}
