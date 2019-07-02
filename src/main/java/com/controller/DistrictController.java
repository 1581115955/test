package com.controller;

import com.bean.District;
import com.github.pagehelper.PageInfo;
import com.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DistrictController {
    @Autowired
    private DistrictService service;

    @RequestMapping("/getDistrictByPage")
    @ResponseBody
    public Map<String,Object> getDistrictByPage(Integer page,Integer rows){
        /**
         * 分页查询【无条件】
         */
        Map<String,Object> map = new HashMap<>();
        page = page==null?1:page;
        PageInfo<District> pageinfo = service.selectByExample(page,rows);
        map.put("total",pageinfo.getTotal());
        map.put("rows",pageinfo.getList());
        return map;
    }

    @RequestMapping("/addDistrict")
    @ResponseBody
    public String addDistrict(District district){
        /**
         * 添加单条
         */
        int len = service.insert(district);
        String result = "{\"result\":"+len+"}";
        return result;
    }

    @RequestMapping("/changeDistrict")
    @ResponseBody
    public String changeDistrict(District district){
        /**
         * 修改单条
         */
        int len = service.update(district);
        String result = "{\"result\":"+len+"}";
        return result;
    }

    @RequestMapping("/deleteDistrict")
    @ResponseBody
    public int deleteDistrict(String id){
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
    @RequestMapping("/deleteOneDistrict")
    @ResponseBody
    public int deleteOneDistrict(Integer id){
        return service.delete(id);
    }
}
