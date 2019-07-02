package com.service;

import com.bean.District;
import com.bean.UserCondition;
import com.bean.Users;
import com.github.pagehelper.PageInfo;

public interface UserService {
    //分页查询【带条件】
    PageInfo<Users> selectByExample(UserCondition condition);
    //添加单条
    Integer insert(Users record);
    //修改单条
    Integer update(Users record);
    //删除单条
    Integer delete(Integer id);
    //批量删除
    Integer deleteAll(String id);
    //验证用户名和密码是否匹配
    boolean yanZheng(String userName,String password);
    //验证用户的身份
    boolean getIdentity(String userName);
    //根据用户名查找一个用户的完整信息
    Users getUsersByUserName(String userName);
}

