package com.huayu.JC_HY_DD.information_desk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.JC_HY_DD.information_desk.entity.Information_desk;
import com.huayu.JC_HY_DD.information_desk.mapper.Information_deskMapper;
import com.huayu.JC_HY_DD.information_desk.service.IInformation_deskService;
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
public class Information_deskServiceImpl extends ServiceImpl<Information_deskMapper, Information_desk> implements IInformation_deskService {
    public List<Information_desk> queryAll(Information_desk desk){
        return baseMapper.queryAll(desk);
    }
    public Information_desk toUpdate(int id){
        return baseMapper.toupdate(id);
    }

}
