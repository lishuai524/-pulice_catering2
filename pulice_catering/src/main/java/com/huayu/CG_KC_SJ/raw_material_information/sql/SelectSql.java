package com.huayu.CG_KC_SJ.raw_material_information.sql;

import com.huayu.CG_KC_SJ.raw_material_information.entity.Raw_material_information;

public class SelectSql {
    public String  select(Raw_material_information raw_material_information){
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append("select * from raw_material_information where 1=1");
        if(raw_material_information!=null) {

            if ( raw_material_information.getName() != null && !"".equals(raw_material_information
                    .getName())) {
                stringBuffer.append(" and name like '%" + raw_material_information.getName() + "%'");
            }
            else if (raw_material_information.getKid() != null && !"".equals(raw_material_information.getKid())) {
                stringBuffer.append(" and kid =" + raw_material_information.getKid());
            }
        }
    return stringBuffer.toString();
    }
}
