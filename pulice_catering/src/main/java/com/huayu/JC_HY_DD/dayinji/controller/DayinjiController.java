package com.huayu.JC_HY_DD.dayinji.controller;

import com.github.pagehelper.PageHelper;
import com.huayu.JC_HY_DD.dayinji.entity.Dayinji;
import com.huayu.JC_HY_DD.dayinji.service.impl.DayinjiServiceImpl;
import com.huayu.JC_HY_DD.reserve_tables_list.entity.DataMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-06-12
 */
@Controller
@RequestMapping("/dayinji/dayinji")
public class DayinjiController {
    @Autowired
    private DayinjiServiceImpl dayinjiService;

    @RequestMapping("/queryAll.do")
    @ResponseBody
    public DataMessage queryAll(Dayinji dayinji, Integer page, Integer limit) {
        DataMessage dataMessage = new DataMessage();
        dataMessage.setCode(0);
        dataMessage.setMsg("");
        dataMessage.setCount(dayinjiService.queryAll(dayinji).size());
        PageHelper.startPage(page, limit, true);
        List<Dayinji> list = dayinjiService.queryAll(dayinji);
        dataMessage.setData(list);
        return dataMessage;
    }

    @RequestMapping("/delete/{id}.do")
    @ResponseBody
    public boolean delete(@PathVariable(value = "id") int id) {
        boolean b = dayinjiService.removeById(id);
        return b;
    }

    @RequestMapping("/add.do")
    public String add(Dayinji dayinji){
        dayinjiService.save(dayinji);
        return "JC_HY_DD/JC/addDayinji.jsp";
    }

    @RequestMapping("/toupdate/{id}.do")
    public String toUpdate(@PathVariable(value = "id") int id, Model model) {
        Dayinji dayinji = dayinjiService.toupdate(id);
        model.addAttribute("dayin", dayinji);
        return "JC_HY_DD/JC/updateDayinji.jsp";
    }

    @RequestMapping("/update.do")
    public String update(Dayinji dayinji){
        dayinjiService.updateById(dayinji);
        return "";
    }
}
