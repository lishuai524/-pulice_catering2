package com.huayu.CP_CW.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.CP_CW.bean.Ewai;
import com.huayu.CP_CW.sql.EwaiSql;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EwaiMapper extends BaseMapper<Ewai> {

    @SelectProvider(type = EwaiSql.class,method = "select")
    public List<Ewai> queryAll(Ewai ewai);

    @Select("select * from ewai where id=#{value} ")
    public Ewai queryByID(int id);

    @Delete("delete from ewai where id=#{id}")
    public void delect(int id);

    @Update("update ewai set name=#{name},money=#{money},test=#{test},time=#{time} where id=#{id}")
    public void up(Ewai ewai);



}
