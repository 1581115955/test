package com.controller;

import com.bean.House;
import com.bean.HouseOther;
import com.github.pagehelper.PageInfo;
import com.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@Controller
public class HouseController {
    @Autowired
    private HouseService service;

    @RequestMapping("/addHouse")
    public String addHouse(House house, @RequestParam(value="file",required = false)CommonsMultipartFile file) throws IOException {
        System.out.println(house);
        //将文件保存到服务器D:\\Images
        String fileName = file.getOriginalFilename();//获取文件的完整名称
        String lastName = fileName.substring(fileName.lastIndexOf("."));//获取文件的后缀名
        String savaName = System.currentTimeMillis()+lastName;//通过毫秒值和文件后缀名命名文件
        File savaFile = new File("D:\\U4Test\\image\\"+savaName);//指定保存的文件夹
        file.transferTo(savaFile);//保存文件
        house.setId("2");//出租房ID
        house.setPath(savaName);//保存图片名
        service.addHouse(house);//调用dao存储House
        return "admin/fabu";
    }
    @RequestMapping("/getHouseByUser")
    public String getHouseByUser(Integer page, Integer rows, Integer id, Model model){
        page = 1;
        rows = 3;
        id = 2;
        PageInfo<HouseOther> pageInfo = service.getHouseByUser(page,rows,id);
        model.addAttribute("pageinfo",pageInfo.getList());
        //System.out.println(pageInfo.getList());
        System.out.println(pageInfo);
        return "admin/guanli";
    }

}
