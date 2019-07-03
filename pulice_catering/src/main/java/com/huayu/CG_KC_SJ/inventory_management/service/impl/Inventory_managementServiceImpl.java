package com.huayu.CG_KC_SJ.inventory_management.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.CG_KC_SJ.inventory_management.entity.Inventory_management;
import com.huayu.CG_KC_SJ.inventory_management.mapper.Inventory_managementMapper;
import com.huayu.CG_KC_SJ.inventory_management.service.IInventory_managementService;
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
public class Inventory_managementServiceImpl extends ServiceImpl<Inventory_managementMapper, Inventory_management> implements IInventory_managementService {
@Autowired
    private Inventory_managementMapper inventory_managementMapper;
public List<Inventory_management> query(Inventory_management inventory_management){
    return inventory_managementMapper.query(inventory_management);
}

}
