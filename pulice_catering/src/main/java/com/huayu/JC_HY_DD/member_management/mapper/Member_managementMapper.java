package com.huayu.JC_HY_DD.member_management.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.JC_HY_DD.member_management.entity.Member_management;
import com.huayu.JC_HY_DD.member_management.sql.vipsql;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2019-06-12
 */
@Mapper
public interface Member_managementMapper extends BaseMapper<Member_management> {
    @SelectProvider(type = vipsql.class,method = "selset")
    public List<Member_management> queryAll(Member_management management);

    @Select("select head_portrait from Member_management where id=#{value}")
    public String queryBytp(int id);
}
