package com.huayu.JC_HY_DD.queuing_management.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.JC_HY_DD.queuing_management.entity.Queuing_management;
import com.huayu.JC_HY_DD.queuing_management.sql.questaSql;
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
public interface Queuing_managementMapper extends BaseMapper<Queuing_management> {
    @Results({
            @Result(column = "capacity",property = "cap",one = @One(select = "com.huayu.JC_HY_DD.information_desk.mapper.capacityMapper.queryById1",fetchType = FetchType.EAGER)),
            @Result(column = "Desk_type",property = "zhuotaitype",one = @One(select = "com.huayu.JC_HY_DD.information_desk.mapper.ZhuotaitypeMapper.queryById2",fetchType = FetchType.EAGER)),
            @Result(column = "queue_type",property = "queue",one = @One(select = "com.huayu.JC_HY_DD.queue.mapper.QueueMapper.toupdate",fetchType = FetchType.EAGER)),
            @Result(column = "qsid",property = "queue_state",one = @One(select = "com.huayu.JC_HY_DD.queue_state.mapper.Queue_stateMapper.queryByid",fetchType = FetchType.EAGER)),

    })
    @SelectProvider(type = questaSql.class,method = "selset")
    public List<Queuing_management> queryAll(Queuing_management queuing);

    @Select("select * from queuing_management where id=#{value}")
    public Queuing_management toupdate(int id);
}
