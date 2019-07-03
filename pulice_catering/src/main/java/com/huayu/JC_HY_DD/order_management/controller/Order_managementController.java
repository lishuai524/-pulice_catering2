package com.huayu.JC_HY_DD.order_management.controller;

import com.github.pagehelper.PageHelper;
import com.huayu.JC_HY_DD.order_management.entity.Order_management;
import com.huayu.JC_HY_DD.order_management.service.impl.Order_managementServiceImpl;
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
@RequestMapping("/order_management/order-management")
public class Order_managementController {
    @Autowired
    private Order_managementServiceImpl orderManagementService;

    @RequestMapping("/queryAll.do")
    @ResponseBody
    public DataMessage queryAll(Order_management management, Integer page, Integer limit) {
        DataMessage dataMessage = new DataMessage();
        dataMessage.setCode(0);
        dataMessage.setMsg("");
        dataMessage.setCount(orderManagementService.queryAll(management).size());
        PageHelper.startPage(page, limit, true);
        List<Order_management> list = orderManagementService.queryAll(management);
        dataMessage.setData(list);
        return dataMessage;
    }

    @RequestMapping("/delete/{id}.do")
    @ResponseBody
    public boolean delete(@PathVariable(value = "id") int id) {
        boolean b = orderManagementService.removeById(id);
        return b;
    }

    @RequestMapping("/toupdate/{id}.do")
    public String toUpdate(@PathVariable(value = "id") int id, Model model) {
        Order_management management = orderManagementService.getById(id);
        model.addAttribute("manag",management );
        return "JC_HY_DD/DD/updateBill.jsp";
    }

    @RequestMapping("/update.do")
    public String update(Order_management management) {
        orderManagementService.updateById(management);
        return "";
    }
}
