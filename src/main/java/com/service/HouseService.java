package com.service;

import com.bean.House;
import com.bean.HouseOther;
import com.github.pagehelper.PageInfo;

public interface HouseService {
    //添加一个出租房信息
    int addHouse(House house);
    //根据用户ID返回出租房分页对象
    PageInfo<HouseOther> getHouseByUser(Integer page,Integer rows,Integer uid);
}
