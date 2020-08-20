package com.qf.controller;


import com.qf.pojo.SysCity;
import com.qf.service.SysCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@Controller
@RequestMapping("sysCity")
public class SysCityController {
    @Autowired
    private SysCityService sysCityService;

    @RequestMapping("findAll")
    @ResponseBody
    public List<SysCity> findAll(){
        return sysCityService.list(null);
    }

    @RequestMapping("login")
    public String login(){
        return "/pagehome/login";
    }

}
