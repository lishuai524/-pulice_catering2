package com.huayu.CP_CW.CP.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.CP_CW.CP.entity.CaiDanShow;
import com.huayu.CP_CW.CP.mapper.CaiDanShowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CaidanShowSer extends ServiceImpl<CaiDanShowMapper, CaiDanShow> {
   public List<CaiDanShow> querycaidanshow(CaiDanShow caiDanShow){
      return baseMapper.querycaidanshow(caiDanShow);
   }
}
