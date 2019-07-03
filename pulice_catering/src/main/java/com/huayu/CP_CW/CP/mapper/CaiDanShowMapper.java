package com.huayu.CP_CW.CP.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.CP_CW.CP.UtilSql.SelectSql;
import com.huayu.CP_CW.CP.entity.CaiDanShow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface CaiDanShowMapper extends BaseMapper<CaiDanShow> {
   @Select("select * from caidanshow where id = #{value}")
   public CaiDanShow queryshow(int id);

   @SelectProvider(type = SelectSql.class,method ="querycaidanshow")
   public List<CaiDanShow> querycaidanshow(CaiDanShow caiDanShow);
}
