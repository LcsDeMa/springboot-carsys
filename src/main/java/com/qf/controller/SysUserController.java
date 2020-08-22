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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

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
    public ResultInfo login(SysUser sysUser, HttpServletRequest request){
//        System.out.println(sysUser);
        HttpSession session = request.getSession();
        Boolean isHasPeople = false;
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        ResultInfo resultInfo = new ResultInfo();
        queryWrapper.setEntity(sysUser);
        SysUser one = sysUserService.getOne(queryWrapper);
        System.out.println(one);
        if (one != null){
            resultInfo.setCode(1);
            isHasPeople = true;
        }else {
            resultInfo.setInfo("查无此人！");
        }
        session.setAttribute("isHasPeople",isHasPeople);
        session.setAttribute("user",one);
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
    public ResultInfo denglu(HttpServletRequest request){
        ResultInfo resultInfo = new ResultInfo();
        HttpSession session = request.getSession(false);
        Boolean isHasPeople = false;
        SysUser sysUser = null;
        if (session != null) {
            isHasPeople = (Boolean) session.getAttribute("isHasPeople");
            sysUser = (SysUser)session.getAttribute("user");
        }
        if (isHasPeople){
            resultInfo.setCode(1);
            resultInfo.setUser(sysUser);
        }else {
            resultInfo.setCode(2);
        }
        return  resultInfo;
    }
    @RequestMapping("update.do")
    @ResponseBody
    public Map update(SysUser user,HttpServletRequest request){
        System.out.println("update1----"+user);
        HashMap<String, Object> map = new HashMap<>();
        HttpSession session = request.getSession();
        SysUser user1 = (SysUser) session.getAttribute("user");
        System.out.println("update2--------"+user1);
        user.setId(user1.getId());
        boolean update = sysUserService.updateById(user);
        session.setAttribute("user",sysUserService.getOne(new QueryWrapper<SysUser>().eq("id",user.getId())));
        if (update){
            map.put("code",1);
        }
        return map;
    }
}
