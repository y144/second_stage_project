package com.bjpowernode.controller;

import org.springframework.beans.propertyeditors.CurrencyEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 杨廷甲
 * 2020-12-12
 */
@Controller
@RequestMapping("/three")
public class Three {


    @InitBinder  //注解转换器 WebDataBinder绑定器
    public void initBinder(WebDataBinder binder){
        //创建如期处理的格式化刷子类
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sf, true));
    }

    /*
    * 在当前的类中添加@InitBinder注解，在本类中的所有日期类型在被注入到方法参数时,自动调用此注解进行类型转换
    * */
    @RequestMapping("/showDate")
    public String showDate(Date mydate, HttpServletRequest request){

        System.out.println(mydate);
        request.setAttribute("mydate", mydate);
        return "main";
    }
}
