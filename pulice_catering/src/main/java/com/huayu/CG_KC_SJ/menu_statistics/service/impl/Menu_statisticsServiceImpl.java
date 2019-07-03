package com.huayu.CG_KC_SJ.menu_statistics.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.CG_KC_SJ.menu_statistics.entity.Menu_statistics;
import com.huayu.CG_KC_SJ.menu_statistics.mapper.Menu_statisticsMapper;
import com.huayu.CG_KC_SJ.menu_statistics.service.IMenu_statisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-06-12
 */
@Service
public class Menu_statisticsServiceImpl extends ServiceImpl<Menu_statisticsMapper, Menu_statistics> implements IMenu_statisticsService {
    @Autowired
    private Menu_statisticsMapper menu_statisticsMapper;
public List<Menu_statistics> query(Menu_statistics menu_statistics) {
    return menu_statisticsMapper.query(menu_statistics);
}

}
