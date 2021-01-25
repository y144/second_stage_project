package com.bjpowernode.service.impl;

import com.bjpowernode.mapper.StudentMapper;
import com.bjpowernode.pojo.Student;
import com.bjpowernode.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 杨廷甲
 * 2020-12-13
 */

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired  //Service层通过这个dao(mapper)接口对象去调用dao层(数据访问层)来实现功能
    private StudentMapper studentMapper;

    @Override
    public List<Student> findAll() {
        System.out.println("业务层查询所有的学生信息....");
        return studentMapper.findAll();
    }

    @Override
    public int saveStudent(Student student) {
        System.out.println("业务层保存学生信息....");
        return studentMapper.saveStudent(student);
    }
}
