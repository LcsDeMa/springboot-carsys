package com.qf.service.impl;

import com.qf.pojo.SysCity;
import com.qf.dao.SysCityMapper;
import com.qf.service.SysCityService;
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
 * @since 2020-08-19
 */
@Service
public class SysCityServiceImpl extends ServiceImpl<SysCityMapper, SysCity> implements SysCityService {
    @Autowired
    private SysCityMapper sysCityMapper;
    @Override
    public List<SysCity> listById(String pid) {
        return sysCityMapper.listById(pid);
    }
}
