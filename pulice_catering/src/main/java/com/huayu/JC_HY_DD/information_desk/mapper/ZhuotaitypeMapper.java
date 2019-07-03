package com.huayu.JC_HY_DD.information_desk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.JC_HY_DD.information_desk.entity.Zhuotaitype;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ZhuotaitypeMapper extends BaseMapper<Zhuotaitype> {
    @Select("select * from zhuotaitype where zid=#{value}")
    public Zhuotaitype queryById2(int id);
}
