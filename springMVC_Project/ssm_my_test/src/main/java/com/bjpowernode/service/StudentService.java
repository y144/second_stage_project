package com.bjpowernode.service;

import com.bjpowernode.pojo.Student;

import java.util.List;

/**
 * 杨廷甲
 * 2020-12-13
 */
public interface StudentService {

    //查询所有学生信息
    public List<com.bjpowernode.pojo.Student> findAll();

    //保存学生信息
    public int saveStudent(Student student);
}
