package com.huayu.CP_CW.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.CP_CW.bean.FangAn;
import com.huayu.CP_CW.sql.FangAnSql;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FangAnMapper extends BaseMapper<FangAn> {

    @SelectProvider(type = FangAnSql.class,method = "select")
    public List<FangAn> queryAll(FangAn fangAn);

    @Select("select * from fangan where id=#{value} ")
    public FangAn queryByID(int id);

    @Delete("delete from fangan where id=#{id}")
    public void delect(int id);

    @Update("update fangan set name=#{name},test=#{test},time=#{time} where id=#{id}")
    public void up(FangAn fangAn);

    @Insert("insert into fangan (name,test,time) values(#{name},#{test},#{time}")
    public int insert(FangAn fangAn);

}
