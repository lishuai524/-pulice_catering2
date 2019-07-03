package com.huayu.JC_HY_DD.stores_information.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.huayu.JC_HY_DD.member_management.entity.DataMessage;
import com.huayu.JC_HY_DD.stores_information.entity.Stores_information;
import com.huayu.JC_HY_DD.stores_information.service.impl.Stores_informationServiceImpl;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
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
@RequestMapping("/stores_information/stores-information")
public class Stores_informationController {
    @Autowired
    private Stores_informationServiceImpl informationService;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping("/queryAll.do")
    @ResponseBody
    public DataMessage queryAll(Stores_information information, Integer page, Integer limit) {
        DataMessage dataMessage = new DataMessage();
        dataMessage.setCode(0);
        dataMessage.setMsg("");
        dataMessage.setCount(informationService.queryAll(information).size());
        PageHelper.startPage(page,limit,true);
        List<Stores_information> list = informationService.queryAll(information);
        dataMessage.setData(list);
        return dataMessage;
    }

    @RequestMapping("/add.do")
    public String add(@RequestParam("filename") MultipartFile pictureFile, Stores_information information,String business_max) throws IOException, WriterException {
//        上传图片
        Random random = new Random();
        int r= random.nextInt(111);
        String picName = new SimpleDateFormat("yyyyMMdd").format(new Date()) + r;
        String e1 = request.getSession().getServletContext().getRealPath("");
        String e = e1.substring(0,e1.indexOf("target"))+"src\\main\\webapp\\img\\";
        String oriName = pictureFile.getOriginalFilename();
        File file = new File(e+oriName);
        if(!file.exists()){
            pictureFile.transferTo(new File(e + oriName));
        }
        String str = "/img/"+oriName;
        information.setPicture(str);

        //        修改时间
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data = df.format(date);
        information.setUpdate_data(data);


        ObjectMapper mapper = new ObjectMapper();
        String text = mapper.writeValueAsString(information);

        int width = 300;
        int height = 300;
        // 二维码的图片格式
        String format = "jpeg";
        Hashtable hints = new Hashtable();
        // 内容所使用编码
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints);
        // 生成二维码
        String url = "/img/QR"+picName+".jpeg";
        String se = e1.substring(0,e1.indexOf("target"))+"src\\main\\webapp";
        File outputFile = new File(se + File.separator + url);
        MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);

        System.out.println(url);



        information.setEwmcode(url);
        informationService.save(information);
        return "JC_HY_DD/JC/addStore.jsp";
    }

    @RequestMapping("/delete/{id}.do")
    @ResponseBody
    public boolean delete(@PathVariable(value = "id")int id){
        return  informationService.removeById(id);
    }

    @RequestMapping("/toupdate/{id}.do")
    public String toUpdate(@PathVariable(value = "id") int id, Model model) {
        Stores_information stores = informationService.toupdate(id);
        model.addAttribute("sto", stores);
        return "JC_HY_DD/JC/updateStore.jsp";
    }

    @RequestMapping("/update.do")
    public String update(Stores_information storesInformation,@RequestParam("filename1") MultipartFile pictureFile) throws IOException {
        String str = "";
              //        上传图片
        if(pictureFile.isEmpty()){
            String tpurl = informationService.queryBytp(storesInformation.getId());
            str=tpurl;
        }else{
            Random random = new Random();
            int r= random.nextInt(111);
            String picName = new SimpleDateFormat("yyyyMMdd").format(new Date()) + r;
            String e1 = request.getSession().getServletContext().getRealPath("");
            String e = e1.substring(0,e1.indexOf("target"))+"src\\main\\webapp\\img\\";
            String oriName = pictureFile.getOriginalFilename();
            File file = new File(e+oriName);
            if(!file.exists()){
                pictureFile.transferTo(new File(e + oriName));
            }
            str = "/img/"+oriName;
        }

        storesInformation.setPicture(str);

        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data = df.format(date);

        informationService.updateById(storesInformation);
        return "";
    }



}
