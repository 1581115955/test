package com.controller;

import com.bean.UserCondition;
import com.bean.Users;
import com.github.pagehelper.PageInfo;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService service;

    /**
     * 分页查询【带条件】
     * @param condition
     * @return
     */
    @RequestMapping("/getUserByPage")
    @ResponseBody
    public Map<String,Object> getUserByPage(UserCondition condition){
        System.out.println(condition);
        PageInfo pageinfo = service.selectByExample(condition);
        Map<String,Object> map = new HashMap<>();
        map.put("total",pageinfo.getTotal());
        map.put("rows",pageinfo.getList());
        return map;
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public String addUsers(Users users){
        /**
         * 添加单条
         */
        int len = service.insert(users);
        String result = "{\"result\":"+len+"}";
        return result;
    }

    @RequestMapping("/changeUsers")
    @ResponseBody
    public String changeUsers(Users users){
        /**
         * 修改单条
         */
        int len = service.update(users);
        String result = "{\"result\":"+len+"}";
        return result;
    }

    @RequestMapping("/deleteUsers")
    @ResponseBody
    public int deleteUsers(String id){
        /**
         * 批量删除
         */
        return service.deleteAll(id);
    }

    /**
     * 单条删除
     * @param id
     * @return
     */
    @RequestMapping("/deleteOneUsers")
    @ResponseBody
    public int deleteOneUsers(Integer id){
        return service.delete(id);
    }


    /**
     * 注册信息
     * @param name
     * @param password
     * @param telephone
     * @param age
     * @return
     */
    @RequestMapping("/newUser")
    @ResponseBody
    public String zhuCe(String name,String password,String telephone,int age){
        Users user = new Users();
        user.setName(name);
        user.setPassword(password);
        user.setTelephone(telephone);
        user.setAge(age);
        System.out.println(user);
        service.insert(user);
        return "/login.jsp";
    }

    /**
     * 用户登录
     * @param userName
     * @param password
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public String login(String userName, String password, HttpServletRequest request){
        //验证用户名和密码是否匹配
        boolean flag = service.yanZheng(userName,password);
        if (flag){
            boolean identity = service.getIdentity(userName);
            String s1 = "{\"result\":\"guanli\"}";//管理页面
            String s2 = "{\"result\":\"yonghu\"}";//用户页面
            //将当前用户对象存进session里面
            HttpSession session = request.getSession();
            Users user = service.getUsersByUserName(userName);
            session.setAttribute("user",user);
            //根据用户身份跳转到不同页面
            if(identity){
                return s1;
            }else{
                return s2;
            }
        }else{
            return "{\"result\":\"false\"}";//验证失败
        }
    }
}
