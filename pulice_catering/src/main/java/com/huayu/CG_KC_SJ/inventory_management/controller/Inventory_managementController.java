package com.huayu.CG_KC_SJ.inventory_management.controller;

import com.github.pagehelper.PageHelper;
import com.huayu.CG_KC_SJ.inventory_management.entity.Inventory_management;
import com.huayu.CG_KC_SJ.inventory_management.service.impl.Inventory_managementServiceImpl;
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
@RequestMapping("/inventory_management/inventory-management")
public class Inventory_managementController {
    @Autowired
 private Inventory_managementServiceImpl inventory_managementServiceImpl;
    @Autowired
    private Stores_informationServiceImpl stores_informationServiceImpl;


    @RequestMapping(value = "he.do")
    public String ss(Model model){
        model.addAttribute("ist",stores_informationServiceImpl.list(null));
        return "CG_KC_SJ/KC/pankudan.html";
    }


//查询
    @RequestMapping(value = "/hekaihui1.do")
    @ResponseBody
    public layui query(Inventory_management inventory_management, Integer page, Integer limit){
        PageHelper.startPage(page,limit,true);
        List<Inventory_management> raw_material_informations=inventory_managementServiceImpl.query(inventory_management);
        layui layui =new layui();
        layui.setCode(0);
        layui.setMsg("");
        layui.setCount(inventory_managementServiceImpl.query(inventory_management).size());
        layui.setData(raw_material_informations);
        return layui;
    }
}
