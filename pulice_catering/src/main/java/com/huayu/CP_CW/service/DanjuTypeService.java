package com.huayu.CP_CW.service;

import com.huayu.CP_CW.bean.DanjuType;
import com.huayu.CP_CW.mapper.DanjutypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DanjuTypeService {
    @Autowired
   public DanjutypeMapper danjutypeMapper;

    public List<DanjuType> queryAll(){ return danjutypeMapper.queryAll();}

}
