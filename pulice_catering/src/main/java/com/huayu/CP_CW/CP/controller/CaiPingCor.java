package com.huayu.CP_CW.CP.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huayu.CP_CW.CP.entity.*;
import com.huayu.CP_CW.CP.service.CaidanShowSer;
import com.huayu.CP_CW.CP.service.Caiping1Ser;
import com.huayu.CP_CW.CP.service.CaipingtypeSer;
import com.huayu.CP_CW.CP.service.DanweiSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("caiping")
public class CaiPingCor {

   @Autowired
   private Caiping1Ser caiping1Ser;

   @Autowired
   private CaipingtypeSer caipingtypeSer;
   @Autowired
   private DanweiSer danweiSer;
   @Autowired
   private CaidanShowSer caidanShowSer;


   @RequestMapping(value = "querycaiping.do")
   @ResponseBody
   public LayuiDemo querytcaiping(Caiping caiping) {
      LayuiDemo layuiDemo=new LayuiDemo();
//      PageHelper.startPage(page,limit,true);
      List<Caiping> list = caiping1Ser.querycaiping(caiping);
      layuiDemo.setCode(0);
      layuiDemo.setMsg("");
      layuiDemo.setCount(caiping1Ser.querycaiping(caiping).size());//传总条数  重新查询所有的条数
      layuiDemo.setData(list);
      return layuiDemo;
   }

//   @RequestMapping(value = "del.do")
//   @ResponseBody
//   public boolean del(int id) {
//      return caiping1Ser.removeById(id);
//   }

   @RequestMapping(value = "toadd.do")
   public String toadd(Model model){
      model.addAttribute("list",caipingtypeSer.list(new QueryWrapper<Caipingtype>()));
      model.addAttribute("dlist",danweiSer.list(new QueryWrapper<Danwei>()));
      model.addAttribute("clist",caidanShowSer.list(new QueryWrapper<CaiDanShow>()));
      return "caipingMG/addcaiping.jsp";
   }

   @RequestMapping(value = "addcaiping.do")
   public String add(@RequestParam("filename") MultipartFile pictureFile,Caiping caiping,HttpServletRequest request) throws Exception{
      Random random = new Random();
      int r= random.nextInt(11);
      // 图片上传
      // 设置图片名称，不能重复，可以使用uuid
      String e = request.getSession().getServletContext().getRealPath("");
      e = e.substring(0,e.indexOf("target"))+"src\\main\\webapp\\img\\";
      String oriName = pictureFile.getOriginalFilename();
      String extName = oriName.substring(oriName.lastIndexOf("."));
      File file = new File(e+oriName);
      if(!file.exists()){
         pictureFile.transferTo(new File(e + oriName));
      }
      String str = "/img/"+oriName;
      caiping.setImg(str);
      caiping1Ser.save(caiping);
      return "redirect:/caiping/toadd.do";
   }

   @RequestMapping(value = "toupdate.do")
   public String toupdate(Model model, int id) {
      model.addAttribute("list",caiping1Ser.getById(id));
      model.addAttribute("tlist",caipingtypeSer.list(new QueryWrapper<Caipingtype>()));
      model.addAttribute("dlist",danweiSer.list(new QueryWrapper<Danwei>()));
      model.addAttribute("clist",caidanShowSer.list(new QueryWrapper<CaiDanShow>()));
      return "caipingMG/tocaiping.jsp";
   }

   @RequestMapping(value = "update.do")
   public String update(@RequestParam("filename") MultipartFile pictureFile,Caiping caiping, HttpServletRequest request) throws Exception{
      Random random = new Random();
      int r= random.nextInt(11);
      // 图片上传
      // 设置图片名称，不能重复，可以使用uuid
      String e = request.getSession().getServletContext().getRealPath("");
      e = e.substring(0,e.indexOf("target"))+"src\\main\\webapp\\img\\";
      String oriName = pictureFile.getOriginalFilename();
      String extName = oriName.substring(oriName.lastIndexOf("."));
      File file = new File(e+oriName);
      if(!file.exists()){
         pictureFile.transferTo(new File(e + oriName));
      }
      String str = "/img/"+oriName;
      caiping.setImg(str);
      caiping1Ser.updateById(caiping);
      return "caipingMG/caipinglist.jsp";
   }

}
