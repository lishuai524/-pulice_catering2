package com.huayu.JC_HY_DD.member_management.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.JC_HY_DD.member_management.entity.Member_management;
import com.huayu.JC_HY_DD.member_management.mapper.Member_managementMapper;
import com.huayu.JC_HY_DD.member_management.service.IMember_managementService;
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
public class Member_managementServiceImpl extends ServiceImpl<Member_managementMapper, Member_management> implements IMember_managementService {
    public List<Member_management> queryAll(Member_management management) {
        return baseMapper.queryAll(management);
    }
    public String queryBytp(int id) {
        return baseMapper.queryBytp(id);
    }
}