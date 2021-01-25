package com.bjpowernode;

import com.bjpowernode.mapper.CustomerMapper;
import com.bjpowernode.mapper.UsersMapper;
import com.bjpowernode.pojo.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

/**
 * 杨廷甲
 * 2020-12-03
 */
public class CustomerTest {
    SqlSession session;
    CustomerMapper mapper;

    @Before//多对一的操作
    public void openSession()throws Exception{
        //创建文件输入流，读取配置文件SqlMapConfig.xml文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //获得一个连接SqlSession连接的工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        //从工厂里取出一个Session连接的对象
        session = factory.openSession();
        //通过获得的SqlSession连接对象，得到一个动态代理对象
        mapper = session.getMapper(CustomerMapper.class);
    }

    @Test
    public void testGetById(){
        Customer customer = mapper.getById(1);
        System.out.println(customer);
    }



    @After
    public void close(){
        //将对象关闭
        session.close();
    }
}
