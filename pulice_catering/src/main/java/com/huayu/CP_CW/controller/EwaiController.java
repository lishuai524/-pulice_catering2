package com.huayu.CP_CW.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.huayu.CP_CW.bean.Ewai;
import com.huayu.CP_CW.bean.Json;
import com.huayu.CP_CW.service.EwaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/ewai")
public class EwaiController {

    private Ewai ewai;
    private List<Ewai> ewaiList;

    @Autowired
    private EwaiService ewaiService;

    public Ewai getEwai() { return ewai; }
    public void setEwai(Ewai ewai) { this.ewai = ewai; }
    public List<Ewai> getEwaiList() { return ewaiList; }
    public void setEwaiList(List<Ewai> ewaiList) { this.ewaiList = ewaiList; }
    public void setEwaiService(EwaiService ewaiService) { this.ewaiService = ewaiService; }
    

    @RequestMapping("/queryAll.do")
     @ResponseBody
     public Json queryAll(Ewai ewai, Integer page, Integer limit){
          Page pagee= PageHelper.startPage(page,limit,true);
          List<Ewai> li=ewaiService.queryAll(ewai);
          Json json=new Json();
          json.setCode(0);
          json.setMsg("");
          json.setCount(ewaiService.queryAll(ewai).size());
          json.setData(li);
          return json;
     }


    @RequestMapping("/delect.do")
    @ResponseBody
    public void delect(int id){
        System.out.println(id+"====================================================================");

        ewaiService.delect(id);
    }

   /* @RequestMapping("/queryByID.do")
    public String queryByID(int id){
        System.out.println("成功进入修改");
        jiaojieService.queryByID(id);
        return "/jsp/financeMG/danjuupdate";
    }*/
    @RequestMapping("/queryByID.do")
    public ModelAndView toUp(int id){
        ewai=ewaiService.queryByID(id);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("ewai",ewai);
        modelAndView.setViewName("financeMG/ewaiupdate.jsp");
        return modelAndView;
    }
    @RequestMapping("/update.do")
    @ResponseBody
    public void up(Ewai ewai){
        System.out.println(ewai.toString()+"====================================================================");
        ewaiService.up(ewai);
    }

    @RequestMapping("/insert.do")
    public ModelAndView insert (Ewai ewai){
        ewaiService.save(ewai);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("financeMG/ewaiinsert.jsp");
        return modelAndView;
    }

    @RequestMapping("/toAdd.do")
    public String insert (){
        return "financeMG/ewaiinsert.jsp";
    }

}
