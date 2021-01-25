package com.bjpowernode;

import com.bjpowernode.mapper.UsersMapper;
import com.bjpowernode.pojo.Users;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.xml.transform.Source;
import java.io.InputStream;
import java.sql.SQLOutput;

/**
 * 杨廷甲
 * 2020-12-04
 */
public class UsersTest {
    SqlSessionFactory factory;
    SqlSession session;
    UsersMapper mapper;
    @Before
    public void openSession()throws Exception{
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
         factory = new SqlSessionFactoryBuilder().build(inputStream);
         session = factory.openSession();
         mapper = session.getMapper(UsersMapper.class);
    }

    @Test//测试根据id查找与更新
    public void testGetById(){
        Users users = mapper.getById(3);
        System.out.println(users);

        //测试更新后缓存会不会清空
        users.setUserName("更健康的浪费");
        mapper.update(users);
        session.commit();
        System.out.println("ok");
    }

    @Test//测试一级缓存，一级缓存默认开启，使用sqlsession的对象存储区域，作用域是当前sqlsession,关闭Session，当前的这个一级缓存是基于session的，如果把session关闭，则缓存的的数据就不会存(会清空缓存)在则就在缓存中读取不到。
    public void testCache(){
        //从数据库中取出id=2的用户，此时如果此用户没在缓存区，则去数据库中访问，拿到数据后在缓存区存放一份，在返回数据
        Users users = mapper.getById(2);
        System.out.println("users=======" + users);
        session.close();

        session = factory.openSession();
        mapper =  session.getMapper(UsersMapper.class);
        Users users1 = mapper.getById(2);
        System.out.println("users1============="+users1);
    }

    @Test//测试一级缓存，session.commit()表示在数据控发生变化(更新)时，则缓存自动清空
    public void testCache2(){
        //从数据库中取出id=2的用户，此时如果此用户没在缓存区，则去数据库中访问，拿到数据后在缓存区存放一份，在返回数据
        Users users = mapper.getById(2);
        System.out.println("users=======" + users);

        //实现更新操作
        users.setUserName("轨迹动力开个房间");
        mapper.update(users);
        session.commit();

        Users users1 = mapper.getById(2);
        System.out.println(users1);

    }

    //二级缓存是需要手动去开启的,它的作用域是mapper,是跨sqlsession的
    @Test//测试二级缓存，多个session有一个共用的缓存区，是要有一个session拿到数据放在二级缓存区里，其他的session就可以直接在二级缓存区进行数据的读取，不用访问数据库
        //开了二级缓存后，二级缓存里没有数据的时候，还会去一级缓存中 去访问数据，如果有则也会从一级缓存中读取数据而不去访问数据库
    public void testTwoCache(){
        SqlSession session1 = factory.openSession();
        SqlSession session2 = factory.openSession();
        SqlSession session3 = factory.openSession();

        //使用session1读取id=2的用户
        Users users = session1.getMapper(UsersMapper.class).getById(2);
        System.out.println("users========="+users);
        session1.close();
        //使用session2读取id=2的用户，看看是否访问了数据库，还是在缓存中读取的数据
        Users users1 = session2.getMapper(UsersMapper.class).getById(2);
        System.out.println("users1==========="+users1);
        session2.close();
        //当数据库中的数据进行了修改，自动清理缓存区，一级二级都自动清理
    }

    @After
    public void closeSession(){
        session.close();
    }
}
