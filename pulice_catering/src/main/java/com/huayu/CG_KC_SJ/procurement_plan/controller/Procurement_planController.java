package com.huayu.CG_KC_SJ.procurement_plan.controller;

import com.github.pagehelper.PageHelper;
import com.huayu.CG_KC_SJ.procurement_plan.entity.Procurement_plan;
import com.huayu.CG_KC_SJ.procurement_plan.service.impl.Procurement_planServiceImpl;
import com.huayu.CG_KC_SJ.purchase_audit.entity.Purchase_audit;
import com.huayu.CG_KC_SJ.purchase_audit.service.impl.Purchase_auditServiceImpl;
import com.huayu.CG_KC_SJ.raw_material_information.entity.Raw_material_information;
import com.huayu.CG_KC_SJ.util.layui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
@RequestMapping("/procurement_plan/procurement-plan")
public class Procurement_planController {

@Autowired
private Procurement_planServiceImpl procurement_planServiceImpl;
@Autowired
private Purchase_auditServiceImpl purchase_auditServiceImpl;
    //查询
    @RequestMapping(value = "/hekaihui1.do")
    @ResponseBody
    public layui query(Procurement_plan procurement_plan, Integer page, Integer limit){
        PageHelper.startPage(page,limit,true);
        List<Procurement_plan> raw_material_informations=procurement_planServiceImpl.query(procurement_plan);
        layui layui =new layui();
        layui.setCode(0);
        layui.setMsg("");
        layui.setCount(procurement_planServiceImpl.query(procurement_plan).size());
        layui.setData(raw_material_informations);
        return layui;
    }
    //删除
    @RequestMapping(value = "/delete.do")
    @ResponseBody
    public  Boolean delete(Integer id) {
        return   procurement_planServiceImpl.removeById(id);
    }
    //采购
    @RequestMapping(value = "/add.do")
    @ResponseBody
    public  Boolean add(Integer id) {

       //采购编号
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmm");
        Calendar calendar = Calendar.getInstance();
        String dateName = df.format(calendar.getTime());

        Random ne=new Random();//实例化一个random的对象ne
        int x = ne.nextInt(999-100+1)+100;//为变量赋随机值100-999
        String random_order = String.valueOf(x);
        String order_id = dateName+random_order;

        Procurement_plan p=  procurement_planServiceImpl.getById(id);

        Raw_material_information raw_material_information= procurement_planServiceImpl.querynamea(p.getRmiid());
        Purchase_audit a =new Purchase_audit();
         a.setSerial_number(order_id);
         a.setTime(p.getTime());
         a.setRmiid(p.getRmiid());
         a.setKid(p.getKid());
         a.setModel(raw_material_information.getModel());
         a.setQuantity(p.getSuggest());
         a.setUid(p.getUid());
         a.setTotal_prices(  raw_material_information.getUnit_price()* p.getSuggest());

       //  procurement_planServiceImpl.removeById(id);
        return  purchase_auditServiceImpl.save(a);
    }


}
