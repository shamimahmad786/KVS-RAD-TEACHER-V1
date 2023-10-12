package com.example.MOERADTEACHER.common.util;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class TeacherInceptorConfig extends WebMvcConfigurerAdapter{

	@Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new ClientKeyInterceptor()).addPathPatterns("/**");
    }
}
