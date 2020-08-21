package com.qf.service;

import com.qf.pojo.SysCity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lcs
 * @since 2020-08-19
 */
public interface SysCityService extends IService<SysCity> {

    List<SysCity> listById(String pid);
}
