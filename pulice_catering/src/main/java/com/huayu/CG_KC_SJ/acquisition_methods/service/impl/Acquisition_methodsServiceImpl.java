package com.huayu.CG_KC_SJ.acquisition_methods.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.CG_KC_SJ.acquisition_methods.entity.Acquisition_methods;
import com.huayu.CG_KC_SJ.acquisition_methods.mapper.Acquisition_methodsMapper;
import com.huayu.CG_KC_SJ.acquisition_methods.service.IAcquisition_methodsService;
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
public class Acquisition_methodsServiceImpl extends ServiceImpl<Acquisition_methodsMapper, Acquisition_methods> implements IAcquisition_methodsService {
     @Autowired
    private Acquisition_methodsMapper acquisition_methodsMapper;
    //查询
    public List<Acquisition_methods> query(Acquisition_methods acquisition_methods){
        return acquisition_methodsMapper.query(acquisition_methods);
    }
}
