package com.huayu.CG_KC_SJ.temporary_inventory.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.CG_KC_SJ.temporary_inventory.entity.Temporary_inventory;
import com.huayu.CG_KC_SJ.temporary_inventory.mapper.Temporary_inventoryMapper;
import com.huayu.CG_KC_SJ.temporary_inventory.service.ITemporary_inventoryService;
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
public class Temporary_inventoryServiceImpl extends ServiceImpl<Temporary_inventoryMapper, Temporary_inventory> implements ITemporary_inventoryService {
@Autowired
    private Temporary_inventoryMapper temporary_inventoryMapper;


public List<Temporary_inventory> query(Temporary_inventory temporary_inventory){
    return temporary_inventoryMapper.query(temporary_inventory);
}
}
