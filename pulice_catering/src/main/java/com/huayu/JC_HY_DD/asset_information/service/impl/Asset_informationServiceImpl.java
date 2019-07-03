package com.huayu.JC_HY_DD.asset_information.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.JC_HY_DD.asset_information.entity.Asset_information;
import com.huayu.JC_HY_DD.asset_information.mapper.Asset_informationMapper;
import com.huayu.JC_HY_DD.asset_information.service.IAsset_informationService;
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
public class Asset_informationServiceImpl extends ServiceImpl<Asset_informationMapper, Asset_information> implements IAsset_informationService {
    public List<Asset_information> queryAll(Asset_information asset_information){
        return baseMapper.queryAll(asset_information);
    }

}
