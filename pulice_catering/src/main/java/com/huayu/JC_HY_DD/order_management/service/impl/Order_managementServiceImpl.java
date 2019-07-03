package com.huayu.JC_HY_DD.order_management.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.JC_HY_DD.order_management.entity.Order_management;
import com.huayu.JC_HY_DD.order_management.mapper.Order_managementMapper;
import com.huayu.JC_HY_DD.order_management.service.IOrder_managementService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-06-12
 */
@Service
public class Order_managementServiceImpl extends ServiceImpl<Order_managementMapper, Order_management> implements IOrder_managementService {
    public List<Order_management> queryAll(Order_management management){
        return baseMapper.queryAll(management);
    }
}
