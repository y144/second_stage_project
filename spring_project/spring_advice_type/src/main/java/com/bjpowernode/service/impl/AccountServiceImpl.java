package com.bjpowernode.service.impl;

import com.bjpowernode.service.IAccountService;

/**
 * 杨廷甲
 * 2020-12-09
 */
public class AccountServiceImpl implements IAccountService {
    @Override
    public void saveAccount() {
        System.out.println("执行力保存");
    }

    @Override
    public void updateAccount(int i) {
        System.out.println("执行了更新");
    }

    @Override
    public int deleteAccount() {
        System.out.println("执行了删除");
        return 0;
    }
}
