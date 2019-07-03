package com.huayu.CG_KC_SJ.cost_of_ingredients.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.CG_KC_SJ.cost_of_ingredients.entity.Cost_of_ingredients;
import com.huayu.CG_KC_SJ.cost_of_ingredients.mapper.Cost_of_ingredientsMapper;
import com.huayu.CG_KC_SJ.cost_of_ingredients.service.ICost_of_ingredientsService;
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
public class Cost_of_ingredientsServiceImpl extends ServiceImpl<Cost_of_ingredientsMapper, Cost_of_ingredients> implements ICost_of_ingredientsService {
 @Autowired
    private Cost_of_ingredientsMapper cost_of_ingredientsMapper;
public List<Cost_of_ingredients> query(Cost_of_ingredients cost_of_ingredients){
    return cost_of_ingredientsMapper.query(cost_of_ingredients);
}
}
