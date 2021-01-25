package com.bjpowernode.service.impl;

import com.bjpowernode.dao.IAccountDao;
import com.bjpowernode.dao.impl.AccountDaoImpl;
import com.bjpowernode.service.IAccountService;

/**
 * 杨廷甲
 * 2020-12-06
 */
//账户的业务层的实现类
public class AccountServiceImpl implements IAccountService {
     private IAccountDao accountDao = new AccountDaoImpl();

    //业务层调用持久层
    public void saveAccount(){
        accountDao.saveAccount();
    }
}
