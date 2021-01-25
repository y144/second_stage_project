package com.bjpowernode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 杨廷甲
 * 2020-12-12
 */
@Controller
@RequestMapping("/two")
public class Two {

    @RequestMapping("/show")
    public String show(){
        return "main";
    }
}
