package com.huayu.CP_CW.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.CP_CW.bean.Huiyuan;
import com.huayu.CP_CW.sql.HuiyuanSql;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface HuiyuanMapper extends BaseMapper<Huiyuan> {

    @SelectProvider(type = HuiyuanSql.class,method = "select")
    public List<Huiyuan> queryAll(Huiyuan huiyuan);

    @Select("select * from huiyuan where id=#{value} ")
    public Huiyuan queryByID(int id);


    @Update("update huiyuan set money=#{money} where id=#{id}")
    public void up(Huiyuan huiyuan);




}
