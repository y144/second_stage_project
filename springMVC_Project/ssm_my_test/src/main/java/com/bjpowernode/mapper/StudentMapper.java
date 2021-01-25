package com.bjpowernode.mapper;

import com.bjpowernode.pojo.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 杨廷甲
 * 2020-12-13
 */

@Repository
public interface StudentMapper {

    //查询所有学生信息
    @Select("select * from student")
    public List<Student> findAll();

    //保存学生信息
    @Insert("insert into student(name,email,age) values(#{name},#{email},#{age})")
    public int saveStudent(Student student);
}
