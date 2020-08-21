package com.qf.dao;

import com.qf.pojo.SysCity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lcs
 * @since 2020-08-19
 */
@Repository
public interface SysCityMapper extends BaseMapper<SysCity> {

    List<SysCity> listById(String pid);
}
