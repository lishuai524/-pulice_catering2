package com.huayu.CP_CW.sql;


import com.huayu.CP_CW.bean.Huiyuanpay;

public class HuiyuanpaySql {
    public String select(Huiyuanpay huiyuanpay){
        StringBuffer sql=new StringBuffer("select * from huiyuanpay where 1=1");
        if(null!= huiyuanpay){
            if ( huiyuanpay.getHuiyuan()!=null && !huiyuanpay.getHuiyuan().equals("")){
                sql.append(" and huiyuan like '%"+huiyuanpay.getHuiyuan()+"%'");
            }
            if ( huiyuanpay.getUser()!=null && !huiyuanpay.getUser().equals("")){
                sql.append(" and user like '%"+huiyuanpay.getUser()+"%'");
            }
            if ( huiyuanpay.getTime()!=null && !huiyuanpay.getTime().equals("")){
                sql.append(" and time like '%"+huiyuanpay.getTime()+"%'");
            }

        }
        return sql.toString();

    }
}
