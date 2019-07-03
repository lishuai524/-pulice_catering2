package com.huayu.XT.role.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huayu.XT.dao.WTChildren;
import com.huayu.XT.role.entity.*;
import com.huayu.XT.role.service.IOne_jurisdictionService;
import com.huayu.XT.role.service.IRoleService;
import com.huayu.XT.role.service.ITwo_jurisdictionService;
import com.huayu.XT.staffs.entity.Staffs;
import com.huayu.XT.staffs.service.IStaffsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-06-17
 */
@Controller
@RequestMapping("/role/role")
public class RoleController {
    @Autowired
    private IRoleService roleServiceImpl;
    @Autowired
    private IOne_jurisdictionService one_jurisdictionServiceImpl;
    @Autowired
    private ITwo_jurisdictionService two_jurisdictionServiceImpl;
    @Autowired
    private IStaffsService staffsServiceImpl;

    private String name = "";

    @RequestMapping("/queryAll.do")
    @ResponseBody
    public layui queryAll(){
        layui layui = new layui();
        layui.setCode(0);
        layui.setCount(roleServiceImpl.list(new QueryWrapper<Role>()).size());
        layui.setMsg("");
        layui.setData(roleServiceImpl.list(new QueryWrapper<Role>()));
        return layui;
    }

    @RequestMapping("/insert_role.do")
    @ResponseBody
    public boolean insert_role(@RequestBody Role role){
        name = role.getName();
        return roleServiceImpl.saveOrUpdate(role);
    }

    @RequestMapping("/insert_jurisdiction.do")
    @ResponseBody
    public boolean insert_jurisdiction(@RequestBody WTChildren wtChildren){
        for(TChildren tChildren : wtChildren.getChildren()){
            for(Two_jurisdiction two_jurisdiction : tChildren.getChildren()){
                One_jurisdiction one_jurisdiction = new One_jurisdiction();
                one_jurisdiction.setName(name);
                one_jurisdiction.setW_title(tChildren.getTitle());
                one_jurisdiction.setW_id(tChildren.getId());
                one_jurisdiction.setTid(two_jurisdiction.getId());
                one_jurisdictionServiceImpl.save(one_jurisdiction);
            }
        }
        return true;
    }

    @RequestMapping("/update_jurisdiction.do")
    @ResponseBody
    public boolean update_jurisdiction(@RequestBody WTChildren wtChildren){
        QueryWrapper<One_jurisdiction> wrapper = new QueryWrapper<>();
        wrapper.eq("name",name);
        one_jurisdictionServiceImpl.remove(wrapper);
        for(TChildren tChildren : wtChildren.getChildren()){
            for(Two_jurisdiction two_jurisdiction : tChildren.getChildren()){
                One_jurisdiction one_jurisdiction = new One_jurisdiction();
                one_jurisdiction.setName(name);
                one_jurisdiction.setW_title(tChildren.getTitle());
                one_jurisdiction.setW_id(tChildren.getId());
                one_jurisdiction.setTid(two_jurisdiction.getId());
                one_jurisdictionServiceImpl.save(one_jurisdiction);
            }
        }
        return true;
    }

    @RequestMapping("/toFenpei.do")
    public String toFenpei(Integer id, Model model){
        model.addAttribute("role",roleServiceImpl.getById(id));
        return "XT/role_management_fenpei";
    }

    @RequestMapping("/toUpdate.do")
    public String toUpdate(Integer id, Model model){
        model.addAttribute("role",roleServiceImpl.getById(id));
        return "XT/role_management_xiugai";
    }

    @RequestMapping("/toUpdateToo.do")
    @ResponseBody
    public Integer[] toUpdateToo(@RequestParam String name, Model model){
        QueryWrapper<One_jurisdiction> wrapper = new QueryWrapper<>();
        wrapper.eq("name",name);
        List<One_jurisdiction> list = one_jurisdictionServiceImpl.list(wrapper);
        Integer[] arr = new Integer[1024];
        for(int i=0;i<list.size();i++){
            arr[i] = list.get(i).getTid();
        }
        return arr;
    }

    @RequestMapping("/delete.do")
    @ResponseBody
    public boolean delete(@RequestParam Integer id){
        QueryWrapper<Staffs> wrapper = new QueryWrapper<>();
        wrapper.eq("role",roleServiceImpl.getById(id).getName());
        if(staffsServiceImpl.list(wrapper).size() > 0){
            return false;
        }
        return roleServiceImpl.removeById(id);
    }

}
