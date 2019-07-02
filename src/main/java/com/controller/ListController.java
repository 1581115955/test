package com.controller;

import com.bean.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ListController {

    /**
     * 判断用户是否登录了
     * @param request
     * @return
     */
    @RequestMapping(value = "/getUserMessage",produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String getUserMessage(HttpServletRequest request){
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        if (user==null){
            return "{\"userName\":\"null\"}";
        }
        return "{\"userName\":\""+user.getName()+"\"}";
        //return user;
    }
}
