package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * Description:
 *
 * @author 任耀
 * @ClassName: SeatOrderConfig
 * @date 2018/10/13 18:25
 */
@Configuration
public class SeatOrderConfig extends WebMvcConfigurerAdapter {

    /**
     * Description: 对一些静态资源的再次配置,
     * 似乎是由于 spring boot 2.0 以后导致的一些关于资源访问的问题
     *
     * @param registry
     * @Title: addResourceHandlers
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 静态资源配置
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }


}


