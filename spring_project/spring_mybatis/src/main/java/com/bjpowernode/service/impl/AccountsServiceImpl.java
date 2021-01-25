package com.bjpowernode.service.impl;

import com.bjpowernode.mapper.AccountsMapper;
import com.bjpowernode.pojo.Accounts;
import com.bjpowernode.service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 杨廷甲
 * 2020-12-11
 */

@Service  //在业务逻辑层这里添加这个注解表示将业务逻辑层的创建对象的功能交给spring来管理,并且依赖注入AccountsMapper对象
public class AccountsServiceImpl implements AccountsService {


    //切记在业务逻辑层必须要有数据范文层的对象
    @Autowired
    AccountsMapper accountsMapper;

    @Override
    public int saveAccounts(Accounts accounts) {
        int num = accountsMapper.saveAccounts(accounts);
        System.out.println("执行完增加账户后，受影响的行数"+num);
        //int div = 10/0;//生生的在这里抛出异常
        return num;
    }
}
