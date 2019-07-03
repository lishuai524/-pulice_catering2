package com.huayu.XT.staffs.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huayu.XT.role.entity.Role;
import com.huayu.XT.role.entity.layui;
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
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-06-19
 */
@Controller
@RequestMapping("/staffs/staffs")
public class StaffsController {
    @Autowired
    private IStaffsService staffsServiceImpl;
    @Autowired
    private IRoleService roleServiceImpl;
    @Autowired
    private IOne_jurisdictionService one_jurisdictionServiceImpl;
    @Autowired
    private ITwo_jurisdictionService two_jurisdictionServiceImpl;

    @RequestMapping(value = "/login.do")
    public String login(Staffs staffs, HttpSession httpSession) throws Exception{
        //验证账号密码
        QueryWrapper<Staffs> wrapper = new QueryWrapper<>();
        wrapper.eq("login",staffs.getLogin());
        wrapper.eq("psd",staffs.getPsd());
        httpSession.setAttribute("user",staffsServiceImpl.getOne(wrapper));
      /*  //根据员工工号查询出该员工的所有的角色
        QueryWrapper<Staffs> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("job_number",staffsServiceImpl.getOne(wrapper).getJob_number());
        Integer max = 0;//标记最高权限
        String roleName = "";//标记最高权限的角色名
        //根据角色查询出该员工的最高权限
        for(Staffs staffs1 : staffsServiceImpl.list(wrapper1)){
            Integer m = 0;
            QueryWrapper<One_jurisdiction> wrapper2 = new QueryWrapper<>();
            wrapper2.eq("name",staffs1.getRole());
            m = one_jurisdictionServiceImpl.list(wrapper2).size();
            if(m > max){
                max = m;
                roleName = staffs1.getRole();
            }
        }
        //查询出最高权限下的权限
        QueryWrapper<One_jurisdiction> wrapper2 = new QueryWrapper<>();
        wrapper2.eq("name",roleName);
        List<String> list = new ArrayList<>();
        for(One_jurisdiction one_jurisdiction : one_jurisdictionServiceImpl.list(wrapper2)){
            QueryWrapper<Two_jurisdiction> wrapper3 = new QueryWrapper<>();
            wrapper3.eq("id",one_jurisdiction.getTid());
            list.add(two_jurisdictionServiceImpl.getOne(wrapper3).getHref());
        }
        httpSession.setAttribute("twoList",list);*/

        if(null == staffsServiceImpl.getOne(wrapper)){
            return "login";
        }
        return "index";
    }

    @RequestMapping("/queryAllByRole.do")
    @ResponseBody
    public layui queryAllByRole(String role){
        QueryWrapper<Staffs> wrapper = new QueryWrapper<>();
        wrapper.eq("role",role);
        layui layui = new layui();
        layui.setCode(0);
        layui.setCount(staffsServiceImpl.list(wrapper).size());
        layui.setMsg("");
        layui.setData(staffsServiceImpl.list(wrapper));
        return layui;
    }

    private String staffsRole = "";
    @RequestMapping("/toInsert.do")
    public String toInsert(Model model,String role,String department){
        staffsRole = role;
        QueryWrapper<Staffs> wrapperNname = new QueryWrapper<>();
        wrapperNname.eq("role",role);
        model.addAttribute("roleList",staffsServiceImpl.list(wrapperNname));
        return "XT/role_management_jiaose";
    }

    private List<Staffs> list;
    @RequestMapping("/queryByDepartment.do")
    @ResponseBody
    public List<Staffs> queryByDepartment(@RequestParam String department){
        QueryWrapper<Staffs> wrapperDepartment = new QueryWrapper<>();
        wrapperDepartment.eq("department",department);
        wrapperDepartment.ne("role",staffsRole);
        list = staffsServiceImpl.list(wrapperDepartment);
        return staffsServiceImpl.list(wrapperDepartment);
    }

    @RequestMapping("/updateByRole.do")
    @ResponseBody
    public boolean updateByRole(Integer[] arr){
        boolean folag = false;
        for(int i=0;i<arr.length;i++){
            Staffs staffs = staffsServiceImpl.getById(arr[i]);
            staffs.setRole(list.get(0).getRole());
            staffs.setDepartment(list.get(0).getDepartment());
            folag = staffsServiceImpl.save(staffs);
        }
        return folag;
    }

    @RequestMapping("/deleteById.do")
    @ResponseBody
    public boolean deleteById(@RequestParam Integer id){
        String job_number = staffsServiceImpl.getById(id).getJob_number();
        QueryWrapper<Staffs> wrapper = new QueryWrapper<>();
        wrapper.eq("job_number",job_number);
        if(staffsServiceImpl.list(wrapper).size() <= 1){
            return false;
        }
        return staffsServiceImpl.removeById(id);
    }

