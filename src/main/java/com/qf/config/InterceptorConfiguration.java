package com.qf.config;

import com.qf.inceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Auther: Lcs
 * @Date: 2020/8/11 10:37
 * @Description:
 */
@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //指定拦截的路径，spring，xml中拦截器的配置
        registry.addInterceptor(new MyInterceptor());
        WebMvcConfigurer.super.addInterceptors(registry);
    }
    /**
     * 发现如果继承了WebMvcConfigurationSupport，则在yml中配置的相关内容会失效。 需要重新指定静态资源
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations(
                "classpath:/static/");
        registry.addResourceHandler("/**").addResourceLocations(
                "classpath:/templates/");
        registry.addResourceHandler("swagger-ui.html").addResourceLocations(
                "classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations(
                "classpath:/META-INF/resources/webjars/");
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }
//        @Bean
//        public MyInterceptor getMyInterceptor(){
//        return new MyInterceptor();
//        }
//
//    public void addInterceptors(InterceptorRegistry registry,MyInterceptor myInterceptor) {
//        /*调用我们创建的SessionInterceptor。
//         * addPathPatterns("/**)的意思是这个链接下的都要进入到SessionInterceptor里面去执行
//         * excludePathPatterns("/login")的意思是login的url可以不用进入到SessionInterceptor中，直接
//         * 放过执行。
//         * 注意：如果像注释那样写是不可以的。这样等于是创建了多个Interceptor。而不是只有一个Interceptor
//         *
//         * */
//        registry.addInterceptor(myInterceptor).addPathPatterns("/**")
//                .excludePathPatterns("/user/login","/userAPI/login","/user/defaultKaptcha","/publicPage/login","/css/**","/js/**","/img/**","/images/**","/layui/**","/static/**","/mapper/**");
//
//        super.addInterceptors(registry);
//    }
}
