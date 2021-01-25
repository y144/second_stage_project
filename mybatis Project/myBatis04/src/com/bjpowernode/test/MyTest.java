package com.bjpowernode.test;

import com.bjpowernode.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.beans.VetoableChangeListenerProxy;
import java.io.InputStream;
import java.util.List;

/**
 * 杨廷甲
 * 2020-11-28
 */
//将要完成所有测试功能的类
public class MyTest {

    //每个功能独立测试
    //测试方法的规范
    //1.访问权限是公共的
    //2.返回值是void
    //3.无参
    //4.方法名称可以为自定义类型，建议使用test开头
    //5.在每个测试方法的上面添加注解@Test

    SqlSession session;
    //在所有测试方法执行前自动执行此注里的代码
    @Before
    public void openSession()throws Exception{
        //创建文件输入流读取配置文件SqlMapConfig.xml文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //获得SqlSession连接的工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        //从工厂中取出一个连接对象
         session = factory.openSession();
    }

    @Test
    public void testStudentGetAll()throws Exception{
        //使用连接对象完成数据库的操作，定位当前的包名并添加进行当前所有sql语句的定位id
        List<Student> list = session.selectList("com.bjpowernode.dao.impl.selectAll");
        //将得到的集合进行遍历(以下使用的是拉姆达表达式，也可以使用正常的foreach遍历的方法)
        list.forEach(sut-> System.out.println(sut));
        /*for (Student stu : list) {
            System.out.println(stu);
        }*/
    }

    @Test
    public void testStudentById(){
        //使用连接对象完成数据库的操作，定位当前的包名并添加当前sql语句的定位id
        Student stu = session.selectOne("com.bjpowernode.dao.impl.getById", 1);
        System.out.println(stu);
    }

    @Test
    public void testStudentByName(){
        List<Student> listStu = session.selectList("com.bjpowernode.dao.impl.getByName","三");
        listStu.forEach(student -> System.out.println(student));
    }

    @Test
    public void testInsertStudent(){
        Student stu = new Student("国家的开发","11313@qq.com",21);
        int num = session.insert("com.bjpowernode.dao.impl.insertStudent", stu);
        session.commit();//手工提交事务
        System.out.println("增加成功====="+num);
    }

    @Test
    public void testDeleteStudent(){
        int num = session.delete("com.bjpowernode.dao.impl.deleteStudent", 4);
        session.commit();
        System.out.println("删除成功====="+num);
    }

    @Test
    public void testUpdateStudent(){
        int num = session.update("com.bjpowernode.dao.impl.updateStudent", 1);
        session.commit();
        System.out.println("更新成功========"+num);
    }


    //在所有的测试方法执行后自动执行的代码，用来关闭这个连接对象
    @After
    public void closeSession(){
        session.close();
    }
}
