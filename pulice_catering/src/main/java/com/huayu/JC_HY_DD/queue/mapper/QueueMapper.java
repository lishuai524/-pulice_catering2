package com.huayu.JC_HY_DD.queue.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.JC_HY_DD.queue.entity.Queue;
import com.huayu.JC_HY_DD.queue.sql.queSql;
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
public interface QueueMapper extends BaseMapper<Queue> {
    @Results({
            @Result(column = "capacity",property = "cap",one = @One(select = "com.huayu.JC_HY_DD.information_desk.mapper.capacityMapper.queryById1",fetchType = FetchType.EAGER))
    })
    @SelectProvider(type = queSql.class,method = "selset")
    public List<Queue> queryAll(Queue queue);

    @Select("select * from queue where qid=#{value}")
    public Queue toupdate(int id);

    @Select("select * from queue ")
    public List<Queue> query();


    @Select("update queue set type=#{type},capacity=#{capacity},remark=#{remark} where qid=#{qid}")
    public boolean update(Queue queue);
}
