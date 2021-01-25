package com.bjpowernode.service;

import com.bjpowernode.pojo.Account;

import java.util.List;

/**
 * 杨廷甲
 * 2020-12-07
 */

//账户的业务层接口
public interface IAccountService {

    //查询所有
    List<Account> findAllAccount();

    //根据id查找
    Account findAccountById(Integer accountId);

    //保存
    void saveAccount(Account account);

    //更新
    void updateAccount(Account account);


    //删除
    void deleteAccount(Integer accountId);


}
