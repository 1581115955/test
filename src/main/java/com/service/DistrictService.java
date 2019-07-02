package com.service;

import com.bean.District;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface DistrictService {
    //分页查询【无条件】
    PageInfo<District> selectByExample(Integer page,Integer rows);
    //添加单条
    Integer insert(District record);
    //修改单条
    Integer update(District record);
    //删除单条
    Integer delete(Integer id);
    //批量删除
    Integer deleteAll(String id);
    //查询所有
    List<District> getAllDistrict();
}

