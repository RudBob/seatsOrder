package com.example.demo.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.*;

/**
 * Description:
 *
 * @author 任耀
 * @ClassName: SeatOrderConfig
 * @date 2018/10/13 18:25
 */
@Configuration
@EnableWebMvc // 1开启默认配置
@EnableScheduling
public class SeatOrderConfig extends WebMvcConfigurerAdapter {

    /**
     * Description: 对一些静态资源的再次配置, 似乎是由于 spring boot 2.0 以后导致的一些关于资源访问的问题
     *
     * @param registry
     * @Title: addResourceHandlers
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 静态资源配置
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    /**
     * Description: 页面转向
     *
     * @param registry
     * @Title: addViewControllers
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/index.html");
    }

    /**
     * Description: 添加拦截器
     *
     * @param registry
     * @Title: addInterceptors
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

    }
}


