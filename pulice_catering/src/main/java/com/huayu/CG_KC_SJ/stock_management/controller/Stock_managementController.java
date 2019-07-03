package com.huayu.CG_KC_SJ.stock_management.controller;

import com.github.pagehelper.PageHelper;
import com.huayu.CG_KC_SJ.stock_management.entity.Stock_management;
import com.huayu.CG_KC_SJ.stock_management.service.impl.Stock_managementServiceImpl;
import com.huayu.CG_KC_SJ.util.layui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@RequestMapping("/stock_management/stock-management")
public class Stock_managementController {
    @Autowired
private Stock_managementServiceImpl stock_managementServiceImpl;

    //查询
    @RequestMapping(value = "/hekaihui1.do")
    @ResponseBody
    public layui query(Stock_management stock_management, Integer page, Integer limit){
        PageHelper.startPage(page,limit,true);
        List<Stock_management> raw_material_informations=stock_managementServiceImpl.query(stock_management);
        layui layui =new layui();
        layui.setCode(0);
        layui.setMsg("");
        layui.setCount(stock_managementServiceImpl.query(stock_management).size());
        layui.setData(raw_material_informations);
        return layui;
    }

    //删除
    @RequestMapping(value = "delete.do")
    @ResponseBody
    public Boolean delete(Integer id){
        return  stock_managementServiceImpl.removeById(id);
    }
}
