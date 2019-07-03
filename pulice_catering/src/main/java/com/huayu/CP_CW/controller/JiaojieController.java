package com.huayu.CP_CW.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.huayu.CP_CW.bean.JiaoJie;
import com.huayu.CP_CW.bean.Json;
import com.huayu.CP_CW.service.JiaojieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

;

@Controller
@RequestMapping("/jiaojie")
public class JiaojieController {

    private JiaoJie jiaoJie;
    private List<JiaoJie> jieList;

    @Autowired
    private JiaojieService jiaojieService;

    public JiaoJie getJiaoJie() { return jiaoJie; }
    public void setJiaoJie(JiaoJie jiaoJie) { this.jiaoJie = jiaoJie; }
    public List<JiaoJie> getJieList() { return jieList; }
    public void setJieList(List<JiaoJie> jieList) { this.jieList = jieList; }
    public void setJiaojieService(JiaojieService jiaojieService) { this.jiaojieService = jiaojieService; }

    @RequestMapping("/queryAll.do")
    @ResponseBody
    public Json queryAll(JiaoJie jiaoJie, Integer page, Integer limit){
        Page pagee= PageHelper.startPage(page,limit,true);
        List<JiaoJie> li=jiaojieService.queryAll(jiaoJie);
        Json json=new Json();
        json.setCode(0);
        json.setMsg("");
        json.setCount(jiaojieService.queryAll(jiaoJie).size());
        json.setData(li);
        return json;
    }


    @RequestMapping("/delect.do")
    @ResponseBody
    public void delect(int id){
        jiaojieService.delect(id);
    }

   /* @RequestMapping("/queryByID.do")
    public String queryByID(int id){
        System.out.println("成功进入修改");
        jiaojieService.queryByID(id);
        return "/jsp/financeMG/danjuupdate";
    }*/
    @RequestMapping("/queryByID.do")
    public ModelAndView toUp(int id){
        jiaoJie=jiaojieService.queryByID(id);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("jiaojie",jiaoJie);
        modelAndView.setViewName("financeMG/jiaojieupdate.jsp");
        return modelAndView;
    }
    @RequestMapping("/update.do")
    @ResponseBody
    public void up(JiaoJie jiaoJie){
        jiaojieService.up(jiaoJie);
    }

    @RequestMapping("/insert.do")
    public ModelAndView insert (JiaoJie jiaoJie){
        jiaojieService.insert(jiaoJie);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("financeMG/jiaojieinsert.jsp");
        return modelAndView;
    }

    @RequestMapping("/toAdd.do")
    public String insert (){
        return "financeMG/jiaojieinsert.jsp";
    }

   /* @RequestMapping("/cx.do")
    public ModelAndView cx(Danju danju){
        listDanju=danjuService.cx(danju);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("list",listDanju);
        modelAndView.setViewName("/jsp/financeMG/danju");
        return modelAndView;
    }
*/
}
