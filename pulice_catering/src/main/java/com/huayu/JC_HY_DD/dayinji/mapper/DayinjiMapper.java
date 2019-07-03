package com.huayu.JC_HY_DD.dayinji.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.JC_HY_DD.dayinji.entity.Dayinji;
import com.huayu.JC_HY_DD.dayinji.sql.dayinSql;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2019-06-12
 */
public interface DayinjiMapper extends BaseMapper<Dayinji> {
    @SelectProvider(type = dayinSql.class,method = "selset")
    public List<Dayinji> queryAll(Dayinji dayinji);

    @Select("select * from dayinji where id=#{value}")
    public Dayinji toupdate(int id);
}
