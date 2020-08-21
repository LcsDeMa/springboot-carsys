package com.qf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: Lcs
 * @Date: 2020/8/11 10:34
 * @Description:
 */
@Controller
@RequestMapping("interceptor")
public class InterceptorController {
    @RequestMapping("toIndex")
    public String toIndex(){
        System.out.println("toIndex");

        return "/index.html";
    }

}
