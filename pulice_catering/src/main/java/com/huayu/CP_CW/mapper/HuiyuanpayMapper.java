package com.huayu.CP_CW.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.CP_CW.bean.Huiyuanpay;
import com.huayu.CP_CW.bean.JiaoJie;
import com.huayu.CP_CW.sql.HuiyuanpaySql;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface HuiyuanpayMapper extends BaseMapper<Huiyuanpay> {

    @SelectProvider(type = HuiyuanpaySql.class,method = "select")
    public List<Huiyuanpay> queryAll(Huiyuanpay huiyuanpay);

    @Insert(" insert into huiyuanpay (huiyuan,user,money,time) values(#{huiyuan},#{user},#{money},#{time});")
    public int insert(JiaoJie jiaoJie);

    @Delete("delete from huiyuanpay where id=#{id}")
    public void dec(int id);
/*    @Select("select * from huiyuanpay where id=#{value} ")
    public Huiyuan queryByID(int id);*/


    /*@Update("update huiyuanpay set  money=#{money} where id=#{id}")
    public void up(Huiyuanpay huiyuanpay);*/




}
