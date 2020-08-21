package com.qf.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qf.pojo.ResultInfo;
import com.qf.pojo.SysUser;
import com.qf.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lcs
 * @since 2020-08-20
 */
@Controller
@RequestMapping("/carsys/user")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;
    @RequestMapping("login")
    public String login(){
        return "/pagehome/login";
    }

    @RequestMapping("login.do")
    @ResponseBody
    public ResultInfo login(SysUser sysUser){
        System.out.println(sysUser);
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        ResultInfo resultInfo = new ResultInfo();
        queryWrapper.setEntity(sysUser);
        SysUser one = sysUserService.getOne(queryWrapper);
        System.out.println(one);
        if (one != null){
            resultInfo.setCode(1);
        }else {
            resultInfo.setInfo("查无此人！");
        }
        return resultInfo;

    }
    @RequestMapping("success")
    public String success(){
        return "/pagehome/loginsuccess";
    }
    @RequestMapping("index.html")
    public String index(){
        return "/pagehome/index";
    }
    @RequestMapping("register")
    public String register(){
        return "/pagehome/register";
    }
    @RequestMapping("register.do")
    @ResponseBody
    public ResultInfo register(SysUser sysUser){
        System.out.println(sysUser);
        ResultInfo resultInfo = new ResultInfo();
        boolean save = sysUserService.save(sysUser);
        System.out.println(save);
        if (save) {
            resultInfo.setCode(1);
        }else {
            resultInfo.setInfo("插入失败！");
        }
        return resultInfo;
    }
    @RequestMapping("denglu.do")
    @ResponseBody
    public ResultInfo denglu(){
        ResultInfo resultInfo = new ResultInfo();


        return  resultInfo;
    }

}
