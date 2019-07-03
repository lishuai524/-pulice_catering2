package com.huayu.CG_KC_SJ.cost_of_ingredients.controller;

import com.github.pagehelper.PageHelper;
import com.huayu.CG_KC_SJ.cost_of_ingredients.entity.Cost_of_ingredients;
import com.huayu.CG_KC_SJ.cost_of_ingredients.service.impl.Cost_of_ingredientsServiceImpl;
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
@RequestMapping("/cost_of_ingredients/cost-of-ingredients")
public class Cost_of_ingredientsController {
    @Autowired
    private Cost_of_ingredientsServiceImpl cost_of_ingredientsServiceImpl;

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
    public layui query(Cost_of_ingredients cost_of_ingredients, Integer page, Integer limit){
        PageHelper.startPage(page,limit,true);
        List<Cost_of_ingredients> raw_material_informations=cost_of_ingredientsServiceImpl.query(cost_of_ingredients);
        layui layui =new layui();
        layui.setCode(0);
        layui.setMsg("");
        layui.setCount(cost_of_ingredientsServiceImpl.query(cost_of_ingredients).size());
        layui.setData(raw_material_informations);
        return layui;
    }
}
