package com.huayu.CG_KC_SJ.cost_of_ingredients.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.CG_KC_SJ.cost_of_ingredients.entity.Cost_of_ingredients;
import com.huayu.CG_KC_SJ.cost_of_ingredients.sql.SelectSql_C;
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
public interface Cost_of_ingredientsMapper extends BaseMapper<Cost_of_ingredients> {
//查询
    @Results({
            @Result(column = "sid", property = "stores_information", one = @One(select = "com.huayu.CG_KC_SJ.stores_information.mapper.Stores_informationMapper.query", fetchType = FetchType.EAGER)),
            //联合门店表
    })
    @SelectProvider(type = SelectSql_C.class, method = "select")
    public List<Cost_of_ingredients> query(Cost_of_ingredients cost_of_ingredients);
}
