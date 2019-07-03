package com.huayu.CP_CW.service;

import com.huayu.CP_CW.bean.Youhui;
import com.huayu.CP_CW.mapper.YouhuiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YouhuiService {

    @Autowired
    public YouhuiMapper youhuiMapper;

    public List<Youhui> queryAll(Youhui youhui){ return youhuiMapper.queryAll(youhui);}

    public void delect(int id){  youhuiMapper.delect(id);}

    public Youhui queryByID(int id){ return youhuiMapper.queryByID(id); }

    public void insert(Youhui youhui){ youhuiMapper.insert(youhui);}

    public void up(Youhui youhui){ youhuiMapper.up(youhui);}

  /*  public List<Danju> cx(Youhui youhui){ return youhuiMapper.cx(youhui);}*/

}
