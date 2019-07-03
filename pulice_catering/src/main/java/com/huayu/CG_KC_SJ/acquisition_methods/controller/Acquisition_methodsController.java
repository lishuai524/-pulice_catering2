package com.huayu.CG_KC_SJ.acquisition_methods.controller;

import com.github.pagehelper.PageHelper;
import com.huayu.CG_KC_SJ.acquisition_methods.entity.Acquisition_methods;
import com.huayu.CG_KC_SJ.acquisition_methods.service.impl.Acquisition_methodsServiceImpl;
import com.huayu.CG_KC_SJ.util.layui;
import com.huayu.JC_HY_DD.stores_information.service.impl.Stores_informationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
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
@RequestMapping("/acquisition_methods/acquisition-methods")
public class Acquisition_methodsController{
    @Autowired
private Acquisition_methodsServiceImpl acquisition_methodsServiceImpl;
    @Autowired
    private Stores_informationServiceImpl stores_informationServiceImpl;


    @RequestMapping(value = "he.do")
    public String ss(Model  model){
        model.addAttribute("ist",stores_informationServiceImpl.list(null));
        return "CG_KC_SJ/CG/cgfangshi.html";
    }

 //查询
    @RequestMapping(value = "/hekaihui1.do")
    @ResponseBody
    public layui query(Acquisition_methods acquisition_methods, Integer page, Integer limit){
        PageHelper.startPage(page,limit,true);
        List<Acquisition_methods> raw_material_informations=acquisition_methodsServiceImpl.query(acquisition_methods);
        layui layui =new layui();
        layui.setCode(0);
        layui.setMsg("");
        layui.setCount(acquisition_methodsServiceImpl.query(acquisition_methods).size());
        layui.setData(raw_material_informations);
        return layui;
    }
    //删除
    @RequestMapping(value = "/delete.do")
    @ResponseBody
    public  Boolean delete(Integer id) {
        return   acquisition_methodsServiceImpl.removeById(id);
    }
    //去修改
    @RequestMapping(value = "/toupdate.do")
    public String toadd(Model model,Integer id){
        model.addAttribute("list",acquisition_methodsServiceImpl.getById(id));
        return "CG_KC_SJ/CG/cgfupdate.html";
    }
    //修改
    @RequestMapping(value = "/update.do")
    @ResponseBody
    public Boolean update(@RequestBody Acquisition_methods acquisition_methods){
        return acquisition_methodsServiceImpl.updateById(acquisition_methods);
    }

}
