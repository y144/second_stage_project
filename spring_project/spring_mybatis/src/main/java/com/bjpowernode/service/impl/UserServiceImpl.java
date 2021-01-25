package com.bjpowernode.service.impl;

import com.bjpowernode.mapper.AccountsMapper;
import com.bjpowernode.mapper.UsersMapper;
import com.bjpowernode.pojo.Accounts;
import com.bjpowernode.pojo.Users;
import com.bjpowernode.service.UserService;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 杨廷甲
 * 2020-12-10
 */

@Service   //将主业务对象的创建交给spring来管理，并spring会自动注入mapper，一个注解会完成两套动作
/*@Transactional(propagation = Propagation.REQUIRED,
                noRollbackFor = ArithmeticException.class,
                readOnly = true,timeout = -1,
                noRollbackForClassName = "ArithmeticException",
                isolation = Isolation.DEFAULT) //事务的注解,此注解加在类上，那么该类中的所有方法支持事务，如果加在方法上那么只有该方法支持事务*/
public class UserServiceImpl implements UserService {

    @Autowired   //注意:这里一定要有数据访问层的对象
    UsersMapper userMapper;

    @Autowired
    AccountsMapper accountsMapper;

    @Override
    public int insertUsers(Users users) {

        //增加用户就相当于A方法，增加账户就相当于B方法
        int num = userMapper.insertUsers(users);
        System.out.println("执行完用户增加后受影响的行数"+num);
        int as = 10/0;  //自己设置一个异常

        //调用账户增加的功能
        accountsMapper.saveAccounts(new Accounts(22, "加工费里看电视", "gflkg"));
        return num;
    }
}
