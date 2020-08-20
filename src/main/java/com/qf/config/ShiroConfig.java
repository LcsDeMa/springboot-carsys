package com.qf.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.qf.realm.ShiroRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

/**
 * @Auther: Lcs
 * @Date: 2020/8/13 17:37
 * @Description:
 */
@Configuration
public class ShiroConfig {
    @Bean
    public ShiroRealm getShiroRealm(){
        return new ShiroRealm();
    }
    @Bean
    public SecurityManager getSecurityManager(ShiroRealm shiroRealm,CookieRememberMeManager cookieRememberMeManager){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm);
        securityManager.setRememberMeManager(cookieRememberMeManager);
        return securityManager;
    }
    @Bean
    public CookieRememberMeManager getCookieRememberMeManager(){
        //创建Cookie对象
        SimpleCookie rememberMe = new SimpleCookie("rememberMe");
        rememberMe.setMaxAge(3600*31*24);
        //创建管理Cookie对象
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMe);
        return cookieRememberMeManager;

    }
    //配置ShiroDialect
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //未认证访问页面
        shiroFilterFactoryBean.setLoginUrl("/tologin");
        //认证成功跳转页面（一般不设置，默认登录成功跳转当前页面）
//        shiroFilterFactoryBean.setSuccessUrl();
        //未授权访问页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/refuse");
        //通过map配置访问流程（顺序很重要）
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("/**","anon");//所有路径都可以匿名访问
        //配置静态资源
        map.put("/js/**","anon");
        map.put("/fonts/**","anon");
        map.put("/images/**","anon");
        map.put("/css/**","anon");
        map.put("/layui/**","anon");
        map.put("/pagehome/**","anon");
//        //配置login页面
//        map.put("/login","anon");
//        //配置logout退出
//        map.put("/logout","logout");


//        map.put("/**","authc");//该路径认证后才能访问

        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

}
