package com.huayu.CG_KC_SJ.stocktaking_manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.CG_KC_SJ.stocktaking_manage.entity.Stocktaking_manage;
import com.huayu.CG_KC_SJ.stocktaking_manage.sql.SelectSql_ss;
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
public interface Stocktaking_manageMapper extends BaseMapper<Stocktaking_manage> {
    //查询
    @Results({
            @Result(column = "sid", property = "stores_information", one = @One(select = "com.huayu.CG_KC_SJ.stores_information.mapper.Stores_informationMapper.query", fetchType = FetchType.EAGER)),
            @Result(column = "kid", property = "kin", one = @One(select = "com.huayu.CG_KC_SJ.kind.mapper.kind_mapper.queryid", fetchType = FetchType.EAGER)),
            @Result(column = "uid", property = "uni", one = @One(select = "com.huayu.CG_KC_SJ.unit.unit_mapper.mapper.queryid", fetchType = FetchType.EAGER))
    })
    @SelectProvider(type = SelectSql_ss.class, method = "select")
    public List<Stocktaking_manage> query(Stocktaking_manage stocktaking_manage);
}
