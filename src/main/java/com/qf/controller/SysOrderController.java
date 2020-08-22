package com.qf.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.pojo.SysOrder;
import com.qf.pojo.SysOrder2;
import com.qf.service.SysOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
@RequestMapping("/carsys/order")
public class SysOrderController {
    @Autowired
    private SysOrderService sysOrderService;


    @RequestMapping("ordersubmit")
    public String ordersubmit(){

        return "/order/ordersubmit.html";
    }
    @RequestMapping("add.do")
    @ResponseBody
    public Map add(String getid, String backid, String cid, String oprice){
        System.out.println("findcar.do" + getid + "------" + backid + "-------" + cid+"----  "+oprice);
        HashMap<String, Object> map = new HashMap<>();
        map.put("info","Ok");

        return map;
    }
    @RequestMapping("all.do")
    @ResponseBody
    public Map all(String page){
        Integer limit = 5;
        System.out.println("all.do"  + "------" + page);
        PageHelper.startPage(Integer.parseInt(page),limit);
        HashMap<String, Object> map = new HashMap<>();
        HashMap<String, Object> info = new HashMap<>();
        List<SysOrder2> list = sysOrderService.findthree();
        PageInfo<SysOrder2> pageInfo = new PageInfo<>(list);
        System.out.println("集合------"+list);
        if (!list.isEmpty()) {
            info.put("total", pageInfo.getTotal());
            info.put("rows", pageInfo.getList());
            map.put("info", info);
            map.put("code", 1);
        }
        return map;
    }

}
