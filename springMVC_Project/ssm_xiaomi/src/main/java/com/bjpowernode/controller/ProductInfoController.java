package com.bjpowernode.controller;

import com.bjpowernode.pojo.ProductInfo;
import com.bjpowernode.service.ProductInfoService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * 杨廷甲
 * 2020-12-15
 */

@Controller
@RequestMapping("/prod")
public class ProductInfoController {

    //分页的静态常量
    public static final int PAGE_SIZE=5;

    //service层的对象
    /*
    * 面向接口编程就是先把客户的业务逻辑线提取出来，作为借口，业务的具体实现是通过该接口的实现类来完成，当客户需求变化时，只需编写该业务逻辑的新的实现类，通过更改配置文件(例如spring框架中)中该接口的实现类就可以完成需求，不需要改写现有的代码，减少对系统的影响。
    * */
    @Autowired
    ProductInfoService productInfoService;

    @RequestMapping("getAll")
    public String getAll(HttpServletRequest request){
        List<ProductInfo> list = productInfoService.getAll();
        request.setAttribute("list", list);
        return "product";
    }


    //进行分页查询
    @RequestMapping("/split")
    public String split(HttpServletRequest request){
        //得到分页的数据pageInfo
        PageInfo<ProductInfo> info = productInfoService.splitPage(1, PAGE_SIZE);//pageSize这里一般会写成一个常量(常量可以写在配置文件中可以灵活的使用 改变)

        request.setAttribute("info", info);
        return "product";
    }

    //使用ajax分页的方法
    @RequestMapping("/ajaxsplit")
    @ResponseBody  //这个注解专门用来处理ajax的请求，并且将返回对象自动转换为json格式
    public void ajaxSplit(int page, HttpSession session){

        PageInfo<ProductInfo> info = productInfoService.splitPage(page, PAGE_SIZE);
        session.setAttribute("info", info);
    }

    //删除
    @RequestMapping("/delete")
    public String delete(int pid,HttpServletRequest request){

        int num = productInfoService.delete(pid);
        if (num > 0){
            request.setAttribute("msg", "删除成功！！");
            //删除成功，得重新访问数据库，在回到页面显示
            return "forward:/prod/split.action";
        }else {
            request.setAttribute("msg", "删除失败！！");
            //删除失败则回到商品显示的页面
            return "product";
        }
    }
    //批量删除商品
    @RequestMapping("/deleteBatch")
    public String deleteBatch(String str,HttpServletRequest request){
        String[] array = str.split(",");
        int num = productInfoService.deleteBatch(array);
        if (num > 0){
            request.setAttribute("msg", "删除成功！！");
            //删除成功，得重新访问数据库，在回到页面显示
            return "forward:/prod/split.action";
        }else {
            request.setAttribute("msg", "删除失败！！");
            //删除失败则回到商品显示的页面
            return "product";
        }
    }

    //商品增加
    @RequestMapping("/save")
    public String save(ProductInfo info,HttpServletRequest request){
        //因为没有从页面提交上来的日期，所以要在这里进行手工设置
        info.setpDate(new Date());
        int num = productInfoService.insert(info);
        if (num > 0){
            request.setAttribute("msg", "增加成功！！");
            //删除成功，得重新访问数据库，在回到页面显示
            return "forward:/prod/split.action";
        }else {
            request.setAttribute("msg", "增加失败！！");
            //删除失败则回到商品显示的页面
            return "product";
        }
    }

    //安主键查找
    @RequestMapping("/one")
    public String one(Integer pid,Integer page, Model model) {
        ProductInfo info = productInfoService.getById(pid);
        model.addAttribute("prod", info);
        model.addAttribute("page",page);
        return "update";
    }



    //更新操作
    @RequestMapping("/update")
    public String update(ProductInfo info,Integer page,HttpServletRequest request) {



        boolean flag = false;
        //有没有时间改变
        //此处要进行info对象的上架时间的更新
        //首先要判断当前新更新上来的日期不能大于当前日期
        if (info.getpDate() != null) {
            if (info.getpDate().getTime() > System.currentTimeMillis()) {
                //日期不正常了，则置为空，底层做更新处理时不做更改
                info.setpDate(null);
                flag=true;
            }
        }
        //完成对象更新
        int num = -1;
        try {
            num = productInfoService.update(info);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (num > 0) {
            if (flag) {
                request.getSession().setAttribute("msg", "日期不能大于当前日期");
            } else {
                request.getSession().setAttribute("msg", "更新成功！");
            }
        } else {
            request.getSession().setAttribute("msg", "更新失败");
        }
        return "redirect:/prod/split.action?page="+page;
    }
}
