package com.jianghu.jwt.filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.ArrayList;

/**
 * @Auther: JY
 * @Date: 2019/10/30 14:26
 * @Description:
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("/user/login");
        arrayList.add("/user/register");
        //注册自定义拦截器，添加拦截路径和排除拦截路径
        registry.addInterceptor(new LoginFilter()).addPathPatterns("/**").excludePathPatterns(arrayList);
    }
}
