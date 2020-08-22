package com.qf.service;

import com.qf.pojo.SysOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qf.pojo.SysOrder2;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lcs
 * @since 2020-08-20
 */
public interface SysOrderService extends IService<SysOrder> {

    List<SysOrder2> findthree();
}
