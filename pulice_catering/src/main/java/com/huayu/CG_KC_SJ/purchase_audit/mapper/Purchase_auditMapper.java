package com.huayu.CG_KC_SJ.purchase_audit.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.CG_KC_SJ.purchase_audit.entity.Purchase_audit;
import com.huayu.CG_KC_SJ.purchase_audit.sql.SelectSql_p;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
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
public interface Purchase_auditMapper extends BaseMapper<Purchase_audit> {
    //查询
    @Results({
            @Result(column = "kid", property = "kin", one = @One(select = "com.huayu.CG_KC_SJ.kind.mapper.kind_mapper.queryid", fetchType = FetchType.EAGER)),
            @Result(column = "uid", property = "uni", one = @One(select = "com.huayu.CG_KC_SJ.unit.unit_mapper.mapper.queryid", fetchType = FetchType.EAGER))
    })
    @SelectProvider(type = SelectSql_p.class, method = "select")
    public List<Purchase_audit> query(Purchase_audit purchase_audit);
}
