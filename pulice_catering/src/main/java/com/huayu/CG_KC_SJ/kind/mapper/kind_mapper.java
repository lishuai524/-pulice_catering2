package com.huayu.CG_KC_SJ.kind.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.CG_KC_SJ.kind.entity.kin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface kind_mapper extends BaseMapper<kin> {
    @Select("select * from kind where kid=#{value}")
    public kin queryid(int kid);

    @Select("select * from kind")
    public List<kin>   query();



}
