package com.bjpowernode;

import com.bjpowernode.mapper.BookMapper;
import com.bjpowernode.mapper.CustomerMapper;
import com.bjpowernode.pojo.Book;
import com.mysql.cj.protocol.a.authentication.MysqlNativePasswordPlugin;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.xml.transform.Source;
import java.io.InputStream;
import java.util.List;

/**
 * 杨廷甲
 * 2020-12-03
 */
public class BookTest {
    SqlSession session;
    BookMapper mapper;

    @Before
    public void openSession()throws Exception{
        //创建文件输入流，读取配置文件SqlMapConfig.xml文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //获得一个连接SqlSession连接的工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        //从工厂里取出一个Session连接的对象
        session = factory.openSession();
        //通过获得的SqlSession连接对象，得到一个动态代理对象
        mapper = session.getMapper(BookMapper.class);
    }

    @Test
    public void testFindAllBook(){
        List<Book> bookList = mapper.findAll();
        bookList.forEach(book -> System.out.println(book));
    }

    @Test
    public void testFindAllResultMap(){
        List<Book> allResultMap = mapper.findAllResultMap();
        allResultMap.forEach(book -> System.out.println(book));
    }

    @After
    public void close(){
        //将对象关闭
        session.close();
    }

}
