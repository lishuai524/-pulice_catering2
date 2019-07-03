package com.huayu.JC_HY_DD.information_desk.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.huayu.JC_HY_DD.information_desk.entity.Capacity;
import com.huayu.JC_HY_DD.information_desk.entity.Information_desk;
import com.huayu.JC_HY_DD.information_desk.entity.State_of_tables;
import com.huayu.JC_HY_DD.information_desk.entity.Zhuotaitype;
import com.huayu.JC_HY_DD.information_desk.service.impl.Information_deskServiceImpl;
import com.huayu.JC_HY_DD.information_desk.service.impl.State_of_tablesServiceImpl;
import com.huayu.JC_HY_DD.information_desk.service.impl.ZhuotaitypeServiceImpl;
import com.huayu.JC_HY_DD.information_desk.service.impl.capacityServiceImpl;
import com.huayu.JC_HY_DD.reserve_tables_list.entity.DataMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-06-12
 */
@Controller
@RequestMapping("/information_desk/information-desk")
public class Information_deskController {
    @Autowired
    public Information_deskServiceImpl deskService;

    @Autowired
    public State_of_tablesServiceImpl tablesService;

    @Autowired
    public ZhuotaitypeServiceImpl zhuotaitypeService;

    @Autowired
    public capacityServiceImpl capacitService;

    @RequestMapping("/state.do")
    @ResponseBody
    public String state() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<State_of_tables> state = tablesService.list(null);
        String test = mapper.writeValueAsString(state);
        return test;
    }
    @RequestMapping("/cap.do")
    @ResponseBody
    public String cap() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<Capacity> capacities = capacitService.list(null);
        String test = mapper.writeValueAsString(capacities);
        return test;
    }

    @RequestMapping("/queryAll.do")
    @ResponseBody
    public DataMessage queryAll(Information_desk desk, Integer page, Integer limit) {
        DataMessage dataMessage = new DataMessage();
        dataMessage.setCode(0);
        dataMessage.setMsg("");
        dataMessage.setCount(deskService.queryAll(desk).size());
        PageHelper.startPage(page, limit, true);
        List<Information_desk> list = deskService.queryAll(desk);
        dataMessage.setData(list);
        return dataMessage;
    }
    @RequestMapping("/toAdd.do")
    public String toAdd(Model model){
        List<State_of_tables> state = tablesService.list(null);
        List<Zhuotaitype> list = zhuotaitypeService.list(null);
        List<Capacity> capacities = capacitService.list(null);
        model.addAttribute("list",state);
        model.addAttribute("type",list);
        model.addAttribute("cap",capacities);
        return "JC_HY_DD/JC/addTables.jsp";
    }

    @RequestMapping("/add.do")
    public String add(Information_desk desk){
        Random random = new Random();
        int r= random.nextInt(111);
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date()) + r;
        desk.setNumber(date);
        deskService.save(desk);
        return "redirect:/information_desk/information-desk/toAdd.do";
    }

    @RequestMapping("/delete/{id}.do")
    @ResponseBody
    public boolean delete(@PathVariable(value = "id") int id) {
        boolean b = deskService.removeById(id);
        return b;
    }

    @RequestMapping("/toupdate/{id}.do")
    public String toUpdate(@PathVariable(value = "id") int id, Model model) {
        List<State_of_tables> list = tablesService.list(null);
        List<Zhuotaitype> zhuotaitypes = zhuotaitypeService.list(null);
        List<Capacity> capacities = capacitService.list(null);
        Information_desk reserv = deskService.toUpdate(id);
        model.addAttribute("list",list);
        model.addAttribute("type",zhuotaitypes);
        model.addAttribute("inf", reserv);
        model.addAttribute("cap", capacities);
        return "JC_HY_DD/JC/updateTables.jsp";
    }

    @RequestMapping("/update.do")
    public String update(Information_desk desk){
        deskService.updateById(desk);
        return "";
    }
}
