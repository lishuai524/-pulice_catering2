package com.huayu.JC_HY_DD.reserve_tables_list.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.JC_HY_DD.reserve_tables_list.entity.Reserve_tables_list;
import com.huayu.JC_HY_DD.reserve_tables_list.sql.resSql;
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
@Mapper
public interface Reserve_tables_listMapper extends BaseMapper<Reserve_tables_list> {
    @Results({
            @Result(column = "qsid",property = "order_status",one = @One(select = "com.huayu.JC_HY_DD.reserve_tables_list.mapper.Order_statusMapper.query_ord",fetchType = FetchType.EAGER))
    })
    @SelectProvider(type = resSql.class,method = "selset")
    public List<Reserve_tables_list> queryAll(Reserve_tables_list reserve_tables_list);

    @Select("select * from reserve_tables_list where id=#{value}")
    public Reserve_tables_list toupdate(int id);
}
