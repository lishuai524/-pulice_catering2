package com.huayu.CG_KC_SJ.procurement_plan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.CG_KC_SJ.procurement_plan.entity.Procurement_plan;
import com.huayu.CG_KC_SJ.procurement_plan.mapper.Procurement_planMapper;
import com.huayu.CG_KC_SJ.procurement_plan.service.IProcurement_planService;
import com.huayu.CG_KC_SJ.raw_material_information.entity.Raw_material_information;
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
public class Procurement_planServiceImpl extends ServiceImpl<Procurement_planMapper, Procurement_plan> implements IProcurement_planService {
    @Autowired
    private Procurement_planMapper procurement_planMapper;

    public List<Procurement_plan> query(Procurement_plan procurement_plan){
        return  procurement_planMapper.query(procurement_plan);
    }
    public Raw_material_information querynamea(String rmiid){
        return procurement_planMapper.queryname(rmiid);
    }
}
