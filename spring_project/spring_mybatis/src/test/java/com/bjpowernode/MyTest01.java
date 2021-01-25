package com.bjpowernode;

import com.bjpowernode.pojo.Accounts;
import com.bjpowernode.pojo.Users;
import com.bjpowernode.service.AccountsService;
import com.bjpowernode.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 杨廷甲
 * 2020-12-10
 */
public class MyTest01 {

    ApplicationContext ac;
    @Before
    public void getAc(){
        ac = new ClassPathXmlApplicationContext("applicationContext_trans.xml");
    }

    @Test
    public void test01(){
        int flag;

        Users users = new Users(18,"zhang","1234");
        UserService userService = ac.getBean(UserService.class);
        flag = userService.insertUsers(users);
        if (flag > 0){
            System.out.println("Users添加用户成功！！");
        }
    }

    @Test
    public void test02(){
        int flag;

        Accounts accounts = new Accounts(116, "回房间卡萨", "和反对党");
        AccountsService accountsService = ac.getBean(AccountsService.class);
        flag = accountsService.saveAccounts(accounts);
        if (flag > 0){
            System.out.println("Accounts添加用户成功！！");
        }
    }
}
