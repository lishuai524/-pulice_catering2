package com.huayu.JC_HY_DD.queuing_management.controller;

import com.github.pagehelper.PageHelper;
import com.huayu.JC_HY_DD.information_desk.entity.Capacity;
import com.huayu.JC_HY_DD.information_desk.entity.Zhuotaitype;
import com.huayu.JC_HY_DD.information_desk.service.impl.ZhuotaitypeServiceImpl;
import com.huayu.JC_HY_DD.information_desk.service.impl.capacityServiceImpl;
import com.huayu.JC_HY_DD.queue.entity.Queue;
import com.huayu.JC_HY_DD.queue.service.impl.QueueServiceImpl;
import com.huayu.JC_HY_DD.queue_state.entity.Queue_state;
import com.huayu.JC_HY_DD.queue_state.service.impl.Queue_stateServiceImpl;
import com.huayu.JC_HY_DD.queuing_management.entity.Queuing_management;
import com.huayu.JC_HY_DD.queuing_management.service.impl.Queuing_managementServiceImpl;
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
@RequestMapping("/queuing_management/queuing-management")
public class Queuing_managementController {
    @Autowired
    private Queuing_managementServiceImpl managementService;

    @Autowired
    public ZhuotaitypeServiceImpl zhuotaitypeService;

    @Autowired
    public capacityServiceImpl capacitService;

    @Autowired
    private QueueServiceImpl queueService;

    @Autowired
    private Queue_stateServiceImpl stateService;


    @RequestMapping("/queryAll.do")
    @ResponseBody
    public DataMessage queryAll(Queuing_management queue, Integer page, Integer limit) {
        DataMessage dataMessage = new DataMessage();
        dataMessage.setCode(0);
        dataMessage.setMsg("");
        dataMessage.setCount(managementService.queryAll(queue).size());
        PageHelper.startPage(page, limit, true);
        List<Queuing_management> list = managementService.queryAll(queue);
        dataMessage.setData(list);
        return dataMessage;
    }

    @RequestMapping("/toadd.do")
    public String toadd(Model model){
        List<Capacity> capacities = capacitService.list(null);
        List<Zhuotaitype> list = zhuotaitypeService.list(null);
        List<Queue> que = queueService.query();
        List<Queue_state> queue_states = stateService.list(null);
        model.addAttribute("cap",capacities);
        model.addAttribute("type",list);
        model.addAttribute("que",que);
        model.addAttribute("state",queue_states);
        return "JC_HY_DD/JC/addpaidui.jsp";
    }
    @RequestMapping("/add.do")
    public String add(Queuing_management management){
        int i =(int)((Math.random()*9+1)*10000);
        String s = String.valueOf(i);
        management.setNumber(s);
        managementService.save(management);
        return "redirect:/queuing_management/queuing-management/toadd.do";
    }

    @RequestMapping("/delete/{id}.do")
    @ResponseBody
    public boolean delete(@PathVariable(value = "id") int id) {
        boolean b = managementService.removeById(id);
        return b;
    }

    @RequestMapping("/toupdate/{id}.do")
    public String toupdate(@PathVariable(value = "id") int id,Model model){
        List<Capacity> capacities = capacitService.list(null);
        List<Zhuotaitype> list = zhuotaitypeService.list(null);
        List<Queue> que = queueService.query();
        List<Queue_state> queue_states = stateService.list(null);
        Queuing_management queryByid = managementService.toupdate(id);
        model.addAttribute("cap",capacities);
        model.addAttribute("type",list);
        model.addAttribute("que",que);
        model.addAttribute("state",queue_states);
        model.addAttribute("byid",queryByid);
        return "JC_HY_DD/JC/updatepaidui.jsp";
    }

    @RequestMapping("/update.do")
    public String update(Queuing_management management){
        managementService.updateById(management);
        return "";
    }

}
