package com.bjpowernode.dao.impl;

import com.bjpowernode.dao.IAccountDao;
import com.bjpowernode.pojo.Account;

import java.util.List;

/**
 * 杨廷甲
 * 2020-12-07
 */

//顾客的持久层实现类
public class AccountDaoImpl implements IAccountDao {
    @Override
    public List<Account> findAllAccount() {
        return null;
    }

    @Override
    public Account findAccountById(Integer accountId) {
        return null;
    }

    @Override
    public void saveAccount(Account account) {

    }

    @Override
    public void updateAccount(Account account) {

    }

    @Override
    public void deleteAccount(Integer accountId) {

    }
}
