package com.huayu.JC_HY_DD.reserve_tables_list.controller;

import com.github.pagehelper.PageHelper;
import com.huayu.JC_HY_DD.reserve_tables_list.entity.DataMessage;
import com.huayu.JC_HY_DD.reserve_tables_list.entity.Order_status;
import com.huayu.JC_HY_DD.reserve_tables_list.entity.Reserve_tables_list;
import com.huayu.JC_HY_DD.reserve_tables_list.service.impl.Order_statusImpl;
import com.huayu.JC_HY_DD.reserve_tables_list.service.impl.Reserve_tables_listServiceImpl;
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
@RequestMapping("/reserve_tables_list/reserve-tables-list")
public class Reserve_tables_listController {
    @Autowired
    private Order_statusImpl orderStatus;

    @Autowired
    private Reserve_tables_listServiceImpl reserveTablesList;
    @RequestMapping("/toadd.do")
    public String toadd(Model model){
        List<Order_status> list = orderStatus.list(null);
        model.addAttribute("list",list);
        return "JC_HY_DD/DD/addreserve.jsp";
    }
    @RequestMapping("/add.do")
    public String add(Reserve_tables_list reserve){
        String str = "redirect:/reserve_tables_list/reserve-tables-list/toadd.do";
        if(reserve.getQsid() == null || reserve.getQsid().equals("")){
            reserve.setQsid(101);
            str = "JC_HY_DD/gongzhonghao/order/AddOrder.jsp";
        }
        Random random = new Random();
        int r= random.nextInt(111);
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date()) + r;
        reserve.setNumber(date);
        reserveTablesList.save(reserve);
        return str;
    }

    @RequestMapping("/queryAll.do")
    @ResponseBody
    public DataMessage queryAll(Reserve_tables_list reserve_tables_list, Integer page, Integer limit) {
        DataMessage dataMessage = new DataMessage();
        dataMessage.setCode(0);
        dataMessage.setMsg("");
        dataMessage.setCount(reserveTablesList.queryAll(reserve_tables_list).size());
        PageHelper.startPage(page, limit, true);
        List<Reserve_tables_list> list = reserveTablesList.queryAll(reserve_tables_list);
        dataMessage.setData(list);
        return dataMessage;
    }

    @RequestMapping("/toupdate/{id}.do")
    public String toUpdate(@PathVariable(value = "id") int id, Model model) {
        Reserve_tables_list reserv = reserveTablesList.toUpdate(id);
        List<Order_status> list = orderStatus.list(null);
        model.addAttribute("list",list);
        model.addAttribute("res", reserv);
        return "JC_HY_DD/DD/updateres.jsp";
    }

    @RequestMapping("/delete/{id}.do")
    @ResponseBody
    public boolean delete(@PathVariable(value = "id") int id) {
        boolean b = reserveTablesList.removeById(id);
        return b;
    }

    @RequestMapping("/update.do")
    public String update(Reserve_tables_list reserve) {
        reserveTablesList.updateById(reserve);
        return "";
    }
}
