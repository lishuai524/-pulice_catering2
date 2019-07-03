package com.huayu.CG_KC_SJ.other_expenses.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.CG_KC_SJ.other_expenses.entity.Other_expenses;
import com.huayu.CG_KC_SJ.other_expenses.sql.SelectSql_o;
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
public interface Other_expensesMapper extends BaseMapper<Other_expenses> {
    //查询
    @Results({
            @Result(column = "sid", property = "stores_information", one = @One(select = "com.huayu.CG_KC_SJ.stores_information.mapper.Stores_informationMapper.query", fetchType = FetchType.EAGER)),

            //联合门店表
    })
    @SelectProvider(type = SelectSql_o.class, method = "select")
    public List<Other_expenses> query(Other_expenses other_expenses);
}
