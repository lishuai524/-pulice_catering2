package com.huayu.JC_HY_DD.asset_information.controller;

import com.github.pagehelper.PageHelper;
import com.huayu.JC_HY_DD.asset_information.entity.Asset_information;
import com.huayu.JC_HY_DD.asset_information.entity.Property;
import com.huayu.JC_HY_DD.asset_information.service.impl.Asset_informationServiceImpl;
import com.huayu.JC_HY_DD.asset_information.service.impl.PropertySerivce;
import com.huayu.JC_HY_DD.queuing_management.entity.DataMessage;
import com.huayu.JC_HY_DD.stores_information.entity.Stores_information;
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
@RequestMapping("/asset_information/asset-information")
public class Asset_informationController {
    @Autowired
    private Asset_informationServiceImpl assetInformationService;

    @Autowired
    private PropertySerivce propertySerivce;

    @Autowired
    private Stores_informationServiceImpl informationService;

    @RequestMapping("/queryAll.do")
    @ResponseBody
    public DataMessage queryAll(Asset_information information , Integer page, Integer limit) {
        DataMessage dataMessage = new DataMessage();
        dataMessage.setCode(0);
        dataMessage.setMsg("");
        dataMessage.setCount(assetInformationService.queryAll(information).size());
        PageHelper.startPage(page, limit, true);
        List<Asset_information> list = assetInformationService.queryAll(information);
        dataMessage.setData(list);
        return dataMessage;
    }


    @RequestMapping("/toquery.do")
    public String toquery(Model model){
        List<Stores_information> list = informationService.list(null);
        model.addAttribute("list",list);
        return "JC_HY_DD/JC/property.jsp";
    }


    @RequestMapping("/queryAll1.do")
    @ResponseBody
    public DataMessage queryAll1(Property property , Integer page, Integer limit) {
        DataMessage dataMessage = new DataMessage();
        dataMessage.setCode(0);
        dataMessage.setMsg("");
        dataMessage.setCount(propertySerivce.queryAll(property).size());
        PageHelper.startPage(page, limit, true);
        List<Property> list = propertySerivce.queryAll(property);
        dataMessage.setData(list);
        return dataMessage;
    }
    @RequestMapping("/queryAll2.do")
    @ResponseBody
    public DataMessage queryAll2(Property property, Integer page, Integer limit) {
        DataMessage dataMessage = new DataMessage();
        dataMessage.setCode(0);
        dataMessage.setMsg("");
        dataMessage.setCount(propertySerivce.queryAll2(property).size());
        PageHelper.startPage(page, limit, true);
        List<Property> list = propertySerivce.queryAll2(property);
        dataMessage.setData(list);
        return dataMessage;
    }


    @RequestMapping("/toadd.do")
    public String toadd(Model model){
        List<Stores_information> list = informationService.list(null);
        model.addAttribute("list",list);
        return "JC_HY_DD/JC/addproperty.jsp";
    }

    @RequestMapping("/add.do")
    public String add(Property property){
        propertySerivce.save(property);
        return "redirect:/asset_information/asset-information/toadd.do";
    }

}
