package com.huayu.CG_KC_SJ.stocktaking_manage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.CG_KC_SJ.stocktaking_manage.entity.Stocktaking_manage;
import com.huayu.CG_KC_SJ.stocktaking_manage.mapper.Stocktaking_manageMapper;
import com.huayu.CG_KC_SJ.stocktaking_manage.service.IStocktaking_manageService;
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
public class Stocktaking_manageServiceImpl extends ServiceImpl<Stocktaking_manageMapper, Stocktaking_manage> implements IStocktaking_manageService {
@Autowired
    private Stocktaking_manageMapper stocktaking_manageMapper;

public List<Stocktaking_manage> query(Stocktaking_manage stocktaking_manage){
    return stocktaking_manageMapper.query(stocktaking_manage);
}
}
