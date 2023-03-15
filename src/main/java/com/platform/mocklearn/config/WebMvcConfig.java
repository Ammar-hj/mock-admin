package com.platform.mocklearn.config;

import com.platform.mocklearn.Interceptor.MdcManager;
import com.platform.mocklearn.Interceptor.SecurityInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${web.path}")
    private String webPath;

    @Value("${mock.manager.admin.password}")
    private String password;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MdcManager()).addPathPatterns("/mock/**");
        registry.addInterceptor(new SecurityInterceptor(password)).addPathPatterns("/mock/**");
    }

    // TODO 采坑：addResourceLocations的时候需要加上file，否则访问会报404
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/web/**").addResourceLocations("file:" + webPath);
    }

    @Bean
    public WebMvcConfigurer crossOriginConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/mock/**");
            }
        };
    }
}
