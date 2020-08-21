package com.qf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: Lcs
 * @Date: 2020/8/20 22:23
 * @Description:
 */
@Controller
@RequestMapping("carsys/mymain")
public class MyController {

    @RequestMapping("mymain.html")
    public String mymain(){
        return "/mymain/mymain.html";
    }
}
