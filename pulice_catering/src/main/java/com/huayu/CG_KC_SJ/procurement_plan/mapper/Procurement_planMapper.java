package com.huayu.CG_KC_SJ.procurement_plan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.CG_KC_SJ.procurement_plan.entity.Procurement_plan;
import com.huayu.CG_KC_SJ.procurement_plan.sql.SelectSql_pr;
import com.huayu.CG_KC_SJ.raw_material_information.entity.Raw_material_information;
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
public interface Procurement_planMapper extends BaseMapper<Procurement_plan> {
    //查询
    @Results({
            @Result(column = "kid", property = "kin", one = @One(select = "com.huayu.CG_KC_SJ.kind.mapper.kind_mapper.queryid", fetchType = FetchType.EAGER)),
            @Result(column = "uid", property = "uni", one = @One(select = "com.huayu.CG_KC_SJ.unit.unit_mapper.mapper.queryid", fetchType = FetchType.EAGER))
    })
    @SelectProvider(type = SelectSql_pr.class, method = "select")
    public List<Procurement_plan> query(Procurement_plan procurement_plan);

    @Select("select r.unit_price,r.model from raw_material_information r,procurement_plan p where r.name = p.rmiid and p.rmiid=#{rmiid} order by id desc")
    public Raw_material_information queryname(String rmiid);

}
