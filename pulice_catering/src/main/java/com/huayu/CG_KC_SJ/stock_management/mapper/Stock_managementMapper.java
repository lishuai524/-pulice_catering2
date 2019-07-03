package com.huayu.CG_KC_SJ.stock_management.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.CG_KC_SJ.stock_management.entity.Stock_management;
import com.huayu.CG_KC_SJ.stock_management.sql.SelectSql_s;
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
public interface Stock_managementMapper extends BaseMapper<Stock_management> {
    //查询
    @Results({
            @Result(column = "kid", property = "kin", one = @One(select = "com.huayu.CG_KC_SJ.kind.mapper.kind_mapper.queryid", fetchType = FetchType.EAGER)),
            @Result(column = "uni_uid", property = "uni", one = @One(select = "com.huayu.CG_KC_SJ.unit.unit_mapper.mapper.queryid", fetchType = FetchType.EAGER))
    })
    @SelectProvider(type = SelectSql_s.class, method = "select")
    public List<Stock_management> query(Stock_management stock_management);

}
