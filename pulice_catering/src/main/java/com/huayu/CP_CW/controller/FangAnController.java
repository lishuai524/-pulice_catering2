package com.huayu.CP_CW.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.huayu.CP_CW.bean.FangAn;
import com.huayu.CP_CW.bean.Json;
import com.huayu.CP_CW.service.FangAnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/fangan")
public class FangAnController {

    private FangAn fangAn;
    private List<FangAn> fangAnList;

    @Autowired
    private FangAnService fangAnService;

    public FangAn getFangAn() { return fangAn; }
    public void setFangAn(FangAn fangAn) { this.fangAn = fangAn; }
    public List<FangAn> getFangAnList() { return fangAnList; }
    public void setFangAnList(List<FangAn> fangAnList) { this.fangAnList = fangAnList; }
    public void setFangAnService(FangAnService fangAnService) { this.fangAnService = fangAnService; }

    @RequestMapping("/queryAll.do")
    @ResponseBody
    public Json queryAll(FangAn fangAn, Integer page, Integer limit){
        Page pagee= PageHelper.startPage(page,limit,true);
        List<FangAn> li=fangAnService.queryAll(fangAn);
        Json json=new Json();
        json.setCode(0);
        json.setMsg("");
        json.setCount(fangAnService.queryAll(fangAn).size());
        json.setData(li);
        return json;
    }


    @RequestMapping("/delect.do")
    @ResponseBody
    public void delect(int id){
        fangAnService.delect(id);
    }


    @RequestMapping("/queryByID.do")
    public ModelAndView toUp(int id){
        fangAn=fangAnService.queryByID(id);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("fangan",fangAn);
        modelAndView.setViewName("financeMG/fanganupdate.jsp");
        return modelAndView;
    }
    @RequestMapping("/update.do")
    @ResponseBody
    public void up(FangAn fangAn){
        fangAnService.up(fangAn);
    }

    @RequestMapping("/insert.do")
    public ModelAndView insert (FangAn fangAn){
        System.out.println(fangAn.toString()+"================================================================");
        fangAnService.insert(fangAn);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("financeMG/fanganinsert.jsp");
        return modelAndView;
    }

    @RequestMapping("/toAdd.do")
    public String insert (){
        return "financeMG/fanganinsert.jsp";
    }


}
