package com.huayu.JC_HY_DD.take_out.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.JC_HY_DD.take_out.entity.Take_out;
import com.huayu.JC_HY_DD.take_out.mapper.Take_outMapper;
import com.huayu.JC_HY_DD.take_out.service.ITake_outService;
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
public class Take_outServiceImpl extends ServiceImpl<Take_outMapper, Take_out> implements ITake_outService {
    public List<Take_out> queryAll(Take_out takeOut){
       return baseMapper.queryAll(takeOut);
    }

}
