package com.huayu.CG_KC_SJ.marketing_plan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.CG_KC_SJ.marketing_plan.entity.Marketing_plan;
import com.huayu.CG_KC_SJ.marketing_plan.entity.plan;
import com.huayu.CG_KC_SJ.marketing_plan.mapper.Marketing_planMapper;
import com.huayu.CG_KC_SJ.marketing_plan.service.IMarketing_planService;
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
public class Marketing_planServiceImpl extends ServiceImpl<Marketing_planMapper, Marketing_plan> implements IMarketing_planService {

    @Autowired
    private Marketing_planMapper marketing_planMapper;

    public List<Marketing_plan> query(Marketing_plan marketing_plan){
        return  marketing_planMapper.query(marketing_plan);
    }

    public plan queryall(Integer cuisine){
        return  marketing_planMapper.queryall(cuisine);
    }



}
