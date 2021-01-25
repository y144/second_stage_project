package com.bjpowernode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 杨廷甲
 * 2020-12-11
 */
//@RestController  //表时此类中所有的请求都是ajax请求,而且每个方法都不用写注解@ResponseBody
@Controller  //交给spring框架来创建控制器的对象
@RequestMapping("/zar")  //这个注解用来进行当前的注解路径的处理(给当前对象起一个名字起一个映射的路径，因为在访问的时候是根据路劲访问的，/zar就是类的名称的路径，相当于总包)
public class Hello {

    /*
    * controller中方法的规范：
    *   访问权限是public
    *   返回值一般是String,  ajax的请求来的时候是Object,或者void
    *   方法名称是自定义
    *
    *   为了让客户的找到此方法，必须添加@RequestMapping注解
    * */

    @RequestMapping("/show")//通过这个注解找到这个方法，指明我当前这个方法较show
    public String showHello(){
        System.out.println("action被访问到了");
        return "main";  //main 是返回的页面的名称，其路径的前缀和后缀在springmvc的配置文件中指定
     }
}
