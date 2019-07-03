//package com.huayu.JC_HY_DD.tangkou_information.controller;
//
//import com.github.pagehelper.PageHelper;
//import com.huayu.CP_CW.food_category.entity.Food_category;
//import com.huayu.CP_CW.food_category.service.impl.Food_categoryServiceImpl;
//import com.huayu.JC_HY_DD.queuing_management.entity.DataMessage;
//import com.huayu.JC_HY_DD.tangkou_information.entity.Tangkou_information;
//import com.huayu.JC_HY_DD.tangkou_information.service.impl.Tangkou_informationServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.List;
//
///**
// * <p>
// *  前端控制器
// * </p>
// *
// * @author jobob
// * @since 2019-06-12
// */
//@Controller
//@RequestMapping("/tangkou_information/tangkou-information")
//public class Tangkou_informationController {
//    @Autowired
//    private Food_categoryServiceImpl categoryService;
//
//    @Autowired
//    private Tangkou_informationServiceImpl informationService;
//
//    @RequestMapping("/toquery.do")
//    public String toquery(Model model){
//        List<Food_category> list = categoryService.list(null);
//        model.addAttribute("list",list);
//        return "JC_HY_DD/JC/TangKou.jsp";
//    }
//
//    @RequestMapping("/toadd.do")
//    public String toadd(Model model){
//        List<Food_category> list = categoryService.list(null);
//        model.addAttribute("list",list);
//        return "JC_HY_DD/JC/addTangKou.jsp";
//    }
//
//    @RequestMapping("/queryfood.do")
//    @ResponseBody
//    public DataMessage queryFood() {
//        DataMessage dataMessage = new DataMessage();
//        dataMessage.setCode(0);
//        dataMessage.setMsg("");
//        dataMessage.setCount(categoryService.list(null).size());
//        List<Food_category> list = categoryService.list(null);
//        dataMessage.setData(list);
//        return dataMessage;
//    }
//
//    @RequestMapping("/queryAll.do")
//    @ResponseBody
//    public DataMessage queryAll(Tangkou_information information ,Integer page, Integer limit) {
//        DataMessage dataMessage = new DataMessage();
//        dataMessage.setCode(0);
//        dataMessage.setMsg("");
//        dataMessage.setCount(informationService.queryAll(information).size());
//        PageHelper.startPage(page, limit, true);
//        List<Tangkou_information> list = informationService.queryAll(information);
//        dataMessage.setData(list);
//        return dataMessage;
//    }
//
//    @RequestMapping("/delete/{id}.do")
//    @ResponseBody
//    public boolean delete(@PathVariable(value = "id") int id) {
//        boolean b = informationService.removeById(id);
//        return b;
//    }
//
//    @RequestMapping("/add.do")
//    public String add(Tangkou_information tangkou){
//        informationService.save(tangkou);
//        return "redirect:/tangkou_information/tangkou-information/toadd.do";
//    }
//
//    @RequestMapping("/toupdate/{id}.do")
//    public String toUpdate(@PathVariable(value = "id") int id, Model model) {
//        Tangkou_information tangkou = informationService.toupdate(id);
//        List<Food_category> list = categoryService.list(null);
//        model.addAttribute("list",list);
//        model.addAttribute("tang", tangkou);
//        return "JC_HY_DD/JC/updateTangKou.jsp";
//    }
//
//    @RequestMapping("/update.do")
//    public String update(Tangkou_information information){
//        informationService.updateById(information);
//        return "";
//    }
//
//}
