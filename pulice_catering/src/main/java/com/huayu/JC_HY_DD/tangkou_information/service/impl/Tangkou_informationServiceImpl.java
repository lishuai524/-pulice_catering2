package com.huayu.JC_HY_DD.tangkou_information.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.JC_HY_DD.tangkou_information.entity.Tangkou_information;
import com.huayu.JC_HY_DD.tangkou_information.mapper.Tangkou_informationMapper;
import com.huayu.JC_HY_DD.tangkou_information.service.ITangkou_informationService;
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
public class Tangkou_informationServiceImpl extends ServiceImpl<Tangkou_informationMapper, Tangkou_information> implements ITangkou_informationService {
    public List<Tangkou_information> queryAll(Tangkou_information information){
        return baseMapper.queryAll(information);
    }

    public Tangkou_information toupdate(int id){
        return baseMapper.toupdate(id);
    }

}
