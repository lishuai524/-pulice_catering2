package com.huayu.CG_KC_SJ.unit.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.CG_KC_SJ.unit.entity.uni;
import com.huayu.CG_KC_SJ.unit.unit_mapper.mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class unit_service extends ServiceImpl<mapper, uni> {
    @Autowired
    private mapper mapper;


 public List<uni> query(){
     return mapper.query();
 }
}
