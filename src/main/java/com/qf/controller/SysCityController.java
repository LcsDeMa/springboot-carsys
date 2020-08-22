package com.qf.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qf.pojo.ResultInfo;
import com.qf.pojo.SysCity;
import com.qf.service.SysCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lcs
 * @since 2020-08-19
 */
@Controller
@RequestMapping("carsys/city")
public class SysCityController {
    @Autowired
    private SysCityService sysCityService;

    @RequestMapping("findAll")
    @ResponseBody
    public List<SysCity> findAll(){
        return sysCityService.list(null);
    }

    @RequestMapping("shortrent")
    public String shortrent(){
        return "/shortRent/shortrent";
    }
    @RequestMapping("index.html")
    public String index(){
        return "/pagehome/index.html";
    }

    @RequestMapping("select.do")
    @ResponseBody
    public Map select(String pid){
        System.out.println(pid);
        Map map = new HashMap<>();
        QueryWrapper<SysCity> queryWrapper = new QueryWrapper<>();
        List<SysCity> list = sysCityService.list(queryWrapper.eq("pid", pid));
//        List<SysCity> list = sysCityService.listById(pid);
//        HashSet<ResultInfo> citys = new HashSet<>();
//        HashSet<ResultInfo> mcs = new HashSet<>();
//        for (int i = 0; i < list.size(); i++) {
//          ResultInfo resultInfo2 = new ResultInfo();
//          resultInfo2.setId(list.get(i).getId());
//          resultInfo2.setName(list.get(i).getName());
//          ResultInfo resultInfo = new ResultInfo();
//          resultInfo.setId(list.get(i).getPpid());
//          resultInfo.setName(list.get(i).getCname());
//          citys.add(resultInfo2);
//          mcs.add(resultInfo);
//        }
//        System.out.println(citys);
//        System.out.println(mcs);
//        map.put("mcs",citys);
//        map.put("citys",mcs);
        if (!list.isEmpty()){
            map.put("code",1);
            map.put("info",list);
        }
        return map;
    }
    @RequestMapping("citys.do")
    @ResponseBody
    public Map citys(String getid,String backid){
        System.out.println("citys.do" + getid + "  ------   " + getid+" ------"+ backid);
        HashMap<String, Object> map = new HashMap<>();
        HashMap<String, Object> map2 = new HashMap<>();
        QueryWrapper<SysCity> queryWrapper = new QueryWrapper<>();
        List<SysCity> list = sysCityService.list(queryWrapper.eq("id",getid));
        List<SysCity> list2 = sysCityService.list(queryWrapper.eq("id",backid));
        if (!list.isEmpty()){
            map2.put("getCity",list.get(0));
            map2.put("backCity",list2.get(0));
            map.put("code",1);
            map.put("info",map2);
        }
        return map;
    }



}
