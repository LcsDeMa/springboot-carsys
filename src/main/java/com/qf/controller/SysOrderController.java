package com.qf.controller;


import com.qf.service.SysOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


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

    @RequestMapping("add.do")
    public String add(){
        return null;
    }

    @RequestMapping("ordersubmit")
    public String ordersubmit(){

        return "/order/ordersubmit.html";
    }

}
