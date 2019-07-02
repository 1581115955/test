package com.controller;

import com.bean.District;
import com.bean.Street;
import com.bean.Type;
import com.bean.Users;
import com.service.DistrictService;
import com.service.StreetService;
import com.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;//返回json对象

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FaBuController {
    @Autowired
    private TypeService typeService;
    @Autowired
    private DistrictService districtService;
    @Autowired
    private StreetService StreetService;

    @RequestMapping("/fabu")
    public String fabu(Model model, HttpServletRequest request){
        //调用业务获取所有的类型、街道、对应的用户信息
        List<Type> type = typeService.getAllType();
        List<District> district = districtService.getAllDistrict();
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        //将获取到的类型和街道信息存到model
        model.addAttribute("type",type);
        model.addAttribute("district",district);

        //页面跳转
        return "admin/fabu";
    }
    @RequestMapping("/getStreet")
    @ResponseBody
    public List<Street> getStreet(int id){
        List<Street> list = new ArrayList<>();
        //调用业务
        return StreetService.getStreetByDistrictId(id);
    }
}
