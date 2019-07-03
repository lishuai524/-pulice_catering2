package com.huayu.CP_CW.CP.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

@TableName("caidanshow")
public class CaiDanShow extends Model<CaiDanShow> {

   private static final long serialVersionUID = 1L;

   @TableId(value = "id", type = IdType.AUTO)
   private Integer id;

   private Integer caidanid;

   private String caidanimg;

   private String name;

   private String mendian;

   private String createtime;

   private String test;

   public Integer getId() {

      return id;
   }

   public void setId(Integer id) {

      this.id = id;
   }


   public String getCaidanimg() {

      return caidanimg;
   }

   public void setCaidanimg(String caidanimg) {

      this.caidanimg = caidanimg;
   }

   public String getName() {

      return name;
   }

   public void setName(String name) {

      this.name = name;
   }

   public String getMendian() {

      return mendian;
   }

   public void setMendian(String mendian) {

      this.mendian = mendian;
   }

   public String getTest() {

      return test;
   }

   public void setTest(String test) {

      this.test = test;
   }

   protected Serializable pkVal() {

      return null;
   }

   public Integer getCaidanid() {

      return caidanid;
   }

   public void setCaidanid(Integer caidanid) {

      this.caidanid = caidanid;
   }

   public String getCreatetime() {

      return createtime;
   }

   public void setCreatetime(String createtime) {

      this.createtime = createtime;
   }

}
