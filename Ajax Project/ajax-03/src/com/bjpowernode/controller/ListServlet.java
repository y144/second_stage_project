package com.bjpowernode.controller;

import com.bjpowernode.pojo.Student;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/two")
public class ListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建学生对象
        Student stu1 = new Student("张三", "18", "男");
        Student stu2 = new Student("李四", "19", "男");
        Student stu3 = new Student("王五", "20", "男");
        Student stu4 = new Student("赵柳", "28", "男");
        //将学生对象保存在集合中
        List<Student> studentList = new ArrayList<>();
        studentList.add(stu1);
        studentList.add(stu2);
        studentList.add(stu3);
        studentList.add(stu4);
        //2.将学生集合转为JSON串,得借助于JSON工具类,导入相应的jar包才可以调用功能
        ObjectMapper om = new ObjectMapper();
        String  json = om.writeValueAsString(studentList);
        System.out.println(json);
        //3.返回到客户端
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.write(json);
        pw.flush();
        pw.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }
}
