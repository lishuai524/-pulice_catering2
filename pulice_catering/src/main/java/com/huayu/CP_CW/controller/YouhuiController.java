package com.huayu.CP_CW.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.huayu.CP_CW.bean.Json;
import com.huayu.CP_CW.bean.Youhui;
import com.huayu.CP_CW.service.YouhuiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/youhui")
public class YouhuiController {

    private Youhui youhui;
    private List<Youhui> youhuiList;

    @Autowired
    private YouhuiService youhuiService;

    public Youhui getYouhui() { return youhui; }
    public void setYouhui(Youhui youhui) { this.youhui = youhui; }
    public List<Youhui> getYouhuiList() { return youhuiList; }
    public void setYouhuiList(List<Youhui> youhuiList) { this.youhuiList = youhuiList; }
    public void setYouhuiService(YouhuiService youhuiService) { this.youhuiService = youhuiService; }

    @RequestMapping("/queryAll.do")
    @ResponseBody
    public Json queryAll(Youhui youhui, Integer page, Integer limit){
        Page pagee= PageHelper.startPage(page,limit,true);
        List<Youhui> li=youhuiService.queryAll(youhui);
        Json json=new Json();
        json.setCode(0);
        json.setMsg("");
        json.setCount(youhuiService.queryAll(youhui).size());
        json.setData(li);
        return json;
    }


    @RequestMapping("/delect.do")
    @ResponseBody
    public void delect(int id){
        youhuiService.delect(id);
    }

    @RequestMapping("/queryByID.do")
    public ModelAndView toUp(int id){
        youhui=youhuiService.queryByID(id);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("youhui",youhui);
        modelAndView.setViewName("financeMG/youhuiupdate.jsp");
        return modelAndView;
    }
    @RequestMapping("/update.do")
    @ResponseBody
    public void up(Youhui youhui){
        youhuiService.up(youhui);
    }

    @RequestMapping("/insert.do")
    public ModelAndView insert (Youhui youhui){
        youhuiService.insert(youhui);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("financeMG/jiaojieinsert.jsp");
        return modelAndView;
    }

    @RequestMapping("/toAdd.do")
    public String insert (){
        return "financeMG/jiaojieinsert.jsp";
    }


}
