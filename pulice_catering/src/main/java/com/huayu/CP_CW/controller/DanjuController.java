package com.huayu.CP_CW.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.huayu.CP_CW.bean.Danju;
import com.huayu.CP_CW.bean.DanjuType;
import com.huayu.CP_CW.bean.Json;
import com.huayu.CP_CW.service.DanjuService;
import com.huayu.CP_CW.service.DanjuTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/danju")
public class DanjuController {

    private Danju danju;
    private List<Danju> listDanju;
    private List<DanjuType> listDanjutype;

    @Autowired
    private DanjuService danjuService;
    @Autowired
    private DanjuTypeService danjuTypeService;
    public void setDanjuService(DanjuService danjuService) { this.danjuService = danjuService; }
    public void setDanjuTypeService(DanjuTypeService danjuTypeService) { this.danjuTypeService = danjuTypeService; }

    public Danju getDanju() { return danju; }
    public void setDanju(Danju danju) { this.danju = danju; }
    public List<Danju> getListDanju() { return listDanju; }
    public void setListDanju(List<Danju> listDanju) { this.listDanju = listDanju; }
    public List<DanjuType> getListDanjutype() { return listDanjutype; }
    public void setListDanjutype(List<DanjuType> listDanjutype) { this.listDanjutype = listDanjutype; }
    @RequestMapping("/queryAll.do")
    @ResponseBody
    public Json queryAll(Danju danju, Integer page, Integer limit){
        DanjuType danjuType=new DanjuType();
        danju.setTy(danjuType);
        Page pagee= PageHelper.startPage(page,limit,true);
        List<Danju> li=danjuService.queryAll(danju);
        Json json=new Json();
        json.setCode(0);
        json.setMsg("");
        json.setCount(danjuService.queryAll(danju).size());
        json.setData(li);
        return json;
    }


    @RequestMapping("/delect.do")
    @ResponseBody
    public void delect(int id){
        danjuService.delect(id);
    }
/*
    @RequestMapping("/queryByID.do")
    public String queryByID(int id){
        System.out.println("成功进入修改");
        danjuService.queryByID(id);
        return "/jsp/financeMG/danjuupdate";
    }*/
    @RequestMapping("/queryByID.do")
    public ModelAndView toUp(int id){
        Danju danju=danjuService.queryByID(id);
        listDanjutype=danjuTypeService.queryAll();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("danju",danju);
        modelAndView.addObject("list",listDanjutype);
        modelAndView.setViewName("financeMG/danjuupdate.jsp");
        return modelAndView;
    }

    @RequestMapping("/update.do")
    @ResponseBody
    public void up (Danju danju){
        DanjuType danjuType=new DanjuType();
        danju.setTy(danjuType);
        System.out.println(danju.toString()+"=============================================");
        danjuService.up(danju);
    }







    @RequestMapping("/cx.do")
    public ModelAndView cx(Danju danju){
        listDanju=danjuService.cx(danju);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("list",listDanju);
        modelAndView.setViewName("financeMG/danju.jsp");
        return modelAndView;
    }

}
