package com.huayu.JC_HY_DD.queue_state.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.JC_HY_DD.queue_state.entity.Queue_state;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2019-06-12
 */
public interface Queue_stateMapper extends BaseMapper<Queue_state> {
    @Select("select * from queue_state where qsid=#{value}")
    public Queue_state queryByid(int id);

}
