package com.huayu.CG_KC_SJ.raw_material_information.controller;

import com.github.pagehelper.PageHelper;
import com.huayu.CG_KC_SJ.kind.service.kind_service;
import com.huayu.CG_KC_SJ.raw_material_information.entity.Raw_material_information;
import com.huayu.CG_KC_SJ.raw_material_information.service.impl.Raw_material_informationServiceImpl;
import com.huayu.CG_KC_SJ.util.layui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
 * @since 2019-06-12
 */
@Controller
@RequestMapping("/raw_material_information/raw-material-information")
public class Raw_material_informationController{

    @Autowired
   private Raw_material_informationServiceImpl raw_material_informationServiceImpl;
  @Autowired
     private kind_service kind_service;
  @Autowired
  private com.huayu.CG_KC_SJ.unit.service.unit_service unit_service;




    /**
     * 查询
     * @param raw_material_information
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping(value = "/hekaihui.do")
    @ResponseBody
    public layui query(Raw_material_information raw_material_information,Integer page,Integer limit){
        PageHelper.startPage(page,limit,true);
        List<Raw_material_information> raw_material_informations=raw_material_informationServiceImpl.query(raw_material_information);
        layui layui =new layui();
        layui.setCode(0);
        layui.setMsg("");
        layui.setCount(raw_material_informationServiceImpl.query(raw_material_information).size());
        layui.setData(raw_material_informations);
        return layui;
    }
   //去添加
    @RequestMapping(value = "/toadd.do")
    public String toadd(Model model){
        model.addAttribute("tolist",kind_service.query());
        model.addAttribute("list",unit_service.query());
        return "CG_KC_SJ/CG/cladd.html";
    }
    //添加
@RequestMapping(value = "/add.do")
@ResponseBody
    public  Boolean add(@RequestBody Raw_material_information raw_material_information){
        return  raw_material_informationServiceImpl.save(raw_material_information);
    }

    //去修改
   @RequestMapping(value = "/toupdate.do")
    public  String toupdate(Model model, Integer rmiid){
     model.addAttribute("list1",raw_material_informationServiceImpl.getById(rmiid));
        model.addAttribute("list2", kind_service.query());
        model.addAttribute("list3", unit_service.query());
        return "CG_KC_SJ/CG/clupdate.html";
    }
    //修改
    @RequestMapping(value = "/update.do")
    @ResponseBody
    public Boolean update(@RequestBody Raw_material_information raw_material_information){
        return raw_material_informationServiceImpl.updateById(raw_material_information);
    }

    //删除
    @RequestMapping(value = "/delete.do")
    @ResponseBody
    public  Boolean delete(Integer rmiid) {
        return   raw_material_informationServiceImpl.removeById(rmiid);
    }






    @ResponseBody
    @RequestMapping("/deletePicture.do")
    public boolean deletePicture(String file){
        //取得当前主机存放项目的绝对路径
        String workPath = System.getProperty("user.dir");
        workPath = workPath.substring(0, workPath.indexOf("bin"))+"webapps/ROOT"+file;
        return new File(workPath).delete();
    }




    /**
     * 图片上传
     * @param pictureFile
     */
    @ResponseBody
    @RequestMapping("/fileuploadExecl.do")
    public Map<String, Object> fileuploadExecl(@RequestParam("file") MultipartFile pictureFile){
        Map<String, Object> hashMap = null;
        try {
            // 图片上传
// 设置图片名称，不能重复，可以使用uuid
            String picName = UUID.randomUUID().toString();
// 获取文件名
            String oriName = pictureFile.getOriginalFilename();
// 获取图片后缀
            String extName = oriName.substring(oriName.lastIndexOf("."));

            //取得当前主机存放项目的绝对路径
            String workPath = System.getProperty("user.dir");
            workPath = workPath.substring(0, workPath.indexOf("bin"))+"webapps/imageUpload";
// 开始上传
            File path = new File(workPath+"/png/" + picName + extName);
                pictureFile.transferTo(path);
            hashMap = new HashMap<String, Object>();
            String uploadPath = "/imageUpload/png/"+picName + extName;
            hashMap.put("url",uploadPath);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return hashMap;
    }

    @RequestMapping(value = "/hekaihui1.do")
    public String query(Model model ){
        model.addAttribute("tolist",kind_service.query());
        return "CG_KC_SJ/CG/cailiao.html";
    }


}
