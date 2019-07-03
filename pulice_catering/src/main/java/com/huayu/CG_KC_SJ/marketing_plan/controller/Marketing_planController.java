package com.huayu.CG_KC_SJ.marketing_plan.controller;

import com.github.pagehelper.PageHelper;
import com.huayu.CG_KC_SJ.kind.service.kind_service;
import com.huayu.CG_KC_SJ.marketing_plan.entity.Marketing_plan;
import com.huayu.CG_KC_SJ.marketing_plan.entity.plan;
import com.huayu.CG_KC_SJ.marketing_plan.service.impl.Marketing_planServiceImpl;
import com.huayu.JC_HY_DD.stores_information.service.impl.Stores_informationServiceImpl;
import com.huayu.CG_KC_SJ.util.layui;
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
@RequestMapping("/marketing_plan/marketing-plan")
public class Marketing_planController {

    @Autowired
    private Marketing_planServiceImpl marketing_planServiceImpl;
    @Autowired
    private  kind_service kind_service;
     @Autowired
     private com.huayu.CG_KC_SJ.unit.service.unit_service unit_service;
     @Autowired
     private Stores_informationServiceImpl stores_informationServiceImpl;

    @RequestMapping(value = "he.do")
    public String ss(Model  model){
        model.addAttribute("ist",stores_informationServiceImpl.list(null));
        return "CG_KC_SJ/CG/xiaoshou.html";
    }

    /**
     * 查询
     * @param marketing_plan
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping(value = "/query.do")
    @ResponseBody
    public layui query(Marketing_plan marketing_plan, Integer page, Integer limit){
        PageHelper.startPage(page,limit,true);
        List<Marketing_plan> raw_material_informations=marketing_planServiceImpl.query(marketing_plan);
        layui layui =new layui();
        layui.setCode(0);
        layui.setMsg("");
        layui.setCount(marketing_planServiceImpl.query(marketing_plan).size());
        layui.setData(raw_material_informations);
        return layui;
    }

    //去添加
    @RequestMapping(value = "/toadd.do")
    public String toadd(Model model){
        //门店
         model.addAttribute("ist",stores_informationServiceImpl.list(null));
        //菜品
        //model.addAttribute("tolist", kind_service.query());
        model.addAttribute("tolist", kind_service.query());
        return "CG_KC_SJ/CG/xsadd.html";
    }

    //添加清单
    @RequestMapping(value = "/tosave.do")
    public String query1(Integer cuisine,Model model){
        System.out.println("------"+cuisine);
        plan list= marketing_planServiceImpl.queryall(cuisine);
        System.out.println(marketing_planServiceImpl.queryall(cuisine));
        model.addAttribute("list",list);
        return "CG_KC_SJ/CG/xssave.html";
    }



    //添加
    @RequestMapping(value = "/add.do")
    @ResponseBody
    public  Boolean add(@RequestBody Marketing_plan marketing_plan){
        return  marketing_planServiceImpl.save(marketing_plan);
    }

    //删除
    @RequestMapping(value = "/delete.do")
    @ResponseBody
    public  Boolean delete(Integer id) {
        return   marketing_planServiceImpl.removeById(id);
    }

    //去修改
    @RequestMapping(value = "/toupdate.do")
    public  String toupdate(Model model,Integer id){
        model.addAttribute("list1",marketing_planServiceImpl.getById(id));
        model.addAttribute("tolist",kind_service.query());
        model.addAttribute("ist",stores_informationServiceImpl.list(null));
        return "CG_KC_SJ/CG/xsupdate.html";
    }
    //修改
    @RequestMapping(value = "/update.do")
    @ResponseBody
    public Boolean update(@RequestBody Marketing_plan marketing_plan){
        return marketing_planServiceImpl.updateById(marketing_plan);
    }
    //添加到采购计划表

}
