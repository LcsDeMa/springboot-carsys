package com.qf.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qf.pojo.SysCity;
import com.qf.service.SysCityService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lcs
 * @since 2020-08-19
 */
@RestController
@RequestMapping("sysCity")
public class SysCityController {
    @Autowired
    private SysCityService sysCityService;

    @RequestMapping("findAll")
    public List<SysCity> findAll(){
        return sysCityService.list(null);
    }

}
