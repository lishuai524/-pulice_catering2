package com.huayu.JC_HY_DD.asset_information.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.JC_HY_DD.asset_information.entity.Property;
import com.huayu.JC_HY_DD.asset_information.sql.proSql;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface PropertyMapper extends BaseMapper<Property> {
    @Results({
            @Result(column = "belong_to_shop",property = "stores_information",one = @One(select = "com.huayu.JC_HY_DD.stores_information.mapper.Stores_informationMapper.toupdate",fetchType = FetchType.EAGER))
    })
    @SelectProvider(type = proSql.class,method = "selset2")
    public List<Property> queryAll(Property property);

    @Results({
            @Result(column = "belong_to_shop",property = "stores_information",one = @One(select = "com.huayu.JC_HY_DD.stores_information.mapper.Stores_informationMapper.toupdate",fetchType = FetchType.EAGER))
    })
    @SelectProvider(type = proSql.class,method = "selset3")
    public List<Property> queryAll2(Property property);


}
