package com.huayu.JC_HY_DD.take_out.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.JC_HY_DD.take_out.entity.Take_out;
import com.huayu.JC_HY_DD.take_out.sql.takeSql;
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
public interface Take_outMapper extends BaseMapper<Take_out> {
    @SelectProvider(type = takeSql.class,method = "selset")
    public List<Take_out> queryAll(Take_out takeOut);
}
