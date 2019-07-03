package com.huayu.JC_HY_DD.member_management.controller;

import com.github.pagehelper.PageHelper;
import com.huayu.JC_HY_DD.member_management.entity.DataMessage;
import com.huayu.JC_HY_DD.member_management.entity.Member_management;
import com.huayu.JC_HY_DD.member_management.service.impl.Member_managementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-06-12
 */
@Controller
@RequestMapping("/member_management/member-management")
public class Member_managementController {
    @Autowired
    private Member_managementServiceImpl managementService;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping("/queryVip.do")
    @ResponseBody
    public DataMessage queryAll(Member_management management, Integer page, Integer limit) {
        DataMessage dataMessage = new DataMessage();
        dataMessage.setCode(0);
        dataMessage.setMsg("");
        dataMessage.setCount(managementService.queryAll(management).size());
        PageHelper.startPage(page,limit,true);
        List<Member_management> list = managementService.queryAll(management);
        dataMessage.setData(list);
        return dataMessage;
    }

    @RequestMapping("/delete/{id}.do")
    @ResponseBody
    public boolean delete(@PathVariable(value = "id") int id) {
        boolean b = managementService.removeById(id);
        return b;
    }

    @RequestMapping("/add.do")
    public String add(@RequestParam("filename") MultipartFile pictureFile, Member_management management) throws IOException {
//        Random random = new Random();
//        int r= random.nextInt(111);
//        String picName = new SimpleDateFormat("yyyyMMdd").format(new Date()) + r;
        String e = request.getSession().getServletContext().getRealPath("");
        e = e.substring(0,e.indexOf("target"))+"src\\main\\webapp\\img\\";
        String oriName = pictureFile.getOriginalFilename();
        File file =
                new File(e+oriName);
        if(!file.exists()){
            pictureFile.transferTo(new File(e + oriName));
        }
        String str = "/img/"+oriName;
        management.setHead_portrait(str);

        managementService.save(management);
        return "JC_HY_DD/HY/addvip.jsp";
    }

    @RequestMapping("/toupdate/{id}.do")
    public String toUpdate(@PathVariable(value = "id") int id, Model model) {
        Member_management management = managementService.getById(id);
        model.addAttribute("member", management);
        return "JC_HY_DD/HY/update.jsp";
    }

    @RequestMapping("/update.do")
    public String update(@RequestParam("filename") MultipartFile pictureFile,Member_management management) throws IOException {
        String str ="";

        if(pictureFile.isEmpty()){
            String tpurl = managementService.queryBytp(management.getId());
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
        management.setHead_portrait(str);
        managementService.updateById(management);
        return "JC_HY_DD/HY/vip.jsp";
    }


}
