package com.huayu.JC_HY_DD.queue.controller;

import com.github.pagehelper.PageHelper;
import com.huayu.JC_HY_DD.information_desk.entity.Capacity;
import com.huayu.JC_HY_DD.information_desk.service.impl.capacityServiceImpl;
import com.huayu.JC_HY_DD.queue.entity.Queue;
import com.huayu.JC_HY_DD.queue.service.impl.QueueServiceImpl;
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

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-06-12
 */
@Controller
@RequestMapping("/queue/queue")
public class QueueController {
    @Autowired
    private QueueServiceImpl queueService;

    @Autowired
    public capacityServiceImpl capacitService;

    @RequestMapping("/queryAll.do")
    @ResponseBody
    public DataMessage queryAll(Queue queue, Integer page, Integer limit) {
        DataMessage dataMessage = new DataMessage();
        dataMessage.setCode(0);
        dataMessage.setMsg("");
        dataMessage.setCount(queueService.queryAll(queue).size());
        PageHelper.startPage(page, limit, true);
        List<Queue> list = queueService.queryAll(queue);
        dataMessage.setData(list);
        return dataMessage;
    }

    @RequestMapping("/toadd.do")
    public String toadd(Model model){
        List<Capacity> capacities = capacitService.list(null);
        model.addAttribute("cap",capacities);
        return "JC_HY_DD/JC/addQueue.jsp";
    }
    @RequestMapping("/add.do")
    public String add(Queue queue){
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data = df.format(date);
        queue.setUpdate_data(data);
        queueService.save(queue);
        return "redirect:/queue/queue/toadd.do";
    }

    @RequestMapping("/delete/{id}.do")
    @ResponseBody
    public boolean delete(@PathVariable(value = "id") int id) {
        boolean b = queueService.removeById(id);
        return b;
    }

    @RequestMapping("/toupdate/{id}.do")
    public String toUpdate(@PathVariable(value = "id") int id, Model model) {
        List<Capacity> capacities = capacitService.list(null);
        Queue queue = queueService.toupdate(id);
        model.addAttribute("que", queue);
        model.addAttribute("cap", capacities);
        return "JC_HY_DD/JC/updateQueue.jsp";
    }

    @RequestMapping("/update.do")
    public String update(Queue queue){
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data = df.format(date);
        queue.setUpdate_data(data);
        queueService.updateById(queue);
        return "";
    }

}
