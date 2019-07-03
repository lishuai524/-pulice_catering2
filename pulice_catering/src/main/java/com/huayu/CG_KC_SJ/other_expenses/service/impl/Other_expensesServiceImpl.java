package com.huayu.CG_KC_SJ.other_expenses.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.CG_KC_SJ.other_expenses.entity.Other_expenses;
import com.huayu.CG_KC_SJ.other_expenses.mapper.Other_expensesMapper;
import com.huayu.CG_KC_SJ.other_expenses.service.IOther_expensesService;
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
public class Other_expensesServiceImpl extends ServiceImpl<Other_expensesMapper, Other_expenses> implements IOther_expensesService {
     @Autowired
    private Other_expensesMapper other_expensesMapper;

public List<Other_expenses> query(Other_expenses other_expenses){
    return other_expensesMapper.query(other_expenses);

}
}
