package com.huayu.CG_KC_SJ.acquisition_methods.sql;

import com.huayu.CG_KC_SJ.acquisition_methods.entity.Acquisition_methods;

public class SelectSqla {
    public String  select(Acquisition_methods acquisition_methods){
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append("select * from acquisition_methods where 1=1");
        if(acquisition_methods!=null) {
            if ( acquisition_methods.getAcquisition_Methods() != null && !"".equals(acquisition_methods.getAcquisition_Methods())) {
                stringBuffer.append(" and Acquisition_Methods like '%" + acquisition_methods.getAcquisition_Methods() + "%'");
            }else if (acquisition_methods.getSid() != null && !"".equals(acquisition_methods.getSid())) {
                stringBuffer.append(" and sid =" + acquisition_methods.getSid());
            }

        }
    return stringBuffer.toString();
    }
}
