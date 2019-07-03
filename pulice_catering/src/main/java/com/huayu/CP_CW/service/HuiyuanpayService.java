package com.huayu.CP_CW.service;

import com.huayu.CP_CW.bean.Huiyuanpay;
import com.huayu.CP_CW.mapper.HuiyuanpayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HuiyuanpayService {
    @Autowired
    public HuiyuanpayMapper huiyuanpayMapper;

    public List<Huiyuanpay> queryAll(Huiyuanpay huiyuanpay){ return huiyuanpayMapper.queryAll(huiyuanpay);}


    public void insert(Huiyuanpay huiyuanpay){ huiyuanpayMapper.insert(huiyuanpay);}

    public void dec(int id){ huiyuanpayMapper.dec(id);}

    /*public Huiyuanpay queryByID(int id){  return huiyuanpayMapper.queryByID(id);}*/




}
