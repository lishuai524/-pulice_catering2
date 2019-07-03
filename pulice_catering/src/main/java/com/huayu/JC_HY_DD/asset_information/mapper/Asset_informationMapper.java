package com.huayu.JC_HY_DD.asset_information.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.JC_HY_DD.asset_information.entity.Asset_information;
import com.huayu.JC_HY_DD.asset_information.sql.proSql;
import org.apache.ibatis.annotations.Mapper;
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
public interface Asset_informationMapper extends BaseMapper<Asset_information> {
    @SelectProvider(type = proSql.class,method = "selset")
    public List<Asset_information> queryAll(Asset_information asset_information);

}
