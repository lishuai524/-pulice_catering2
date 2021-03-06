package com.huayu.CG_KC_SJ.other_expenses.controller;

import com.github.pagehelper.PageHelper;
import com.huayu.CG_KC_SJ.other_expenses.entity.Other_expenses;
import com.huayu.CG_KC_SJ.other_expenses.service.impl.Other_expensesServiceImpl;
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
@RequestMapping("/other_expenses/other-expenses")
public class Other_expensesController {
    @Autowired
private Other_expensesServiceImpl other_expensesServiceImpl;


    @Autowired
    private Stores_informationServiceImpl stores_informationServiceImpl;


    @RequestMapping(value = "he.do")
    public String ss(Model model){
        model.addAttribute("ist",stores_informationServiceImpl.list(null));
        return "CG_KC_SJ/SJ/scfytongji.html";
    }
    //查询
    @RequestMapping(value = "/hekaihui1.do")
    @ResponseBody
    public layui query(Other_expenses other_expenses, Integer page, Integer limit){
        PageHelper.startPage(page,limit,true);
        List<Other_expenses> raw_material_informations=other_expensesServiceImpl.query(other_expenses);
        layui layui =new layui();
        layui.setCode(0);
        layui.setMsg("");
        layui.setCount(other_expensesServiceImpl.query(other_expenses).size());
        layui.setData(raw_material_informations);
        return layui;
    }
}
