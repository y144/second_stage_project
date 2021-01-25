package com.bjpowernode.controller;

import com.bjpowernode.pojo.Admin;
import com.bjpowernode.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 杨廷甲
 * 2020-12-15
 */

@Controller
@RequestMapping("/admin")
public class AdminController {

    //这里必须要有adminService的对象
    @Autowired
    AdminService adminService;
    @RequestMapping("/login")
    public String login(String name, String pwd, HttpSession session, HttpServletRequest request){

        Admin admin = adminService.login(name, pwd);/*用户在页面点击登录后在会访问这个登录的控制层类，然后找到控制层中的登录的方法开始执行，执行到这里时controller层会调用service层中的登录验证方法，然后service层中的登录验证方法又会调用持久层(mapper/dao)中的数据库查询方法，找到数据库中的对应id的用户，将用户信息进行返回，在返回到service层，在service再进行数据信息的比对，将比对结果返回至controller层，controller层根据返回的结果进行结果的处理(登录成功页面的跳转的处理或者登录失败页面跳转的处理)将结果返回至用户页面，指引用户进行下一步操作*/
        if (admin != null){
            //将对象放入session
            session.setAttribute("admin",admin);
            return "main";
        }else {
            request.setAttribute("errmsg", "用户名或者密码不正确");
            return "login";
        }
    }
}
