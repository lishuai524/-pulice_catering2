package com.huayu.CG_KC_SJ.unit.unit_mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.CG_KC_SJ.unit.entity.uni;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface mapper extends BaseMapper<uni> {
    @Select("select * from unit where uid=#{value}")
    public uni queryid(int uid);

    @Select("select * from unit")
    public List<uni> query();
}
