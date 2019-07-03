package com.huayu.CG_KC_SJ.purchase_audit.controller;

import com.github.pagehelper.PageHelper;
import com.huayu.CG_KC_SJ.purchase_audit.entity.Purchase_audit;
import com.huayu.CG_KC_SJ.purchase_audit.service.impl.Purchase_auditServiceImpl;
import com.huayu.CG_KC_SJ.purchase_note.entity.Purchase_note;
import com.huayu.CG_KC_SJ.purchase_note.service.impl.Purchase_noteServiceImpl;
import com.huayu.CG_KC_SJ.util.layui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@RequestMapping("/purchase_audit/purchase-audit")
public class Purchase_auditController {
    @Autowired
    private Purchase_auditServiceImpl  purchase_auditServiceImpl;
    @Autowired
   private Purchase_noteServiceImpl purchase_noteServiceImpl;
    //查询
    @RequestMapping(value = "/hekaihui1.do")
    @ResponseBody
    public layui query(Purchase_audit purchase_audit, Integer page, Integer limit){
        PageHelper.startPage(page,limit,true);
        List<Purchase_audit> raw_material_informations=purchase_auditServiceImpl.query(purchase_audit);
        layui layui =new layui();
        layui.setCode(0);
        layui.setMsg("");
        layui.setCount(purchase_auditServiceImpl.query(purchase_audit).size());
        layui.setData(raw_material_informations);
        return layui;
    }
    //去添加
    @RequestMapping(value = "/toadd.do")
    public String toadd(){
        return "CG_KC_SJ/CG/cgshenheadd.html";
    }

    //删除
    @RequestMapping(value = "/delete.do")
    @ResponseBody
    public Boolean delete(Integer id){
        return  purchase_auditServiceImpl.removeById(id);
    }

    //审核 添加采购单管理
    @RequestMapping(value = "/add.do")
    @ResponseBody
    public  Boolean add(Integer id) {
    Purchase_audit purchase_audit= purchase_auditServiceImpl.getById(id);
    System.out.println("#######"+id);
        Purchase_note purchase_note=new Purchase_note();
        purchase_note.setState(1);
        purchase_note.setUid(purchase_audit.getUid());
        purchase_note.setModel(purchase_audit.getModel());
        purchase_note.setKid(purchase_audit.getKid());
        purchase_note.setRmiid(purchase_audit.getRmiid());
        purchase_note.setData(purchase_audit.getTime());
        purchase_note.setSerial_number(purchase_audit.getSerial_number());
        purchase_note.setTotal_prices(purchase_audit.getTotal_prices());
        purchase_note.setQuantity(purchase_audit.getQuantity());
        purchase_note.setTotal_prices(purchase_audit.getTotal_prices());
        purchase_note.setWay(purchase_audit.getWay());
          // purchase_auditServiceImpl.removeById(id);
        return  purchase_noteServiceImpl.save(purchase_note);
    }


}
