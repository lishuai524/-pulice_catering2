package com.huayu.CP_CW.sql;


import com.huayu.CP_CW.bean.Youhui;

public class YouhuiSql {
    public String select(Youhui youhui){
        StringBuffer sql=new StringBuffer("select * from youhui where 1=1");
        if(null!=youhui && !youhui.equals("")){
            if ( youhui.getName()!=null && !youhui.getName().equals("")){
                sql.append(" and name like '%"+youhui.getName()+"%'");
            }
            if ( youhui.getStart() != null && !youhui.getStart().equals("")){
                sql.append(" and start like '%"+youhui.getStart()+"%'");
            }
            if ( youhui.getEnd() != null && !youhui.getEnd().equals("")){
                sql.append(" and end like '%"+youhui.getEnd()+"%'");
            }

        }
        return sql.toString();

    }
}
