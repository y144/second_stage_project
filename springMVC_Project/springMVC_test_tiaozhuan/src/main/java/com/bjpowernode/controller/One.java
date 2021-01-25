package com.bjpowernode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 杨廷甲
 * 2020-12-12  四种主要的跳转方式
 */
@Controller
@RequestMapping("/one")
public class One {

    /*
    *1、默认就是请求转发页面的，要借助于视图解析器进行地址拼接
    *视图解析器会将请求转发的地址进行拼接
    * 前缀拼接：/admin/+自己的控制器方法的返回需要跳转的页面名称(需要的资源名称)+视图解析器的后缀拼接：.jsp
    * 拼接后的请求转发的地址就是：/admin/main.jsp
    * */
    @RequestMapping("/requestTransmitPage")
    public String requestTransmitPage(){
        return "main";
    }

    /*
    *2、请求转发跳Action(就是我们说的Servlet,Action只不过就是我们人为设定的一个名字，在发起请求的过程中.action表示只拦截.action的请求后对该请求进行执行处理 文件路径中的.action在这里表示找到请求路径中的类中的方法进行执行)
    *使用关键字：forward后，就表示自动停用视图解析器，视图解析器将无效，自动按照forward后的 手工拼接地址 进行跳转
    * */
    @RequestMapping("/requestTransmitAction")
    public String requestTransmitAction(){
        System.out.println("达到了请求转发跳action");
        return "forward:/two/show.action";
    }

    /*
    * 3、重定向跳转页面，使用关键字redirect来完成，redirect后面指定需要重定向的手动拼接的地址
    * 同样使用redirect关键字也会使 视图解析器自动停用失效，而是按照手工拼接的地址进行重定向跳转
    * */
    @RequestMapping("/againGuidePage")
    public String againGuidePage(){
        System.out.println("我是重定向来跳转页面的....");
        //通过指定路径来跳转
        return "redirect:/admin/main.jsp";
    }

    /*
    * 4、重定向跳转Action,也是使用redirect关键字，在其后指定重定向的地址，使视图解析器失效，按照手工拼接的地址进行重定向进行跳转，与重定向跳转页面的跳转方法一致
    * */
    @RequestMapping("/againGuideAction")
    public String againGuideAction(){
        System.out.println("我是重定向跳转Action");
        //也是通过指定路径来跳转
        return "redirect:/two/show.action";
    }
}
