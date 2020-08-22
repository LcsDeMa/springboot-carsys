package com.qf.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qf.dao.SysCarMapper;
import com.qf.pojo.SysCar;
import com.qf.service.SysCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
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
@RequestMapping("/carsys/car")
public class SysCarController {

    @Autowired
    private SysCarService sysCarService;

    @RequestMapping("price.do")
    @ResponseBody
    public Map price(String getid,String backid){
        System.out.println("price.do  " + getid+" ---- "+backid);
        HashMap<String, Object> map = new HashMap<>();
        QueryWrapper<SysCar> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("cid",getid);
        queryWrapper.orderByDesc("price");
        List<SysCar> list = sysCarService.list(queryWrapper);
        if (!list.isEmpty()) {
            map.put("code", 1);
            map.put("info", list);
        }
        return map;
    }
    @RequestMapping("number.do")
    @ResponseBody
    public Map nubmber(String getid,String backid){
        System.out.println("number.do  " + getid);
        HashMap<String, Object> map = new HashMap<>();
        QueryWrapper<SysCar> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("cid",getid);
        queryWrapper.orderByDesc("number");
        List<SysCar> list = sysCarService.list(queryWrapper);
        if (!list.isEmpty()) {
            map.put("code", 1);
            map.put("info", list);
        }
        return map;
    }
    @RequestMapping("findcar.do")
    @ResponseBody
    public Map findcar(String getid,String backid,String cid){
        System.out.println("findcar.do" + getid + "------" + backid + "-------" + cid);
        HashMap<String, Object> map = new HashMap<>();
        QueryWrapper<SysCar> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",cid);
        List<SysCar> list = sysCarService.list(queryWrapper);
        if (!list.isEmpty()){
            map.put("code",1);
            map.put("info",list.get(0));
        }
        return map;
    }


}
