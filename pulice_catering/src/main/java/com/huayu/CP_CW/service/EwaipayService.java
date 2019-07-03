package com.huayu.CP_CW.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.CP_CW.bean.Ewaipay;
import com.huayu.CP_CW.mapper.EwaipayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EwaipayService extends ServiceImpl<EwaipayMapper, Ewaipay> {
    @Autowired
    public EwaipayMapper ewaipayMapper;

    public List<Ewaipay> queryAll(Ewaipay ewaipay){ return ewaipayMapper.queryAll(ewaipay);}

    public void delect(int id){ ewaipayMapper.delect(id);}

    public void up(Ewaipay ewai){  ewaipayMapper.up(ewai);}

    public Ewaipay queryByID(int id){  return ewaipayMapper.queryByID(id);}

    public int insert(Ewaipay ewai){ return ewaipayMapper.insert(ewai); }



}
