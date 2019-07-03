package com.huayu.CP_CW.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.CP_CW.bean.Ewai;
import com.huayu.CP_CW.mapper.EwaiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EwaiService extends ServiceImpl<EwaiMapper, Ewai> {
    @Autowired
    public EwaiMapper ewaiMapper;

    public List<Ewai> queryAll(Ewai ewai){ return ewaiMapper.queryAll(ewai);}

    public void delect(int id){ ewaiMapper.delect(id);}

    public void up(Ewai ewai){  ewaiMapper.up(ewai);}

    public Ewai queryByID(int id){  return ewaiMapper.queryByID(id);}

    public int insert(Ewai ewai){ return ewaiMapper.insert(ewai); }



}
