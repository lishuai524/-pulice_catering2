package com.huayu.CP_CW.CP.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.CP_CW.CP.entity.Caipingtype;
import com.huayu.CP_CW.CP.mapper.CaiPingTypeMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CaipingtypeSer extends ServiceImpl<CaiPingTypeMapper, Caipingtype> {
   public List<Caipingtype> querytype1(Caipingtype caipingtype){
      return baseMapper.querytype1(caipingtype);
   }
}
