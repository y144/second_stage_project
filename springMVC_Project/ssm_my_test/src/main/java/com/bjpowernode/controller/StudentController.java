package com.bjpowernode.controller;

import com.bjpowernode.pojo.Student;
import com.bjpowernode.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 杨廷甲
 * 2020-12-13
 * 学生WEB控制层
 */
@Controller
@RequestMapping("/account")
public class StudentController {

    @Autowired //Controller层通过这个Service接口对象,调用Service层实现
    private StudentService studentService;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        System.out.println("表现层查询所有学生信息.....");
        //调用service方法  <在这里会开始一层一层之间的调用来访问数据，最后将数据返回到这个集合中>
        List<Student> studentList = studentService.findAll();
        model.addAttribute("list", studentList);
        return "list";
    }

    @RequestMapping("/save")
    public void saveStudent(Student student, HttpServletRequest request, HttpServletResponse response) throws IOException {
        studentService.saveStudent(student);
        response.sendRedirect(request.getContextPath()+"/account/findAll");
        return;
    }

}
