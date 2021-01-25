package com.bjpowernode.test;

import com.bjpowernode.pojo.Pair;
import com.bjpowernode.pojo.Student;
import com.bjpowernode.service.impl.CalculatorMM;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 杨廷甲
 * 2020-12-05
 */
public class MyTest {
    @Test
    public void test01() throws ParseException {
        Date[] date = {
            new SimpleDateFormat("yyyy-DD-dd").parse("1995-12-02"),
            new SimpleDateFormat("yyyy-DD-dd").parse("1999-12-02"),
            new SimpleDateFormat("yyyy-DD-dd").parse("1998-12-02"),
        };

        Pair<Date> pair = CalculatorMM.calculator(date);

        System.out.println("最大的日期："+ new SimpleDateFormat("yyyy-MM-dd").format(pair.getMax()));
        System.out.println("最大的日期："+ new SimpleDateFormat("yyyy-MM-dd").format(pair.getMin()));


        Student[] students = {
          new Student("张三", 12),
          new Student("wangwu", 22),
          new Student("zhaoou", 52),
          new Student("程琪", 2),
        };

        Pair<Student> stu = CalculatorMM.calculator(students);
        System.out.println("最大的学生是："+stu.getMax());
        System.out.println("最小的学生是："+stu.getMin());
    }
}
