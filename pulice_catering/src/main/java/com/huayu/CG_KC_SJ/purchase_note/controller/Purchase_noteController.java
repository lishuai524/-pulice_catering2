package com.huayu.CG_KC_SJ.purchase_note.controller;

import com.github.pagehelper.PageHelper;
import com.huayu.CG_KC_SJ.procurement_plan.service.impl.Procurement_planServiceImpl;
import com.huayu.CG_KC_SJ.purchase_note.entity.Purchase_note;
import com.huayu.CG_KC_SJ.purchase_note.service.impl.Purchase_noteServiceImpl;
import com.huayu.CG_KC_SJ.raw_material_information.entity.Raw_material_information;
import com.huayu.CG_KC_SJ.stock_management.entity.Stock_management;
import com.huayu.CG_KC_SJ.stock_management.service.impl.Stock_managementServiceImpl;
import com.huayu.CG_KC_SJ.util.layui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
@RequestMapping("/purchase_note/purchase-note")
public class Purchase_noteController {
    @Autowired
    private Purchase_noteServiceImpl purchase_noteServiceImpl;

    @Autowired
    private Procurement_planServiceImpl procurement_planServiceImpl;
    @Autowired
    private Stock_managementServiceImpl stock_managementServiceImpl;
    //查询
    @RequestMapping(value = "/hekaihui1.do")
    @ResponseBody
    public layui query(Purchase_note purchase_note, Integer page, Integer limit){
        PageHelper.startPage(page,limit,true);
        List<Purchase_note> raw_material_informations=purchase_noteServiceImpl.query(purchase_note);
        layui layui =new layui();
        layui.setCode(0);
        layui.setMsg("");
        layui.setCount(purchase_noteServiceImpl.query(purchase_note).size());
        layui.setData(raw_material_informations);
        return layui;
    }
    //删除
    @RequestMapping(value = "delete.do")
    @ResponseBody
    public Boolean delete(Integer id){
        return  purchase_noteServiceImpl.removeById(id);
    }
    //入库
    @RequestMapping(value = "add.do")
    @ResponseBody
    public Boolean add(Integer id){

        DateFormat df = new SimpleDateFormat("yyyyMMddHHmm");
        Calendar calendar = Calendar.getInstance();
        String dateName = df.format(calendar.getTime());

        Purchase_note p =purchase_noteServiceImpl.getById(id);
         Raw_material_information raw_material_information= procurement_planServiceImpl.querynamea(p.getRmiid());
        Stock_management s= new Stock_management();
        s.setOdd(dateName);
        s.setKid(p.getKid());
        s.setUni_uid(p.getUid());
        s.setData(p.getData());
        s.setModel(p.getModel());
        //入库总价
        s.setTotal_prices(p.getTotal_prices());
        //采购单价
        s.setUnit_price(raw_material_information.getUnit_price());
        s.setUid(p.getQuantity());
        s.setModel(p.getModel());
        s.setRmiid(p.getRmiid());
    return  stock_managementServiceImpl.save(s);
    }


}
