package com.huayu.CP_CW.service;


import com.huayu.CP_CW.bean.Danju;
import com.huayu.CP_CW.mapper.DanjuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DanjuService {

    @Autowired
    public DanjuMapper danjuMapper;

    public List<Danju> queryAll(Danju danju){ return danjuMapper.queryAll(danju);}

    public void delect(int id){  danjuMapper.delect(id);}

    public Danju queryByID(int id){ return danjuMapper.queryByID(id); }


    public void up(Danju danju){ danjuMapper.up(danju);}

    public List<Danju> cx(Danju danju){ return danjuMapper.cx(danju);}

}
