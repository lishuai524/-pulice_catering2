package com.huayu.CP_CW.CP.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.CP_CW.CP.UtilSql.SelectSql;
import com.huayu.CP_CW.CP.entity.Caiping;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

;

@Mapper
public interface CaiPingMapper extends BaseMapper<Caiping> {
   @Results({@Result(column = "id",property = "id"),
         @Result(column = "danwei",property = "danwei1",one = @One(select = "com.huayu.CP_CW.CP.mapper.DanWeiMapper.querydanwei",fetchType = FetchType.EAGER)),
         @Result(column = "type",property = "caipingtype",one = @One(select = "com.huayu.CP_CW.CP.mapper.CaiPingTypeMapper.querycaipingtype",fetchType = FetchType.EAGER))

   })
   @SelectProvider(type = SelectSql.class,method ="querycaiping")
   public List<Caiping> querycaiping(Caiping caiping);
}
