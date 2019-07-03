package com.huayu.CG_KC_SJ.menu_statistics.controller;

import com.github.pagehelper.PageHelper;
import com.huayu.CG_KC_SJ.menu_statistics.entity.Menu_statistics;
import com.huayu.CG_KC_SJ.menu_statistics.service.impl.Menu_statisticsServiceImpl;
import com.huayu.CG_KC_SJ.util.layui;
import com.huayu.JC_HY_DD.stores_information.service.impl.Stores_informationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-06-12
 */
@Controller
@RequestMapping("/menu_statistics/menu-statistics")
public class Menu_statisticsController {
    @Autowired
    private Menu_statisticsServiceImpl menu_statisticsServiceImpl;
    @Autowired
    private Stores_informationServiceImpl stores_informationServiceImpl;


    @RequestMapping(value = "he.do")
    public String ss(Model model){
        model.addAttribute("ist",stores_informationServiceImpl.list(null));
        return "CG_KC_SJ/SJ/cptongji.html";
    }

    //查询
    @RequestMapping(value = "/hekaihui1.do")
    @ResponseBody
    public layui query(Menu_statistics menu_statistics, Integer page, Integer limit){
        PageHelper.startPage(page,limit,true);
        List<Menu_statistics> raw_material_informations=menu_statisticsServiceImpl.query(menu_statistics);
        layui layui =new layui();
        layui.setCode(0);
        layui.setMsg("");
        layui.setCount(menu_statisticsServiceImpl.query(menu_statistics).size());
        layui.setData(raw_material_informations);
        return layui;
    }
}
