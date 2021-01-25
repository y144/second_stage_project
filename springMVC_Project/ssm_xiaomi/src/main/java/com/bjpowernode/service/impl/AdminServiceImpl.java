package com.bjpowernode.service.impl;

import com.bjpowernode.mapper.AdminMapper;
import com.bjpowernode.pojo.Admin;
import com.bjpowernode.pojo.AdminExample;
import com.bjpowernode.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 杨廷甲
 * 2020-12-14
 */
@Service
public class AdminServiceImpl implements AdminService {

    //一定会有AdminMapper的对象
    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin login(String name, String pwd) {

        Admin admin=null;
        // 根据用户名admin的对象回来，然后进行密码比对决定是否登录成功
        //使用逆向工程生成的mapper,必须先生成AdminExample对象，此对象是封装了查询条件的专用类
        AdminExample example = new AdminExample();
        //给此对象添加条件相当于   在sql语句中执行 where aname = 'admin'
        example.createCriteria().andANameEqualTo(name);
        //按添加好的条件查询  adminMapper调用的方法就是xml配置生成的sql语句，在加上前面生成的查询条件
        List<Admin> list = adminMapper.selectByExample(example);//这里添加的就是上面生成的条件
        if (list != null && list.size() > 0){
            //取出查询到的对象中存储的密码 与 在页面输入提交的密码 进行密码比对
             admin = list.get(0);
            if (pwd.equals(admin.getaPass())){
                return admin;
            }
        }else {
            return null;
        }
        return admin;
    }
}
