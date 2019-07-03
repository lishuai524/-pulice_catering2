package com.huayu.JC_HY_DD.staffs.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.JC_HY_DD.staffs.entity.Staffs;
import com.huayu.JC_HY_DD.staffs.mapper.StaffsMappers;
import com.huayu.JC_HY_DD.staffs.service.IStaffsServices;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-06-12
 */
@Service
public class StaffsServiceImpls extends ServiceImpl<StaffsMappers, Staffs> implements IStaffsServices {

    public Staffs queryByid(int id){
        return baseMapper.queryByid(id);
    }
    public String querypwd(int id){
        return baseMapper.querypsd(id);
    }
    public void updatepwd(Staffs staffs){
        baseMapper.updatepwd(staffs);
    }
    public String queryBytp(int job){
        return baseMapper.queryBytp(job);
    }
}
