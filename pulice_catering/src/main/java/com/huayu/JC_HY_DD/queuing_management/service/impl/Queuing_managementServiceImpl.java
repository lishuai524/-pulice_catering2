package com.huayu.JC_HY_DD.queuing_management.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.JC_HY_DD.queuing_management.entity.Queuing_management;
import com.huayu.JC_HY_DD.queuing_management.mapper.Queuing_managementMapper;
import com.huayu.JC_HY_DD.queuing_management.service.IQueuing_managementService;
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
public class Queuing_managementServiceImpl extends ServiceImpl<Queuing_managementMapper, Queuing_management> implements IQueuing_managementService {
    public List<Queuing_management> queryAll(Queuing_management queuing){
        return baseMapper.queryAll(queuing);
    }
    public Queuing_management toupdate(int id){
        return baseMapper.toupdate(id);
    }

}
