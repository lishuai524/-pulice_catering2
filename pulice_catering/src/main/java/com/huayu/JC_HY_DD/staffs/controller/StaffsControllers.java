package com.huayu.JC_HY_DD.staffs.controller;

import com.huayu.JC_HY_DD.staffs.entity.Staffs;
import com.huayu.JC_HY_DD.staffs.service.impl.StaffsServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-06-12
 */
@Controller
@RequestMapping("/staffs/staffs")
public class StaffsControllers {
    @Autowired
    private StaffsServiceImpls staffsService;


    @RequestMapping("/queryByid.do")
    public String queryAll(Model model) {
        Staffs list = staffsService.queryByid(1001);
        model.addAttribute("list",list);
        return "JC_HY_DD/JC/person.jsp";
    }

    @RequestMapping("/update.do")
    public String update(@RequestParam("filename") MultipartFile pictureFile,Staffs staffs, HttpServletRequest request) throws IOException {
        String str ="";

        if(pictureFile.isEmpty()){
            String tpurl = staffsService.queryBytp(1001);
            str=tpurl;
        }else {
            String e = request.getSession().getServletContext().getRealPath("");
            e = e.substring(0, e.indexOf("target")) + "src\\main\\webapp\\img\\";
            String oriName = pictureFile.getOriginalFilename();
            File file = new File(e + oriName);
            if (!file.exists()) {
                pictureFile.transferTo(new File(e + oriName));
            }
            str = "/img/" + oriName;
        }
        staffs.setHead_portrait(str);
        staffsService.updateById(staffs);
        return "redirect:/staffs/staffs/queryByid.do";
    }
    @RequestMapping("/updatepwd.do")
    @ResponseBody
    public String updatepwd(String pwd,String xpwd) {
        String psd = staffsService.querypwd(1001);
        Staffs staffs = new Staffs();
        staffs.setPsd(xpwd);
        staffs.setJob_number("1001");
        if(pwd !=null && xpwd != null){
            if(psd.equals(pwd)){
                staffsService.updatepwd(staffs);
                return "true";
            }else {
                return "false";
            }
        }
        return "......";
    }
}
