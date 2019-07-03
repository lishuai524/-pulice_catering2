package com.huayu.CP_CW.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.CP_CW.bean.Ewaipay;
import com.huayu.CP_CW.sql.EwaipaySql;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EwaipayMapper extends BaseMapper<Ewaipay> {

    @SelectProvider(type = EwaipaySql.class,method = "select")
    public List<Ewaipay> queryAll(Ewaipay ewaipay);

    @Select("select * from ewaipay where id=#{value} ")
    public Ewaipay queryByID(int id);

    @Delete("delete from ewaipay where id=#{id}")
    public void delect(int id);

    @Update("update ewaipay set name=#{name},money=#{money},test=#{test},time=#{time} where id=#{id}")
    public void up(Ewaipay ewaipay);



}
