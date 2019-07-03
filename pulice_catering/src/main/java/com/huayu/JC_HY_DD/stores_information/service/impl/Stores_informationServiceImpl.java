package com.huayu.JC_HY_DD.stores_information.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.JC_HY_DD.stores_information.entity.Stores_information;
import com.huayu.JC_HY_DD.stores_information.mapper.Stores_informationMapper;
import com.huayu.JC_HY_DD.stores_information.service.IStores_informationService;
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
public class Stores_informationServiceImpl extends ServiceImpl<Stores_informationMapper, Stores_information> implements IStores_informationService {
    public List<Stores_information> queryAll(Stores_information information){
     return baseMapper.queryAll(information);
    }

    public Stores_information toupdate(int id){
        return baseMapper.toupdate(id);
    }
    public int update(Stores_information storesInformation){
        return baseMapper.update(storesInformation);
    }
    public String queryBytp(int id){
        return baseMapper.queryBytp(id);
    }

}
