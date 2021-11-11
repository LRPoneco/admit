package com.example.admit.dao.lanjieqi;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableCaching
public class applation implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        InterceptorRegistration ir=registry.addInterceptor(new SessionFilter());
        ir.addPathPatterns("/webapp/*.html");
        //ir.excludePathPatterns("/webapp/*.html");
    }
}
