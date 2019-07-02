package com.service;

import com.bean.UserCondition;
import com.bean.Users;
import com.bean.UsersExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UsersMapper mapper;

    /**
     *分页查询【带条件】
     * @param condition
     * @return
     */
    @Override
    public PageInfo<Users> selectByExample(UserCondition condition) {
        //1、开启分页支持
        PageHelper.startPage(condition.getPage(),condition.getRows());
        //2、该new还是得new啊
        UsersExample example = new UsersExample();//example类对象
        UsersExample.Criteria criteria = example.createCriteria();//内部类对象
        //3、添加查询条件
        if(condition.getTelephone()!=null){//添加电话
            criteria.andTelephoneLike("%"+condition.getTelephone()+"%");
        }
        if(condition.getStartAge()!=null){//添加开始年龄
            criteria.andAgeGreaterThan(condition.getStartAge());
        }
        if (condition.getEndAge()!=null){//添加结束年龄
            criteria.andAgeLessThan(condition.getEndAge());
        }
        //4、执行查询并返回结果
        List<Users> list =  mapper.selectByExample(example);
        return new PageInfo<Users>(list);
    }

    /**
     *添加单条
     * @param record
     * @return
     */
    @Override
    public Integer insert(Users record) {
        return mapper.insert(record);
    }

    /**
     *修改单条
     * @param record
     * @return
     */
    @Override
    public Integer update(Users record) {
        return mapper.updateByPrimaryKey(record);
    }

    /**
     *删除单条
     * @param id
     * @return
     */
    @Override
    public Integer delete(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    /**
     *批量删除
     * @param id
     * @return
     */
    @Override
    public Integer deleteAll(String id) {
        //拆分字符串，提取id数组
        String[] idArr = id.split(",");
        Integer [] ids = new Integer[idArr.length];
        for (int i = 0; i < idArr.length; i++) {
            ids[i] = Integer.parseInt(idArr[i]);
        }
        //删除对应street表中的数据
        int count = mapper.deleteByUsersArrayId(ids);
        int len = count==0?0:1;
        return len;
    }

    /**
     * 验证用户名是否存在
     * @param userName
     * @return
     */
    @Override
    public boolean yanZheng(String userName,String password) {
        Map<String,String> map = new HashMap<>();
        map.put("userName",userName);
        map.put("password",password);
        int num = mapper.yanZheng(map);
        if (num>0){//匹配
            return true;
        }else{//不匹配
            return false;
        }
    }

    /**
     * 验证用户的身份
     * @param userName
     * @return
     */
    @Override
    public boolean getIdentity(String userName){
        int num = mapper.getIdentity(userName);
        if (num>0){
            return true;//管理员
        }else{
            return false;//普通用户
        }
    }

    /**
     * 根据用户名返回完整的用户信息
     * @param userName
     * @return
     */
    @Override
    public Users getUsersByUserName(String userName) {
        return mapper.selctByUserName(userName);
    }
}
