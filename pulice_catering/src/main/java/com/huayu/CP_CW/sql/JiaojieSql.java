package com.huayu.CP_CW.sql;


import com.huayu.CP_CW.bean.JiaoJie;

public class JiaojieSql {
    public String select(JiaoJie jiaoJie){
        StringBuffer sql=new StringBuffer("select * from jiaojie where 1=1");
        if(null!=jiaoJie){
            if ( jiaoJie.getJiaojie()!=null && !jiaoJie.getJiaojie().equals("")){
                sql.append(" and jiaojie like '%"+jiaoJie.getJiaojie()+"%'");
            }
            if (jiaoJie.getJieshou()!=null && !jiaoJie.getJieshou().equals("")){
                sql.append(" and jieshou like '%"+jiaoJie.getJieshou()+"%'");
            }

        }
        return sql.toString();

    }
}
