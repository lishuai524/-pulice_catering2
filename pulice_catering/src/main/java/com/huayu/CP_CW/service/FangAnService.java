package com.huayu.CP_CW.service;

import com.huayu.CP_CW.bean.FangAn;
import com.huayu.CP_CW.mapper.FangAnMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FangAnService {
    @Autowired
    public FangAnMapper fangAnMapper;

    public List<FangAn> queryAll(FangAn fangAn){ return fangAnMapper.queryAll(fangAn);}

    public void delect(int id){ fangAnMapper.delect(id);}

    public void up(FangAn fangAn){ fangAnMapper.up(fangAn);}

    public FangAn queryByID(int id){  return fangAnMapper.queryByID(id);}

    public int insert(FangAn fangAn){    return  fangAnMapper.insert(fangAn); }



}
