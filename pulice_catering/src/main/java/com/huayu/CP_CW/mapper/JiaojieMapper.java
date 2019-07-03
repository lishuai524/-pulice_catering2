package com.huayu.CP_CW.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.CP_CW.bean.JiaoJie;
import com.huayu.CP_CW.sql.JiaojieSql;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface JiaojieMapper extends BaseMapper<JiaoJie> {

    @SelectProvider(type = JiaojieSql.class,method = "select")
    public List<JiaoJie> queryAll(JiaoJie jiaoJie);

    @Select("select * from jiaojie where id=#{value} ")
    public JiaoJie queryByID(int id);

    @Delete("delete from jiaojie where id=#{id}")
    public void delect(int id);

    @Update("update jiaojie set money=#{money},jiaojie=#{jiaojie},jieshou=#{jieshou},jiaojietime=#{jiaojietime},test=#{test} where id=#{id}")
    public void up(JiaoJie jiaoJie);

    @Insert(" insert into jiaojie (money,jiaojie,jieshou,jiaojietime,test) values(#{money},#{jiaojie},#{jieshou},#{jiaojietime},#{test});")
    public int insert(JiaoJie jiaoJie);

}
