package com.service;

import com.bean.Street;
import com.bean.StreetExample;
import com.mapper.StreetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetServiceImp implements StreetService {
    @Autowired
    private StreetMapper mapper;

    /**
     * 根据District的ID获取Street对象集合
     * @param id
     * @return
     */
    @Override
    public List<Street> getStreetByDistrictId(int id) {
        return mapper.getStreetByDistrictId(id);
    }
}
