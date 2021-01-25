package com.bjpowernode.service.impl;

import com.bjpowernode.dao.IAccountDao;
import com.bjpowernode.dao.impl.AccountDaoImpl;
import com.bjpowernode.factory.BeanFactory;
import com.bjpowernode.service.IAccountService;

/**
 * 杨廷甲
 * 2020-12-06
 */
//账户的业务层的实现类
public class AccountServiceImpl implements IAccountService {

//    private IAccountDao accountDao = new AccountDaoImpl();
      private IAccountDao accountDao =(AccountDaoImpl) BeanFactory.getBean("accountDao");

      //private int i = 1;//但是在我么实际的service和dao中是不存在这种成员变量的，那么我们就其实没有线程问题的，因为我们没有在单例对象中可以改变的类成员 ，都是将这种变脸定义到方法中的,那么由于每次方法都会被初始化，所以也能保证每次得到的都是1
    //业务层调用持久层
    public void saveAccount(){
        int i = 1;
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
