package com.bjpowernode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 杨廷甲
 * 2020-12-12
 */

@Controller
@RequestMapping("/one")
public class One {

    /*
    * 因为所有资源文件都放在WEB-INF的路径下，无法对外直接访问
    * 所有必须要使用请求转发的方式进行访问
    *有一个页面就要有一个对应的action进行访问
    * 下面的这个action就是进行index.jsp页面的访问
    * */
    @RequestMapping("/showIndex")
    public String showIndex(){
        return "index";
    }


    /*因为所有资源文件都放在WEB-INF的路径下，无法对外直接访问
    所有必须要使用请求转发的方式进行访问
    我们首先要达到这个登录页面才能进行登录验证，所以需要在这里写一个进入登录页面的请求转发访问
    */
    @RequestMapping("/showLogin")
    public String showLogin(){
        return "login";
    }


    //为了在外部访问到main.jsp,提供请求转发的action
    @RequestMapping("/showMain")
    public String showMain(){
        return "main";
    }


    /*
    * 到达登录页面的后进行了登录处理后，需要对登录的信息进行验证
    * */
    @RequestMapping("/login")
    public String login(String myname, String password, HttpSession session, HttpServletRequest request){

        if ("admin".equals(myname) && "123".equals(password)){
            //如果登录成功就要将登录对象的信息放入Session中，以便于
            session.setAttribute("admin", myname);
            return "main";
        }else {
            request.setAttribute("msg", "您的用户名或密码不正确，请重新登录！！");
            return "login";
        }
    }
}
