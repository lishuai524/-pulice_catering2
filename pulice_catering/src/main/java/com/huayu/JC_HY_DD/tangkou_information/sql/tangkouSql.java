package com.huayu.JC_HY_DD.tangkou_information.sql;

import com.huayu.JC_HY_DD.tangkou_information.entity.Tangkou_information;

public class tangkouSql {
    public String selset(Tangkou_information tangkouInformation){
        StringBuffer str = new StringBuffer();
        str.append("select * from tangkou_information where 1=1");
        if (tangkouInformation != null){
            if (tangkouInformation.getName() != null && !tangkouInformation.getName().equals("")){
                str.append(" and name like '%"+tangkouInformation.getName()+"%'");
            }
            if(tangkouInformation.getCategory() != null && !tangkouInformation.getCategory().equals("") &&!tangkouInformation.getCategory().equals("a")){
                str.append(" and category ="+tangkouInformation.getCategory());
            }
        }
        return str.toString();
    }
}
