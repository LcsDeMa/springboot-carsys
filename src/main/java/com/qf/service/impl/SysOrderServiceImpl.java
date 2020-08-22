package com.qf.service.impl;

import com.qf.pojo.SysOrder;
import com.qf.dao.SysOrderMapper;
import com.qf.pojo.SysOrder2;
import com.qf.service.SysOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lcs
 * @since 2020-08-20
 */
@Service
public class SysOrderServiceImpl extends ServiceImpl<SysOrderMapper, SysOrder> implements SysOrderService {

    @Autowired
    private SysOrderMapper sysOrderMapper;

    @Override
    public List<SysOrder2> findthree() {
        return sysOrderMapper.findthree();
    }
}
