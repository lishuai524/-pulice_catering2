package com.huayu.JC_HY_DD.information_desk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.JC_HY_DD.information_desk.entity.Capacity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2019-06-12
 */
@Mapper
public interface capacityMapper extends BaseMapper<Capacity> {
    @Select("select * from capacity where cid=#{value}")
    public Capacity queryById1(int id);

}
