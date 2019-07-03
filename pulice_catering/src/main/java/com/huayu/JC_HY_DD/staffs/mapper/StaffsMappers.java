package com.huayu.JC_HY_DD.staffs.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.JC_HY_DD.staffs.entity.Staffs;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2019-06-12
 */
public interface StaffsMappers extends BaseMapper<Staffs> {
    @Select("select * from staffs where job_number=#{value}")
    public Staffs queryByid(int id);
    @Select("select psd from staffs where job_number=#{value}")
    public String querypsd(int id);
    @Select("update staffs set psd=#{psd} where job_number=#{job_number};")
    public void updatepwd(Staffs staffs);
    @Select("select head_portrait from staffs where job_number=#{value}")
    public String queryBytp(int job);
}
