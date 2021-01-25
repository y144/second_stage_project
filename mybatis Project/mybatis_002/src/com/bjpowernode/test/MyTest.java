package com.bjpowernode.test;

import com.bjpowernode.mapper.UsersMapper;
import com.bjpowernode.pojo.Users;
import jdk.swing.interop.SwingInterOpUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.xml.transform.Source;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 杨廷甲
 * 2020-11-30
 */
public class MyTest {

    SqlSession session;
    UsersMapper mapper;

    @Before
    public void openSession()throws Exception{
        //创建文件输入流，读取配置文件SqlMapConfig.xml文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //获得一个连接SqlSession连接的工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        //从工厂里取出一个Session连接的对象
        session = factory.openSession();
        //通过获得的SqlSession连接对象，得到一个动态代理对象
         mapper = session.getMapper(UsersMapper.class);
    }

    @Test
    public void testUserFindAll(){

        //通过代理对象调用查找方法
        List<Users> usersList = mapper.findAll();
        //将得到的对象进行遍历输出
        usersList.forEach(users -> System.out.println(users));
    }

    @Test
    public void testUserFindById(){


        Users users = mapper.findById(2);

        System.out.println(users);
    }

    @Test
    public void testUsersFindByName(){
        //通过动态代理对象调用模糊姓名查找方法，因为该接口已经是注册在UserMapper.xml文件中，所以，通过该接口创建的动态代理对象所调用的方法所关联的则是UserMapper.xml文件中的相关查询标签。
        List<Users> usersList = mapper.findByName("三");
        usersList.forEach(users -> System.out.println(users));
    }

    @Test
    public void testUsersFindByColumn(){
        List<Users> byColumn = mapper.getByColumn("username", "小");
        byColumn.forEach(users -> System.out.println(users));

    }

    @Test
    public void testUserINsert()throws Exception{
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Users user = new Users("加快大管家",sf.parse("1999-01-01"),"男", "北京市大兴区凉水河二街青年公寓");
        //flag返回的是受影响的行数，并非是主键信息，如果想在增加成功后，将主键返回到user对象中，则要使用单独的处理
        int flag = mapper.insert(user);
        System.out.println(user);
        session.commit();
        if (flag>0){
            System.out.println("增加成功");
        }
    }
    @Test
    public void testUUID(){
        //生成一个36位的随机字符串 一般用来做主键(包含数字，字母，中划线。一般用的时候可以字节截取自己想要的字符串，可以在订单编号中使用)
        String s = UUID.randomUUID().toString();
        System.out.println(s);
    }

    @Test
    public void testCondition(){
        Users u = new Users();
        u.setUserName("三");
        u.setAddress("上海市");
        List<Users> list = mapper.getByCondition(u);
        list.forEach(users -> System.out.println(users));
    }

    @Test
    public void testUpdate(){
        Users users = new Users();
        users.setUserName("发号施令打卡机法规及");
        users.setId(1);
        int update = mapper.update(users);
        session.commit();
        if (update>0){
            System.out.println("更新成功");
        }
    }
    @Test//有条件更新的情况下，至少更新一列
    public void testUpdateCondition(){
        Users users = new Users();
        users.setUserName("发号施令打卡机法规及");
        users.setId(2);
        int update = mapper.updateCondition(users);
        session.commit();
        if (update>0){
            System.out.println("更新成功");
        }
    }

    @Test
    public void testFindByUids(){
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        List<Users> byUids = mapper.findByUids(list);
        byUids.forEach(users -> System.out.println(users));
    }

    @Test
    public void testInsertBatch(){
        List<Users> list  = new ArrayList();
        for (int i = 0; i < 10 ; i++) {
            Users users = new Users("jo就赶快到", new Date(), "男", "beijiod监管科发动机盖");
            list.add(users);
        }

        mapper.insertUsersBatch(list);
        session.commit();
    }

    @Test
    public void testDeleteBatch(){
        List list = new ArrayList();
        list.add(28);
        list.add(29);
        list.add(30);
        list.add(31);
        mapper.deleteUsersBaych(list);
        session.commit();

    }

    @After
    public void close(){
        //将对象关闭
        session.close();
    }
}
