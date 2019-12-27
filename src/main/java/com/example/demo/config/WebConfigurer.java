package com.example.demo.config;

import com.example.demo.config.interceptors.AdminInterceptor;
import com.example.demo.config.interceptors.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * @author ry
 */
@Configuration
public class WebConfigurer extends WebMvcConfigurerAdapter {
    @Autowired
    private LoginInterceptor loginInterceptor;
    @Autowired
    private AdminInterceptor adminInterceptor;


    /**
     * 这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/login/*");
        registry.addInterceptor(adminInterceptor).addPathPatterns("/admin*");
    }

}
