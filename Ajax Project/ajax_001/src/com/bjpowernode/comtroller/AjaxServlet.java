package com.bjpowernode.comtroller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ajax")//这个ajax名字应该与index.jsp中初始化异步对象时填写的地址一致
public class AjaxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("被访问到了");
        //设置中文编码
        response.setContentType("text/html;charset=utf-8");
        //通过响应对象得到输出流
        PrintWriter pw = response.getWriter();
        pw.write("dedao sjhifkkjds");
        pw.flush();
        pw.close();


    }
}
