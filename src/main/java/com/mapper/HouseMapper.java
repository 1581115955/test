package com.mapper;

import com.bean.House;
import com.bean.HouseExample;
import com.bean.HouseOther;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface HouseMapper {
    int deleteByPrimaryKey(String id);

    int insert(House record);

    int insertSelective(House record);

    List<House> selectByExample(HouseExample example);

    House selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);
    //根据用户ID查询名下所有出租房信息以及配套其它信息
    List<HouseOther> selectHouseOtherByUserId(Integer uid);
}