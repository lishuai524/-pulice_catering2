package com.huayu.CG_KC_SJ.stocktaking_manage.controller;

import com.github.pagehelper.PageHelper;
import com.huayu.CG_KC_SJ.stocktaking_manage.entity.Stocktaking_manage;
import com.huayu.CG_KC_SJ.stocktaking_manage.service.impl.Stocktaking_manageServiceImpl;
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
@RequestMapping("/stocktaking_manage/stocktaking-manage")
public class Stocktaking_manageController {
   @Autowired
    private Stocktaking_manageServiceImpl stocktaking_manageServiceImpl;
    @Autowired
    private Stores_informationServiceImpl stores_informationServiceImpl;


    @RequestMapping(value = "he.do")
    public String ss(Model model){
        model.addAttribute("ist",stores_informationServiceImpl.list(null));
        return "CG_KC_SJ/KC/panku.html";
    }
    //查询
    @RequestMapping(value = "/hekaihui1.do")
    @ResponseBody
    public layui query(Stocktaking_manage stocktaking_manage, Integer page, Integer limit){
        PageHelper.startPage(page,limit,true);
        List<Stocktaking_manage> raw_material_informations=stocktaking_manageServiceImpl.query(stocktaking_manage);
        layui layui =new layui();
        layui.setCode(0);
        layui.setMsg("");
        layui.setCount(stocktaking_manageServiceImpl.query(stocktaking_manage).size());
        layui.setData(raw_material_informations);
        return layui;
    }




}
