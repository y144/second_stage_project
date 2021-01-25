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

import javax.xml.crypto.Data;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 杨廷甲
 * 2020-12-01
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
    public void testFindById(){
        Users byId = mapper.findById(1);
        System.out.println(byId);
    }

    @Test
    public void testFindLikeUsers(){
        List<Users> likeUsers = mapper.findLikeUsers("三");
        likeUsers.forEach(users -> System.out.println(users));
    }

    @Test
    public void testFindFiled(){
        List<Users> usersList = mapper.findFiled("address", "市");
        usersList.forEach(users -> System.out.println(users));
    }

    @Test
    public void testInsertUsers()throws Exception{
        //Data data = (Data) new Date("yyyy-MM-dd");
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        Users users = new Users("j该接口砥砺奋进赶快来", date.parse("1995-05-07"),"男", "感觉到付款了感觉");
        int insertUsers = mapper.insertUsers(users);
        session.commit();
        if (insertUsers>0){
            System.out.println("用户添加成功");
        }
    }

    @Test
    public void testUpdateUsers()throws Exception{
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        Users users = new Users();
        users.setId(2);
        users.setUserName("就赶快来电饭锅");
        Date parse = date.parse("2000-02-03");
        users.setBirthday(parse);
        int updateUsers = mapper.updateUsers(users);
        session.commit();//切记需要手动提交
        if (updateUsers>0){
            System.out.println("更新成功");
        }
    }

    @Test
    public void testupdateCondition(){
        Users users = new Users();
        users.setUserName("gj更健康劳动法");
        users.setId(3);
        int updateCondition = mapper.updateCondition(users);
        session.commit();
        if (updateCondition>0){
            System.out.println("更新成功");
        }
    }

    @Test
    public void testFindUsersCondition(){
        Users users = new Users();
        users.setUserName("三");
        users.setAddress("市");
        List<Users> findCondition = mapper.findUsersCondition(users);
        findCondition.forEach(users1->System.out.println(users1));
    }

    @Test
    public void testFindSomeId(){
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        List<Users> bySomeId = mapper.findBySomeId(list);
        bySomeId.forEach(users -> System.out.println(users));
    }

    @Test
    public void testIsertBatch()throws Exception{
        SimpleDateFormat sd =new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sd.parse("1562-06-31");
        List list = new ArrayList();
        for (int i = 0; i < 10; i++) {
        Users users = new Users("更健康劳动法经过了", parse, "男", "加工费开大京粮控股");
        list.add(users);
        }
        int batch = mapper.insertBatch(list);
        session.commit();
        if (batch>0){
            System.out.println("批量增加成功");
        }
    }

    @Test
    public void testDeleteBatch(){
        List list = new ArrayList();
        list.add(41);
        list.add(42);
        list.add(43);
        int deleteBatch = mapper.deleteBatch(list);
        session.commit();
        if (deleteBatch>0){
            System.out.println("删除成功");
        }
    }

    @Test
    public void testAppointPar(){
        List<Users> usersList = mapper.appointParameterLoc("小", "1");
        usersList.forEach(users -> System.out.println(users));
    }

    @Test
    public void testparameterIsMap(){
        Map map = new HashMap();
        map.put("id", "101");
        map.put("userName", "加工费德里克");
        map.put("address", "过节费打了卡估计快了的居家隔离开发电商");
        int users  = mapper.parameterIsMap(map);
        session.commit();
        if (users>0){
            System.out.println("添加成功");
        }
    }
    @Test
    public void testParameterIsMap(){
        Map map = new HashMap();
        map.put("id", "33");
        map.put("userName", "国际大反过来看");
        map.put("address", "国际法来对抗记录卡的");
        int isMap = mapper.parameterIsMap(map);
        session.commit();
        if (isMap>0){
            System.out.println("使用Map添加成功");
        }
    }

    @Test
    public void testResultMap(){
        Map<String,Object> map = mapper.resultMap(2);
        System.out.println(map.get("username"));
    }

    @Test
    public void testResultMapMany(){
        List<Map<String, Object>> maps = mapper.resultMapMany();
        System.out.println(maps);
    }

    @After
    public void close(){
        //将对象关闭
        session.close();
    }

}
