package com.huayu.CG_KC_SJ.marketing_plan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.CG_KC_SJ.marketing_plan.entity.Marketing_plan;
import com.huayu.CG_KC_SJ.marketing_plan.entity.plan;
import com.huayu.CG_KC_SJ.marketing_plan.sql.SelectSql_mark;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2019-06-12
 */
public interface Marketing_planMapper extends BaseMapper<Marketing_plan> {


    //查询
    @Results({
           //表门店---
           @Result(column = "shop", property = "stores_information", one = @One(select = "com.huayu.CG_KC_SJ.stores_information.mapper.Stores_informationMapper.query", fetchType = FetchType.EAGER)),

            //表菜品-----


           @Result(column = "cuisine", property = "food_list", one = @One(select = "com.huayu.CP_CW.food_list.mapper.Food_listMapper.queryid", fetchType = FetchType.EAGER)),

            /*类别表*/
            @Result(column = "category", property = "kin", one = @One(select = "com.huayu.CG_KC_SJ.kind.mapper.kind_mapper.queryid", fetchType = FetchType.EAGER)),
    })
    @SelectProvider(type = SelectSql_mark.class, method = "select")
    public List<Marketing_plan> query(Marketing_plan marketing_plan);








   //材料清单
   @Results({

           @Result(column = "r.kid", property = "kin", one = @One(select = "com.huayu.CG_KC_SJ.kind.mapper.kind_mapper.queryid", fetchType = FetchType.EAGER)),
           @Result(column = "r.uid", property = "uni", one = @One(select = "com.huayu.CG_KC_SJ.unit.unit_mapper.mapper.queryid", fetchType = FetchType.EAGER))
   })
    @Select("select r.`name`,r.kid,r.uid,r.unit_price  from marketing_plan m,raw_material_information r,food_list f where f.flid =m.cuisine and f.rmiid=r.rmiid and cuisine=#{value}")
    public plan queryall(Integer cuisine);

}
