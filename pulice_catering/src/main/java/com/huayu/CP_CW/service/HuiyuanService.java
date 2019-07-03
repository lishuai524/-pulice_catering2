package com.huayu.CP_CW.service;

import com.huayu.CP_CW.bean.Huiyuan;
import com.huayu.CP_CW.mapper.HuiyuanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HuiyuanService {
    @Autowired
    public HuiyuanMapper huiyuanMapper;

    public List<Huiyuan> queryAll(Huiyuan huiyuan){ return huiyuanMapper.queryAll(huiyuan);}


    public void up(Huiyuan huiyuan){ huiyuanMapper.up(huiyuan);}

    public Huiyuan queryByID(int id){  return huiyuanMapper.queryByID(id);}




}
