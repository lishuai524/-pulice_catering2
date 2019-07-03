package com.huayu.CG_KC_SJ.kind.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.CG_KC_SJ.kind.entity.kin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class kind_service extends ServiceImpl<com.huayu.CG_KC_SJ.kind.mapper.kind_mapper, kin>{
  @Autowired
    private com.huayu.CG_KC_SJ.kind.mapper.kind_mapper kind_mapper;

  public List<kin> query(){
      return kind_mapper.query();
  }

}
