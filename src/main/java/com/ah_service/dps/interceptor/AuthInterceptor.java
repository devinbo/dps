package com.ah_service.dps.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Administrator on 2017/9/29.
 */
@Configuration
public class AuthInterceptor extends WebMvcConfigurerAdapter {

    @Bean
    LoginHandlerInterceptor loginHandlerInterceptor() {
        return new LoginHandlerInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(loginHandlerInterceptor())
//                .addPathPatterns("/") //拦截客户
//                .addPathPatterns("/book/*") //拦截订单
//                .excludePathPatterns(".png")
//                .excludePathPatterns(".jpg")
//                .excludePathPatterns(".gif")
//                .excludePathPatterns(".jpeg")
//                .excludePathPatterns("/login.html") //登录
//                .excludePathPatterns(".js")
//                .excludePathPatterns(".css")
//                .excludePathPatterns(".svg")
//                .excludePathPatterns(".eot")
//                .excludePathPatterns(".woff")
//                .excludePathPatterns(".ttf")
//                .excludePathPatterns(".ico")
//                .excludePathPatterns(".ttf")
//                .excludePathPatterns("/:")
//                .excludePathPatterns("/login")
//                .excludePathPatterns("/reg") //获取token
//                .excludePathPatterns("/ws");
    }
}
