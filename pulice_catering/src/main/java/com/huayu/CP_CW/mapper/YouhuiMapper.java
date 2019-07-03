package com.huayu.CP_CW.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.CP_CW.bean.Youhui;
import com.huayu.CP_CW.sql.YouhuiSql;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface YouhuiMapper extends BaseMapper<Youhui> {

    @SelectProvider(type = YouhuiSql.class,method = "select")
    public List<Youhui> queryAll(Youhui youhui);

    @Delete("delete from youhui where id=#{value}")
    public void delect(int id);

    @Select("select * from youhui where id=#{value} ")
    public Youhui queryByID(int id);

    @Insert(" insert into youhui (name,money,start,end,test) values(#{name},#{money},#{start},#{end},#{test});")
    public int insert(Youhui youhui);

    @Update("update youhui set name=#{name},money=#{money},start=#{start},end=#{end},test=#{test} where id=#{id}")
    public void up(Youhui youhui);

//    @SelectProvider(type = DanjuSql.class,method = "select")
//    public List<Danju> cx(Danju student);
}
