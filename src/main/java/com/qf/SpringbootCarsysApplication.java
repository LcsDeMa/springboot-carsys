package com.qf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan("com.qf.dao")
@ServletComponentScan
public class SpringbootCarsysApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCarsysApplication.class, args);
    }

}
