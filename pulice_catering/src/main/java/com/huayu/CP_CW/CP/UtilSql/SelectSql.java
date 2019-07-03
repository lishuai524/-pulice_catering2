package com.huayu.CP_CW.CP.UtilSql;




import com.huayu.CP_CW.CP.entity.CaiDanShow;
import com.huayu.CP_CW.CP.entity.Caiping;
import com.huayu.CP_CW.CP.entity.Caipingtype;

public class SelectSql {
   public String querycaiping(Caiping caiping){
      StringBuffer stringBuffer=new StringBuffer();
      stringBuffer.append("select * from caiping where 1=1");
      if(null != caiping && !"".equals(caiping)){
         if(null != caiping.getName() && !"".equals(caiping.getName())){
            stringBuffer.append(" and name = #{name}");
         }if (null != caiping.getType() && caiping.getType() > 0 ){
            stringBuffer.append(" and type = #{type}");
         }
      }
      return stringBuffer.toString();
   }

   public String querytype(Caipingtype caipingtype){
      StringBuffer stringBuffer=new StringBuffer();
      stringBuffer.append("select * from caipingtype where 1=1");
      if(null != caipingtype && !"".equals(caipingtype)){
         if(null != caipingtype.getId() && caipingtype.getId() > 0){
            stringBuffer.append(" and id = #{id}");
         }
      }
      return stringBuffer.toString();
   }

   public String querycaidanshow(CaiDanShow caiDanShow){
      StringBuffer stringBuffer=new StringBuffer();
      stringBuffer.append("select * from caidanshow where 1=1");
      if(null != caiDanShow && !"".equals(caiDanShow)){
         if(null != caiDanShow.getMendian() && !"".equals(caiDanShow.getMendian())){
            stringBuffer.append(" and mendian = #{mendian}");
         }
      }
      return stringBuffer.toString();
   }

}
