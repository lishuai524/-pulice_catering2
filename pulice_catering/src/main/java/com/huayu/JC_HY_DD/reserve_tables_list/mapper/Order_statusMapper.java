package com.huayu.JC_HY_DD.reserve_tables_list.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.JC_HY_DD.reserve_tables_list.entity.Order_status;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Order_statusMapper extends BaseMapper<Order_status> {
    @Select("select * from order_status where osid=#{value}")
    public List<Order_status> query_ord(int id);
}