    @RequestMapping("/queryAll.do")
    @ResponseBody
    public layui queryAll(){
        layui layui = new layui();
        layui.setCode(0);
        layui.setCount(staffsServiceImpl.list(new QueryWrapper<Staffs>()).size());
        layui.setMsg("");
        layui.setData(staffsServiceImpl.list(new QueryWrapper<Staffs>()));
        return layui;
    }

    @RequestMapping("/queryByDepartmentToo.do")
    @ResponseBody
    public layui queryByDepartmentToo(@RequestParam String department){
        QueryWrapper<Staffs> wrapper = new QueryWrapper<>();
        wrapper.eq("department",department);
        layui layui = new layui();
        layui.setCode(0);
        layui.setCount(staffsServiceImpl.list(wrapper).size());
        layui.setMsg("");
        layui.setData(staffsServiceImpl.list(wrapper));
        return layui;
    }

    @RequestMapping("/queryByForm.do")
    @ResponseBody
    public layui queryByForm(String company, String login, String department, String name){
        QueryWrapper<Staffs> wrapper = new QueryWrapper<>();
        if(null != company && !"".equals(company)){
            wrapper.eq("company",company);
        }
        if(null != login && !"".equals(login)){
            wrapper.eq("login",login);
        }
        if(null != department && !"".equals(department)){
            wrapper.eq("department",department);
        }
        if(null != name && !"".equals(name)){
            wrapper.eq("name",name);
        }
        layui layui = new layui();
        layui.setCode(0);
        layui.setCount(staffsServiceImpl.list(wrapper).size());
        layui.setMsg("");
        layui.setData(staffsServiceImpl.list(wrapper));
        return layui;
    }

    @RequestMapping("/toInsert_staffs.do")
    public String toInsert_staffs(Model model){
        model.addAttribute("roleList", roleServiceImpl.list(new QueryWrapper<Role>()));
        return "XT/staffs_tianjia";
    }

    @RequestMapping("/insert_staffs.do")
    @ResponseBody
    public boolean insert_staffs(@RequestBody Staffs staffs){
        boolean falge = false;
        String[] roleArr = staffs.getRole().split(",");
        for(int i=0;i<roleArr.length;i++){
            staffs.setRole(roleArr[i]);
            QueryWrapper<Role> wrapper = new QueryWrapper<>();
            wrapper.eq("name",roleArr[i]);
            staffs.setDepartment(roleServiceImpl.getOne(wrapper).getDepartment());
            falge = staffsServiceImpl.save(staffs);
        }
        return falge;
    }

    @RequestMapping("/toUpdate.do")
    public String toUpdate(Integer id, Model model){
        model.addAttribute("staffs",staffsServiceImpl.getById(id));
        model.addAttribute("roleList", roleServiceImpl.list(new QueryWrapper<Role>()));
        return "XT/staffs_xiugai";
    }

    @RequestMapping("/update_staffs.do")
    @ResponseBody
    public boolean update_staffs(@RequestBody Staffs staffs){
        QueryWrapper<Staffs> wrapper = new QueryWrapper<>();
        wrapper.eq("job_number",staffs.getJob_number());
        return staffsServiceImpl.update(staffs,wrapper);
    }

    @RequestMapping("/delete.do")
    @ResponseBody
    public boolean delete(@RequestParam Integer id){
        return roleServiceImpl.removeById(id);
    }

    @RequestMapping("/queryById.do")
    @ResponseBody
    public Staffs queryById(@RequestParam Integer id){
        return staffsServiceImpl.getById(id);
    }

    @RequestMapping("/fileuploadExecl.do")
    @ResponseBody
    public Map<String,Object> fileuploadExecl(@RequestParam("file") MultipartFile pictureFile){
        Map<String,Object> hashMap = new HashMap<>();
        try {
            // 图片上传
            // 设置图片名称，不能重复，可以使用uuid
            String picName = UUID.randomUUID().toString();
            // 获取文件名
            String oriName = pictureFile.getOriginalFilename();
            // 获取图片后缀
            String extName = oriName.substring(oriName.lastIndexOf("."));
            //获取tomcat地址
            String workPath = System.getProperty("user.dir");
            workPath = workPath.substring(0,workPath.indexOf("bin"))+"webapps\\img\\";
            // 开始上传
            pictureFile.transferTo(new File(workPath + picName + extName));
            hashMap.put("url","/img/" + picName + extName);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return hashMap;
    }
}
