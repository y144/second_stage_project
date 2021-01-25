package com.bjpowernode.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/bmi")
public class BmiAjaxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msg = "";
        String name = request.getParameter("name");
        //进行数据转换
        float weight = Float.parseFloat(request.getParameter("weight"));
        float height = Float.parseFloat(request.getParameter("height"));
        //计算bmi
        float bmi = weight/(height * height);
        //判断bmi
        if (bmi < 18.5){
            msg = "您的体质过瘦，请多吃点，加强体质！";
        }else if (bmi >= 18.5 && bmi < 23.9){
            msg = "您的体质正常，请继续保持";
        }else if (bmi >= 23.9 && bmi <= 27){
            msg = "您的体质过重，请注意饮食";
        }else if (bmi > 27 && bmi <32){
            msg = "您的体质为肥胖，请注意饮食";
        }else {
            msg = "您的体质为过度肥胖，请注意饮食";
        }
        //将得到的结果通过响应对象得到的输出流进行输出到异步响应对象中的属性innerText
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.write("您的bmi = "+bmi+",您的状态是："+msg);
        pw.flush();
        pw.close();

    }
}
