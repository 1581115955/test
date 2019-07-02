package com.mapper;

import com.bean.District;
import com.bean.DistrictExample;
import java.util.List;

public interface DistrictMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(District record);

    int insertSelective(District record);

    List<District> selectByExample(DistrictExample example);

    District selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(District record);

    int updateByPrimaryKey(District record);

    //根据District表的id删除Street表中的一行数据
    int deleteByDistrictPrimaryId(Integer id);
    //根据数组里的id值删除District表中的一行数据
    int deleteByDistrictArrayId(Integer[] ids);
    //查询所有
    List<District> getAll();
}