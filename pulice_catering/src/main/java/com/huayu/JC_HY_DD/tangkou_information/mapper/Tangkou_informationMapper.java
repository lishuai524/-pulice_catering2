package com.huayu.JC_HY_DD.tangkou_information.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
//import com.huayu.CP_CW.food_category.entity.Food_category;
import com.huayu.JC_HY_DD.tangkou_information.entity.Tangkou_information;
import com.huayu.JC_HY_DD.tangkou_information.sql.tangkouSql;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2019-06-12
 */
public interface Tangkou_informationMapper extends BaseMapper<Tangkou_information> {
    @Results({
            @Result(column = "category",property = "categorys",one = @One(select = "com.huayu.JC_HY_DD.tangkou_information.mapper.Tangkou_informationMapper.queryByid",fetchType = FetchType.EAGER))
    })
    @SelectProvider(type = tangkouSql.class,method = "selset")
    public List<Tangkou_information> queryAll(Tangkou_information information);


    @Select("select * from tangkou_information where id=#{value}")
    public Tangkou_information toupdate(int id);


//    @Select("select * from food_category where fcid=#{value}")
//    public Food_category queryByid(int id);

}
