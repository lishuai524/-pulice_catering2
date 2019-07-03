package com.huayu.CG_KC_SJ.temporary_inventory.controller;

import com.github.pagehelper.PageHelper;
import com.huayu.JC_HY_DD.stores_information.service.impl.Stores_informationServiceImpl;
import com.huayu.CG_KC_SJ.temporary_inventory.entity.Temporary_inventory;
import com.huayu.CG_KC_SJ.temporary_inventory.service.impl.Temporary_inventoryServiceImpl;
import com.huayu.CG_KC_SJ.util.layui;
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
@RequestMapping("/temporary_inventory/temporary-inventory")
public class Temporary_inventoryController {
       @Autowired
    private Temporary_inventoryServiceImpl temporary_inventoryServiceImpl;
    @Autowired
    private Stores_informationServiceImpl stores_informationServiceImpl;


    @RequestMapping(value = "he.do")
    public String ss(Model model){
        model.addAttribute("ist",stores_informationServiceImpl.list(null));
        return "CG_KC_SJ/KC/ssruku.html";
    }

    //查询
    @RequestMapping(value = "/hekaihui1.do")
    @ResponseBody
    public layui query(Temporary_inventory temporary_inventory, Integer page, Integer limit){
        PageHelper.startPage(page,limit,true);
        List<Temporary_inventory> raw_material_informations=temporary_inventoryServiceImpl.query(temporary_inventory);
        layui layui =new layui();
        layui.setCode(0);
        layui.setMsg("");
        layui.setCount(temporary_inventoryServiceImpl.query(temporary_inventory).size());
        layui.setData(raw_material_informations);
        return layui;
    }
}
