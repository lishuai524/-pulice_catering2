package com.huayu.JC_HY_DD.asset_information.sql;

import com.huayu.JC_HY_DD.asset_information.entity.Asset_information;
import com.huayu.JC_HY_DD.asset_information.entity.Property;

public class proSql {
    public String selset(Asset_information asset_information) {
        StringBuffer str = new StringBuffer();
        str.append("select * from asset_information where 1=1");
        if (asset_information != null) {
            if (asset_information.getRaw_material() != null && !asset_information.getRaw_material().equals("")) {
                str.append(" and raw_material like '%" + asset_information.getRaw_material() + "%'");
            }
        }
        return str.toString();
    }
    public String selset2(Property property){
        StringBuffer str = new StringBuffer();
        str.append("select * from property where type=101");
        if (property != null){
            if (property.getName() != null && !property.getName().equals("")){
                str.append(" and name like '%"+property.getName()+"%'");
            }
            if(property.getBelong_to_shop() != null && !property.getBelong_to_shop().equals("") &&!property.getBelong_to_shop().equals("a")){
                str.append(" and belong_to_shop ="+property.getBelong_to_shop());
            }
        }
        return str.toString();
    }
    public String selset3(Property property){
        StringBuffer str = new StringBuffer();
        str.append("select * from property where type=102");
        if (property != null){
            if (property.getName() != null && !property.getName().equals("")){
                str.append(" and name like '%"+property.getName()+"%'");
            }
            if(property.getBelong_to_shop() != null && !property.getBelong_to_shop().equals("") &&!property.getBelong_to_shop().equals("a")){
                str.append(" and belong_to_shop ="+property.getBelong_to_shop());
            }
        }
        return str.toString();
    }
}
