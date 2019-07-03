package com.huayu.CP_CW.CP.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.CP_CW.CP.entity.Danwei;
import com.huayu.CP_CW.CP.mapper.DanWeiMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DanweiSer extends ServiceImpl<DanWeiMapper, Danwei> {

}
