package com.huayu.CG_KC_SJ.stock_management.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.CG_KC_SJ.stock_management.entity.Stock_management;
import com.huayu.CG_KC_SJ.stock_management.mapper.Stock_managementMapper;
import com.huayu.CG_KC_SJ.stock_management.service.IStock_managementService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class Stock_managementServiceImpl extends ServiceImpl<Stock_managementMapper, Stock_management> implements IStock_managementService {
@Autowired
    private  Stock_managementMapper stock_managementMapper;

public List<Stock_management> query(Stock_management stock_management){
    return stock_managementMapper.query(stock_management);
}



}
