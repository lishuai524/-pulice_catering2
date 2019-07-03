package com.huayu.CG_KC_SJ.raw_material_information.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.CG_KC_SJ.raw_material_information.entity.Raw_material_information;
import com.huayu.CG_KC_SJ.raw_material_information.mapper.Raw_material_informationMapper;
import com.huayu.CG_KC_SJ.raw_material_information.service.IRaw_material_informationService;
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
public class Raw_material_informationServiceImpl extends ServiceImpl<Raw_material_informationMapper, Raw_material_information> implements IRaw_material_informationService {

    @Autowired
    private Raw_material_informationMapper raw_material_informationMapper;
//查询
    public List<Raw_material_information> query(Raw_material_information raw_material_information){
        return raw_material_informationMapper.query(raw_material_information);
    }

}
