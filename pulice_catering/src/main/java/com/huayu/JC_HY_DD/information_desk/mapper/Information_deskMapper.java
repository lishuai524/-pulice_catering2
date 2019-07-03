package com.huayu.JC_HY_DD.information_desk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.JC_HY_DD.information_desk.entity.Information_desk;
import com.huayu.JC_HY_DD.information_desk.sql.infSql;
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
public interface Information_deskMapper extends BaseMapper<Information_desk> {
    @Results({
            @Result(column = "capacity",property = "cap",one = @One(select = "com.huayu.JC_HY_DD.information_desk.mapper.capacityMapper.queryById1",fetchType = FetchType.EAGER)),
            @Result(column = "type",property = "zhuotaitype",one = @One(select = "com.huayu.JC_HY_DD.information_desk.mapper.ZhuotaitypeMapper.queryById2",fetchType = FetchType.EAGER)),
            @Result(column = "sotid",property = "state",one = @One(select = "com.huayu.JC_HY_DD.information_desk.mapper.State_of_tablesMapper.queryById3",fetchType = FetchType.EAGER))
    })
    @SelectProvider(type = infSql.class,method = "selset")
    public List<Information_desk> queryAll(Information_desk desk);

    @Select("select * from information_desk where ldid=#{value}")
    public Information_desk toupdate(int id);

    @Select("update information_desk where ldid=#{value}")
    public Information_desk update(int id);
}
