package com.service;

import com.bean.District;
import com.bean.DistrictExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.DistrictMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DistrictServiceImp implements DistrictService {
    @Autowired
    private DistrictMapper mapper;

    /**
     * 分页查询【无条件】
     * @param page
     * @param rows
     * @return
     */
    @Override
    public PageInfo<District> selectByExample(Integer page, Integer rows) {
        //1、开启分页支持
        PageHelper.startPage(page,rows);
        //
        DistrictExample example = new DistrictExample();
        List<District> list =  mapper.selectByExample(example);
        return new PageInfo<>(list);
    }

    /**
     * 添加单条
     * @param record
     * @return
     */
    @Override
    public Integer insert(District record) {
        return mapper.insert(record);
    }

    /**
     * 修改单条
     * @param record
     * @return
     */
    @Override
    public Integer update(District record) {
        return mapper.updateByPrimaryKey(record);
    }

    /**
     * 删除单条
     * @param id
     * @return
     */
    @Override
    public Integer delete(Integer id) {
        mapper.deleteByDistrictPrimaryId(id);
        return mapper.deleteByPrimaryKey(id);
    }

    /**
     * 批量删除
     * @param id
     * @return
     */
    @Override
    public Integer deleteAll(String id) {
        //拆分字符串，提取id数组
        String[] idArr = id.split(",");
        Integer [] ids = new Integer[idArr.length];
        for (int i = 0; i < idArr.length; i++) {
            ids[i] = Integer.parseInt(idArr[i]);
        }
        //删除对应street表中的数据
        int count = mapper.deleteByDistrictArrayId(ids);
        int len = count==0?0:1;
        return len;
    }

    @Override
    public List<District> getAllDistrict() {
        return mapper.getAll();
    }

}
