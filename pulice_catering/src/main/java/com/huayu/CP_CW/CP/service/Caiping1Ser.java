package com.huayu.CP_CW.CP.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.CP_CW.CP.entity.Caiping;
import com.huayu.CP_CW.CP.mapper.CaiPingMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class Caiping1Ser extends ServiceImpl<CaiPingMapper, Caiping> {
   public List<Caiping> querycaiping(Caiping caiping){
      return baseMapper.querycaiping(caiping);
   }
}
