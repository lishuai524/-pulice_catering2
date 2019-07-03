package com.huayu.JC_HY_DD.reserve_tables_list.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.JC_HY_DD.reserve_tables_list.entity.Order_status;
import com.huayu.JC_HY_DD.reserve_tables_list.mapper.Order_statusMapper;
import com.huayu.JC_HY_DD.reserve_tables_list.service.IOrder_statusService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Order_statusImpl extends ServiceImpl<Order_statusMapper,Order_status> implements IOrder_statusService {
}
