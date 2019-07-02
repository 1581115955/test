package com.mapper;

import com.bean.Users;
import com.bean.UsersExample;
import java.util.List;
import java.util.Map;

public interface UsersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    int insertSelective(Users record);

    List<Users> selectByExample(UsersExample example);

    Users selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    int deleteByUsersArrayId(Integer[] ids);
    //验证用户名和密码是否匹配
    int yanZheng(Map map);
    //验证用户的身份
    int getIdentity(String userName);
    //根据用户名查找完整的用户信息
    Users selctByUserName(String userName);
}