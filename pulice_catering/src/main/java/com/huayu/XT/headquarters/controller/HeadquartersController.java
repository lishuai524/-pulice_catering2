package com.huayu.XT.headquarters.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.huayu.XT.headquarters.entity.Headquarters;
import com.huayu.XT.headquarters.service.IHeadquartersService;
import com.huayu.XT.role.entity.layui;
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

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-06-25
 */
@Controller
@RequestMapping("/headquarters/headquarters")
public class HeadquartersController {
    @Autowired
    private IStaffsService staffsServiceImpl;
    @Autowired
    private IHeadquartersService headquartersServiceImpl;

    @RequestMapping("/queryAll.do")
    @ResponseBody
    public layui queryAll(){
        layui layui = new layui();
        layui.setCode(0);
        layui.setCount(headquartersServiceImpl.list(new QueryWrapper<Headquarters>()).size());
        layui.setMsg("");
        layui.setData(headquartersServiceImpl.list(new QueryWrapper<Headquarters>()));
        return layui;
    }

    @RequestMapping("/toInsert_headquarters.do")
    public String toInsert_headquarters(Model model){
        model.addAttribute("staffsList", staffsServiceImpl.list(new QueryWrapper<Staffs>()));
        return "XT/headquarters_tianjia";
    }

    @RequestMapping("/insert_headquarters.do")
    public String insert_headquarters(@RequestParam("file") MultipartFile pictureFile,Headquarters headquarters) throws JsonProcessingException, WriterException {
        //生成当前时间
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        headquarters.setDate_changed(df.format(date));

        ObjectMapper mapper = new ObjectMapper();
        String text = mapper.writeValueAsString(headquarters);
        // 二维码的图片格式
        String format = "jpg";
        Hashtable hints = new Hashtable();
        // 内容所使用编码
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, 300, 300, hints);
        // 生成二维码
        String url = "/img/QR"+df.format(date)+".jpg";

        try {
            // 图片上传
            // 设置图片名称，不能重复，可以使用uuid
            String picName = UUID.randomUUID().toString();
            // 获取文件名
            String oriName = url;
            // 获取图片后缀
            String extName = oriName.substring(oriName.lastIndexOf("."));
            //获取tomcat地址
            String workPath = System.getProperty("user.dir");
            workPath = workPath.substring(0,workPath.indexOf("bin"))+"webapps\\img\\";
            // 开始上传
            MatrixToImageWriter.writeToFile(bitMatrix, format, new File(workPath + picName + extName));
            url = "/img/" + picName + extName;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        headquarters.setQr_code(url);
        if(headquartersServiceImpl.save(headquarters)){
            return "XT/headquarters";
        }
        return "<a href='/headquarters/headquarters/toInsert_headquarters.do'>Failed to add or modify. Please return</a>";
    }

    @RequestMapping("/queryByForm.do")
    @ResponseBody
    public layui queryByForm(String manager,String name){
        QueryWrapper<Headquarters> wrapper = new QueryWrapper<>();
        if(null != manager && !"".equals(manager)){
            wrapper.eq("manager",manager);
        }
        if(null != name && !"".equals(name)){
            wrapper.eq("name",name);
        }
        layui layui = new layui();
        layui.setCode(0);
        layui.setCount(headquartersServiceImpl.list(wrapper).size());
        layui.setMsg("");
        layui.setData(headquartersServiceImpl.list(wrapper));
        return layui;
    }

    @RequestMapping("/toUpdate.do")
    public String toUpdate(Integer id, Model model){
        model.addAttribute("headquarters",headquartersServiceImpl.getById(id));
        model.addAttribute("staffsList", staffsServiceImpl.list(new QueryWrapper<Staffs>()));
        return "XT/headquarters_xiugai";
    }

    @RequestMapping("/delete.do")
    @ResponseBody
    public boolean delete(@RequestParam Integer id){
        return headquartersServiceImpl.removeById(id);
    }

    @RequestMapping("/update_headquarters.do")
    @ResponseBody
    public boolean update_headquarters(@RequestBody Headquarters headquarters) throws JsonProcessingException, WriterException {
        //生成当前时间
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        headquarters.setDate_changed(df.format(date));

        return headquartersServiceImpl.updateById(headquarters);
    }
}
