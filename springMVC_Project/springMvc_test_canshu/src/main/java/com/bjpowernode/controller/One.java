package com.bjpowernode.controller;

import com.bjpowernode.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;

/**
 * 杨廷甲
 * 2020-12-12
 */

@Controller
@RequestMapping("/one")
public class One {

    /*
    * 从客户端提供单个数据的提交
    * 在action方法的参数中，使用于表单提交相同的name属性值的参数名，进行数据的自动注入
    * */
    @RequestMapping("/danGe")
    public String helloi(String uname,int age){//这里的参数名称要与 表单元素name的属性值一致
        System.out.println("用户名"+uname+"============"+"年龄"+age);
        return "main";
    }

    /*
    *此方法接收的数据是以对象的形式自动注入
    * 要求：类中的成员变量名称要与表单元素name属性值一致
    * 则可以自动注入到方法参数的对象中
    * */
    @RequestMapping("/object")
    public String object(Users users){
        System.out.println(users.getUname()+"----"+users.getAge());
        return "main";
    }

    /*
    *表单元素的name属性值与方法中参数名不一致，要用@RequestParam来解析
    * */
    @RequestMapping("/three")
    public String three(
            @RequestParam("myname")
            String uname,
            @RequestParam("myage")
            int age){
        System.out.println(uname+"----"+(age+19));
        return "main";
    }

    /*
    *从地址栏或者超链接中读取数据，使用@PathVariable这个注解来取值
    *在@RequestMapping("/four/{name}/{age}/{spring}")，页面传入几个值就在/four后面写几个/{},
    * 并且里面是自定义的名称
    *@PathVariable("引用自定义的名称 ")，如果名称一样，则省略小括号
    * */
    @RequestMapping("/four/{name}/{age}/{spring}")
    public String four(
            @PathVariable("name")
            String name,
            @PathVariable("age")
            int age,
            @PathVariable("spring")
            String spring){
        System.out.println(name+"===="+age+"---------"+spring);
        return "main";
    }


    /*
    * 使用HttpServletRequest对象，像以前一样手工读取请求参数，进行数据的封装
     * */
    @RequestMapping("/five")
    public String five(HttpServletRequest request){
        String name = request.getParameter("uname");
        int age = Integer.parseInt(request.getParameter("age"));
        System.out.println(name +"==="+age);
        return "main";
    }
}
