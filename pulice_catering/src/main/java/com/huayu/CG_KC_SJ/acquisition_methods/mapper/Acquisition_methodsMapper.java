package com.huayu.CG_KC_SJ.acquisition_methods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.CG_KC_SJ.acquisition_methods.entity.Acquisition_methods;
import com.huayu.CG_KC_SJ.acquisition_methods.sql.SelectSqla;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
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
public interface Acquisition_methodsMapper extends BaseMapper<Acquisition_methods> {


    @Results({
            @Result(column = "sid", property = "stores_information", one = @One(select = "com.huayu.CG_KC_SJ.stores_information.mapper.Stores_informationMapper.query", fetchType = FetchType.EAGER))
    })


    @SelectProvider(type = SelectSqla.class, method = "select")
    public List<Acquisition_methods> query(Acquisition_methods acquisition_methods);

}
