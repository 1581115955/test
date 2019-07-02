package com.service;

import com.bean.House;
import com.bean.HouseOther;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.HouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServieceImp implements HouseService {
    @Autowired
    private HouseMapper mapper;

    /**
     * 添加一个出租房信息
     * @param house
     * @return
     */
    @Override
    public int addHouse(House house) {
        mapper.insert(house);
        return 0;
    }

    /**
     * 根据用户ID返回出租房分页对象
     * @param page
     * @param rows
     * @param uid
     * @return
     */
    @Override
    public PageInfo<HouseOther> getHouseByUser(Integer page,Integer rows,Integer uid) {
        PageHelper.startPage(page,rows);
        //调用dao层查询出租房
        List<HouseOther> list=mapper.selectHouseOtherByUserId(2);
        for (HouseOther houseOther : list) {
            System.out.println(houseOther);
        }
        System.out.println("-----------");
        //创建pageInfo
        return new PageInfo<>(list);
    }
}
