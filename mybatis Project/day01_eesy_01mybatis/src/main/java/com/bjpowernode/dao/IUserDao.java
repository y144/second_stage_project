package com.bjpowernode.dao;

import com.bjpowernode.domain.Student;

import java.util.List;

/**
 * 杨廷甲
 * 2020-11-29
 */
public interface IUserDao {
    List<Student> findAll();
}
