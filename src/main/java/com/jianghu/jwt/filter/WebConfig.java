package com.jianghu.jwt.filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: JY
 * @Date: 2019/10/30 14:26
 * @Description:
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginFilter() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                return super.preHandle(request, response, handler);
            }
        }).addPathPatterns("/user/register").addPathPatterns("/user/login").excludePathPatterns("/user/**");
        super.addInterceptors(registry);
    }
}
