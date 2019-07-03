package com.huayu.JC_HY_DD.order_management.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.JC_HY_DD.order_management.entity.Order_management;
import com.huayu.JC_HY_DD.order_management.sql.orderSql;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2019-06-12
 */
public interface Order_managementMapper extends BaseMapper<Order_management> {
    @SelectProvider(type = orderSql.class,method = "selset")
    public List<Order_management> queryAll(Order_management management);
}
