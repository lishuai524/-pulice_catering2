package com.huayu.CG_KC_SJ.menu_statistics.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.CG_KC_SJ.menu_statistics.entity.Menu_statistics;
import com.huayu.CG_KC_SJ.menu_statistics.sql.SelectSql;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

//import com.huayu.CG_KC_SJ.menu_statistics.sql.SelectSql_m;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2019-06-12
 */
@Mapper
public interface Menu_statisticsMapper extends BaseMapper<Menu_statistics> {
    //查询
    @Results({
            @Result(column = "sid", property = "stores_information", one = @One(select = "com.huayu.CG_KC_SJ.stores_information.mapper.Stores_informationMapper.query", fetchType = FetchType.EAGER)),

            //联合门店表
    })
    @SelectProvider(type = SelectSql.class, method = "select")
    public List<Menu_statistics> query(Menu_statistics menu_statistics);
}
