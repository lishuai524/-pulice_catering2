package com.huayu.CG_KC_SJ.purchase_audit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.CG_KC_SJ.purchase_audit.entity.Purchase_audit;
import com.huayu.CG_KC_SJ.purchase_audit.mapper.Purchase_auditMapper;
import com.huayu.CG_KC_SJ.purchase_audit.service.IPurchase_auditService;
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
public class Purchase_auditServiceImpl extends ServiceImpl<Purchase_auditMapper, Purchase_audit> implements IPurchase_auditService {

    @Autowired
    private Purchase_auditMapper purchase_auditMapper;
    public List<Purchase_audit> query(Purchase_audit purchase_audit){
        return purchase_auditMapper.query(purchase_audit);

    }
}