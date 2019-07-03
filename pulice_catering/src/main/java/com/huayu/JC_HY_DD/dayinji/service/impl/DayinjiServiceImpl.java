package com.huayu.JC_HY_DD.dayinji.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.JC_HY_DD.dayinji.entity.Dayinji;
import com.huayu.JC_HY_DD.dayinji.mapper.DayinjiMapper;
import com.huayu.JC_HY_DD.dayinji.service.IDayinjiService;
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
public class DayinjiServiceImpl extends ServiceImpl<DayinjiMapper, Dayinji> implements IDayinjiService {
        public List<Dayinji> queryAll(Dayinji dayinji){
            return baseMapper.queryAll(dayinji);
        }

        public Dayinji toupdate(int id){
            return baseMapper.toupdate(id);
        }
}
