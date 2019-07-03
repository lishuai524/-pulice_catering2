package com.huayu.CP_CW.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.CP_CW.bean.DanjuType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DanjutypeMapper extends BaseMapper<DanjuType> {

    @Select("select * from danjutype where id=#{value}")
    DanjuType queryByID(Integer id);

    @Select("select * from danjutype")
    public List<DanjuType> queryAll();
}
