package com.huayu.JC_HY_DD.asset_information.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.JC_HY_DD.asset_information.entity.Property;
import com.huayu.JC_HY_DD.asset_information.mapper.PropertyMapper;
import com.huayu.JC_HY_DD.asset_information.service.IPropertySerivce;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertySerivce extends ServiceImpl<PropertyMapper, Property> implements IPropertySerivce {

    public List<Property> queryAll(Property property){
        return baseMapper.queryAll(property);
    }
    public List<Property> queryAll2(Property property){
        return baseMapper.queryAll2(property);
    }
}
