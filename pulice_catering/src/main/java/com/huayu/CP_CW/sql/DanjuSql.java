package com.huayu.CP_CW.sql;


import com.huayu.CP_CW.bean.Danju;

public class DanjuSql {
    public String select(Danju danju){
        StringBuffer sql=new StringBuffer("select * from danju where 1=1");
        if(null!=danju && !danju.equals("")){
            if ( danju.getBianhao()!=null && !danju.getBianhao().equals("")){
                sql.append(" and bianhao like '%"+danju.getBianhao()+"%'");
            }
         /*   if ( danju.getType() >0 && danju.getType()<=2){
                sql.append(" and type like '%"+danju.getType()+"%'");
            }
*/
        }
        return sql.toString();

    }
}
