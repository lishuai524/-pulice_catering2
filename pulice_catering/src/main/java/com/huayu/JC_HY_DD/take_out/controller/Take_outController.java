package com.huayu.JC_HY_DD.take_out.controller;

import com.github.pagehelper.PageHelper;
import com.huayu.JC_HY_DD.reserve_tables_list.entity.DataMessage;
import com.huayu.JC_HY_DD.take_out.entity.Take_out;
import com.huayu.JC_HY_DD.take_out.service.impl.Take_outServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-06-12
 */
@Controller
@RequestMapping("/take_out/take-out")
public class Take_outController {
    @Autowired
    private Take_outServiceImpl take_outService;

    @RequestMapping("/queryAll.do")
    @ResponseBody
    public DataMessage queryAll(Take_out takeOut, Integer page, Integer limit) {
        DataMessage dataMessage = new DataMessage();
        dataMessage.setCode(0);
        dataMessage.setMsg("");
        dataMessage.setCount(take_outService.queryAll(takeOut).size());
        PageHelper.startPage(page, limit, true);
        List<Take_out> list = take_outService.queryAll(takeOut);
        dataMessage.setData(list);
        return dataMessage;
    }

    @RequestMapping("/delete/{id}.do")
    @ResponseBody
    public boolean delete(@PathVariable(value = "id") int id) {
        boolean b = take_outService.removeById(id);
        return b;
    }

    @RequestMapping("/toupdate/{id}.do")
    public String toUpdate(@PathVariable(value = "id") int id, Model model) {
        Take_out take = take_outService.getById(id);
        model.addAttribute("take",take );
        return "JC_HY_DD/DD/updateTake.jsp";
    }

    @RequestMapping("/update.do")
    public String update(Take_out takeOut) {
        take_outService.updateById(takeOut);
        return "";
    }
}
