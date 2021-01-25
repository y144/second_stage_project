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

@WebServlet("/you")
public class YouServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.构建学生对象
        Student stu1 = new Student("张三","21","男");
        Student stu2 = new Student("李四","2","男");
        Student stu3 = new Student("王五","23","男");
        Student stu4 = new Student("赵柳","25","男");

        //将学生放入集合中
        List<Student> list = new ArrayList<>();
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);
        list.add(stu4);
        //得到Session对象，将这个学生的集合放入到这个Session中，这个Session的名字叫"list"
        request.getSession().setAttribute("list",list);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }
}
