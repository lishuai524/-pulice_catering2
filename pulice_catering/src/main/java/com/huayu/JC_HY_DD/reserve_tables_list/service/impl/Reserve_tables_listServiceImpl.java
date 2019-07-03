package com.huayu.JC_HY_DD.reserve_tables_list.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.JC_HY_DD.reserve_tables_list.entity.Reserve_tables_list;
import com.huayu.JC_HY_DD.reserve_tables_list.mapper.Reserve_tables_listMapper;
import com.huayu.JC_HY_DD.reserve_tables_list.service.IReserve_tables_listService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Transactional
public class Reserve_tables_listServiceImpl extends ServiceImpl<Reserve_tables_listMapper, Reserve_tables_list> implements IReserve_tables_listService {
    public List<Reserve_tables_list> queryAll(Reserve_tables_list reserve_tables_list) {
        return baseMapper.queryAll(reserve_tables_list);
    }

    public Reserve_tables_list toUpdate(int id){
        return baseMapper.toupdate(id);
    }
}
