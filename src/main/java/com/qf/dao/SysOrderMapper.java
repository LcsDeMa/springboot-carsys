package com.qf.dao;

import com.qf.pojo.SysOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.pojo.SysOrder2;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lcs
 * @since 2020-08-20
 */
@Repository
public interface SysOrderMapper extends BaseMapper<SysOrder> {

    List<SysOrder2> findthree();

}
