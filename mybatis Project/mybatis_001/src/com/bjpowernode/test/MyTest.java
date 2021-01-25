package com.bjpowernode.test;

import com.bjpowernode.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

//将要完成所有测试功能的类
public class MyTest {
    SqlSession session;

    //每个功能独立测试
    //测试方法的规范：
    //1.访问权限公共的
    //2.返回值是void
    //3.无参
    //4.方法名称可以自定义，建议使用test开头
    //5.在每个测试方法的上面添加注解@Test
    @Before//在所有测试方式执行前自动执行此注解里的代码
    public void openSession()throws Exception{
        //创建文件流读取SqlMapConfig.xml文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //获得SqlSession连接的工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        //从工厂中取出一个连接对象
       session = factory.openSession();
    }

    @Test
    public void testStudentGetAll()throws  Exception{
        //使用连接对象完成数据库的操作
        List<Student> list = session.selectList("com.bjpowernode.dao.impl.selectAll");
        list.forEach(stu-> System.out.println(stu));
//        for(Student stu:list){
//            System.out.println(stu);
//        }
    }

    @Test
    public void testGetStudentById(){
        Student stu = session.selectOne("com.bjpowernode.dao.impl.getById",1);
        System.out.println(stu);
    }

    @Test
    public void testGetStudentByName(){
        List<Student> list = session.selectList("com.bjpowernode.dao.impl.getByName","三");
       list.forEach(stu-> System.out.println(stu));
    }

    @Test
    public  void testInsertStudent(){
        Student stu = new Student("钱七","8028@qq.com",22);
        int num = session.insert("com.bjpowernode.dao.impl.insertStudent",stu);
        session.commit();//切记切记切记：手工提交事务
        System.out.println("增加成功！=========="+num);
    }

    @After//在所有的测试方法执行后自动执行的代码
    public void closeSession(){
        session.close();
    }

}
