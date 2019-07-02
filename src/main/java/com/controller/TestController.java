package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Controller

public class TestController {
    @RequestMapping("/test1")
    public void test1(HttpServletResponse response,HttpServletRequest request) throws Exception {
        //获取-打印服务器创建的sessionID
        HttpSession session = request.getSession();
        System.out.println(session.getId());

        //创建-添加cookie
        String value = URLEncoder.encode("张三","utf-8");
        Cookie cookie1 = new Cookie("name",value);
        response.addCookie(cookie1);//session的ID被丢进去了

        //返回测试页面
        response.sendRedirect("/admin/test.jsp");
        //return "/admin/test";

    }
    @RequestMapping("/test2")
    public void test2(HttpServletRequest request,HttpServletResponse response) throws Exception {
        //将cookie[]存进Map集合
        Cookie[] cookies = request.getCookies();
        Map<String,String> map = new HashMap<>();
        for (Cookie cookie : cookies) {
            String value = URLDecoder.decode(cookie.getValue(),"utf-8");
            map.put(cookie.getName(),value);
        }

        //打印存储的cookie和sessionID
        System.out.println(map.get("name"));
        System.out.println(map.get("JSESSIONID"));
        //返回测试页面
        response.sendRedirect("/admin/test.jsp");
    }
}
