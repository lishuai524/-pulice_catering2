package com.huayu.CP_CW.CP.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.CP_CW.CP.entity.Danwei;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DanWeiMapper extends BaseMapper<Danwei> {
   @Select("select * from danwei where id = #{value}")
   public Danwei querydanwei(int id);
}
