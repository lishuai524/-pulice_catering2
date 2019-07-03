package com.huayu.CP_CW.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.huayu.CP_CW.bean.Huiyuan;
import com.huayu.CP_CW.bean.Huiyuanpay;
import com.huayu.CP_CW.bean.Json;
import com.huayu.CP_CW.service.HuiyuanService;
import com.huayu.CP_CW.service.HuiyuanpayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/huiyuanWWC")
public class HuiyuanController {

    private Huiyuan huiyuan;
    private List<Huiyuan> list;
    private List<Huiyuanpay> listpay;

    @Autowired
    private HuiyuanService huiyuanService;

    @Autowired
    private HuiyuanpayService huiyuanpayService;

    public void setHuiyuanpayService(HuiyuanpayService huiyuanpayService) { this.huiyuanpayService = huiyuanpayService; }
    public List<Huiyuanpay> getListpay() { return listpay; }
    public void setListpay(List<Huiyuanpay> listpay) { this.listpay = listpay; }
    public Huiyuan getHuiyuan() { return huiyuan; }
    public void setHuiyuan(Huiyuan huiyuan) { this.huiyuan = huiyuan; }
    public List<Huiyuan> getList() { return list; }
    public void setList(List<Huiyuan> list) { this.list = list; }
    public void setHuiyuanService(HuiyuanService huiyuanService) { this.huiyuanService = huiyuanService; }

    @RequestMapping("/queryAll.do")
    @ResponseBody
    public Json queryAll(Huiyuan huiyuan, Integer page, Integer limit){
        Page pagee= PageHelper.startPage(page,limit,true);
        List<Huiyuan> li=huiyuanService.queryAll(huiyuan);
        Json json=new Json();
        json.setCode(0);
        json.setMsg("");
        json.setCount(huiyuanService.queryAll(huiyuan).size());
        json.setData(li);
        return json;
    }

    @RequestMapping("/queryByID.do")
    public ModelAndView toUp(int id){
        huiyuan=huiyuanService.queryByID(id);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("huiyuan",huiyuan);
        modelAndView.setViewName("financeMG/huiyuanupdate.jsp");
        return modelAndView;
    }
    @RequestMapping("/update.do")
    @ResponseBody
    public void up(Huiyuan huiyuane, Huiyuanpay huiyuanpay){

        int a=huiyuane.getMoney();
        int b=huiyuan.getMoney();
       huiyuan.setMoney(a+b);
        huiyuanService.up(huiyuan);
         huiyuanpayService.insert(huiyuanpay);
    }


    @RequestMapping("/querypayAll.do")
    @ResponseBody
    public Json queryAll(Huiyuanpay huiyuanpay, Integer page, Integer limit){
        Page pagee= PageHelper.startPage(page,limit,true);
        List<Huiyuanpay> le=huiyuanpayService.queryAll(huiyuanpay);
        Json json=new Json();
        json.setCode(0);
        json.setMsg("");
        json.setCount(huiyuanpayService.queryAll(huiyuanpay).size());
        json.setData(le);
        return json;
    }

    @RequestMapping("/dec.do")
    @ResponseBody
    public void delect(int id){
        huiyuanpayService.dec(id);
    }

}
