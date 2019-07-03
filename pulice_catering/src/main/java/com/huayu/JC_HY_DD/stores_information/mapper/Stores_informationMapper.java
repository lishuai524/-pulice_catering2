package com.huayu.JC_HY_DD.stores_information.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.JC_HY_DD.stores_information.entity.Stores_information;
import com.huayu.JC_HY_DD.stores_information.sql.storSql;
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
public interface Stores_informationMapper extends BaseMapper<Stores_information> {
    @SelectProvider(type = storSql.class,method = "selset")
    public List<Stores_information> queryAll(Stores_information stores_information);

    @Select("select * from stores_information where id=#{value}")
    public Stores_information toupdate(int id);

    @Select("select picture from stores_information where id=#{value}")
    public String queryBytp(int id);

    @Select("update stores_information set picture=#{picture},manager=#{manager},business_hours=#{business_hours},phone=#{phone},email=#{email},shop_site=#{shop_site},update_data=#{update_data}  where id=#{id}")
    public int update(Stores_information storesInformation);
}
