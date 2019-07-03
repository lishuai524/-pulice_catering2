package com.huayu.CP_CW.CP.controller;

import com.huayu.CP_CW.CP.entity.Caipingtype;
import com.huayu.CP_CW.CP.entity.LayuiDemo;
import com.huayu.CP_CW.CP.service.CaipingtypeSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("caipingtype")
public class CaipingTypeCor {
   @Autowired
   private CaipingtypeSer caipingtypeSer;

   @RequestMapping(value = "querytype.do")
   @ResponseBody
   public LayuiDemo querytype(Caipingtype caipingtype) {
      LayuiDemo layuiDemo=new LayuiDemo();
//      PageHelper.startPage(page,limit,true);
      List<Caipingtype> list = caipingtypeSer.querytype1(caipingtype);
      layuiDemo.setCode(0);
      layuiDemo.setMsg("");
      layuiDemo.setCount(caipingtypeSer.querytype1(caipingtype).size());//传总条数  重新查询所有的条数
      layuiDemo.setData(list);
      return layuiDemo;
   }

   @RequestMapping(value = "addtype.do")
   public String add(Caipingtype caipingtype) {
      caipingtypeSer.save(caipingtype);
      return "caipingMG/addcaipingtype.jsp";
   }

   @RequestMapping(value = "del.do")
   @ResponseBody
   public boolean del(int id) {
      return caipingtypeSer.removeById(id);
   }

   @RequestMapping(value = "toupdate.do")
   public String toupdate(Model model, int id) {
      model.addAttribute("list",caipingtypeSer.getById(id));
      return "caipingMG/totype.jsp";
   }

   @RequestMapping(value = "update.do")
   public String update(Caipingtype caipingtype) {
      caipingtypeSer.updateById(caipingtype);
      return "caipingMG/caipingtypelist.jsp";
   }

}
