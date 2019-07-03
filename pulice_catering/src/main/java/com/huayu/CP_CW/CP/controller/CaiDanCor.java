package com.huayu.CP_CW.CP.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huayu.CP_CW.CP.entity.CaiDanShow;
import com.huayu.CP_CW.CP.entity.Caiping;
import com.huayu.CP_CW.CP.entity.LayuiDemo;
import com.huayu.CP_CW.CP.service.CaidanShowSer;
import com.huayu.CP_CW.CP.service.Caiping1Ser;
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
@RequestMapping("caidan")
public class CaiDanCor {
   @Autowired
   private CaidanShowSer caidanShowSer;

   @Autowired
   private Caiping1Ser caiping1Ser;

   @RequestMapping(value = "querycaidan.do")
   @ResponseBody
   public LayuiDemo querytcaiping(CaiDanShow caiDanShow) {
      LayuiDemo layuiDemo=new LayuiDemo();
//      PageHelper.startPage(page,limit,true);
      List<CaiDanShow> list = caidanShowSer.querycaidanshow(caiDanShow);
      layuiDemo.setCode(0);
      layuiDemo.setMsg("");
      layuiDemo.setCount(caidanShowSer.querycaidanshow(caiDanShow).size());//传总条数  重新查询所有的条数
      layuiDemo.setData(list);
      return layuiDemo;
   }

   @RequestMapping(value = "toadd.do")
   public String toadd(Model model){
      model.addAttribute("list",caiping1Ser.list(new QueryWrapper<Caiping>()));
      return "caipingMG/addcaidan.jsp";
   }

   @RequestMapping(value = "addcaidan.do")
   public String add(@RequestParam("filename") MultipartFile pictureFile, CaiDanShow caiDanShow, HttpServletRequest request) throws Exception{
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
      caiDanShow.setCaidanimg(str);
      caidanShowSer.save(caiDanShow);
      return "redirect:/caidan/toadd.do";
   }

   @RequestMapping(value = "toupdate.do")
   public String toupdate(Model model,int id){
      model.addAttribute("list",caidanShowSer.getById(id));
      model.addAttribute("clist",caiping1Ser.list(new QueryWrapper<Caiping>()));
      return "caipingMG/tocaidan.jsp";
   }

   @RequestMapping(value = "update.do")
   public String update(@RequestParam("file") MultipartFile pictureFile, CaiDanShow caiDanShow, HttpServletRequest request)throws Exception{

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
      caiDanShow.setCaidanimg(str);
      caidanShowSer.updateById(caiDanShow);
      return "caipingMG/caidanlist.jsp";
   }
}
