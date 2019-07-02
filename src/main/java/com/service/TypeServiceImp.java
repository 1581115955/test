package com.service;

import com.bean.Type;
import com.bean.TypeExample;
import com.mapper.TypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypeServiceImp implements TypeService {
    @Autowired
    private TypeMapper mapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(Type record) {
        return 0;
    }

    @Override
    public int insertSelective(Type record) {
        return 0;
    }

    @Override
    public List<Type> selectByExample(TypeExample example) {
        return null;
    }

    @Override
    public Type selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Type record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Type record) {
        return 0;
    }

    /**
     * 获取街道表的所有信息
     * @return
     */
    @Override
    public List<Type> getAllType() {
        return mapper.getAll();
    }
}
