package com.huayu.JC_HY_DD.information_desk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.JC_HY_DD.information_desk.entity.State_of_tables;
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
public interface State_of_tablesMapper extends BaseMapper<State_of_tables> {
    @Select("select * from state_of_tables where sotid=#{value}")
    public State_of_tables queryById3(int id);
}
