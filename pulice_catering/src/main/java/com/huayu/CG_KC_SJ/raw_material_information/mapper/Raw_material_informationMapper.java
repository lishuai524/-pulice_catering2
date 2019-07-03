package com.huayu.CG_KC_SJ.raw_material_information.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.CG_KC_SJ.raw_material_information.entity.Raw_material_information;
import com.huayu.CG_KC_SJ.raw_material_information.sql.SelectSql;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2019-06-12
 */
@Mapper
public interface Raw_material_informationMapper extends BaseMapper<Raw_material_information> {
  //查询
  @Results({
          @Result(column = "kid", property = "kin", one = @One(select = "com.huayu.CG_KC_SJ.kind.mapper.kind_mapper.queryid", fetchType = FetchType.EAGER)),
          @Result(column = "uid", property = "uni", one = @One(select = "com.huayu.CG_KC_SJ.unit.unit_mapper.mapper.queryid", fetchType = FetchType.EAGER))
  })
  @SelectProvider(type = SelectSql.class, method = "select")
  public List<Raw_material_information> query(Raw_material_information raw_material_information);
}
