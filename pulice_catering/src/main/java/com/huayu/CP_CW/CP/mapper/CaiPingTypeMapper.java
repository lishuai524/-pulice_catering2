package com.huayu.CP_CW.CP.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.CP_CW.CP.UtilSql.SelectSql;
import com.huayu.CP_CW.CP.entity.Caipingtype;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface CaiPingTypeMapper extends BaseMapper<Caipingtype> {
   @Select("select * from caipingtype where id = #{value}")
   public Caipingtype querycaipingtype(int id);

   @SelectProvider(type = SelectSql.class,method = "querytype")
   public List<Caipingtype> querytype1(Caipingtype caipingtype);
}
