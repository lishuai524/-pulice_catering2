package com.huayu.JC_HY_DD.queue.sql;

import com.huayu.JC_HY_DD.queue.entity.Queue;

public class queSql {
    public String selset(Queue queue){
        StringBuffer str = new StringBuffer();
        str.append("select * from queue where 1=1");
        if (queue != null){
            if (queue.getType() != null && !queue.getType().equals("")){
                str.append(" and type like '%"+queue.getType()+"%'");
            }
            if(queue.getCapacity() != null && !queue.getCapacity().equals("")){
                str.append(" and capacity ="+queue.getCapacity());
            }
        }
        return str.toString();
    }
}
