package com.jianghu.jwt.filter;

import com.auth0.jwt.interfaces.Claim;
import com.jianghu.jwt.exception.BaseException;
import com.jianghu.jwt.pojo.User;
import com.jianghu.jwt.utils.JWTUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Auther: JY
 * @Date: 2019/10/28 16:07
 * @Description:
 */
public class LoginFilter implements HandlerInterceptor {

    public static ThreadLocal<User> local = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorization = request.getHeader("Authorization");
        Map<String, Claim> claimMap = JWTUtils.verifyToken(authorization);
        if (claimMap == null) {
            throw new BaseException(10001, "登录失效，请重新登录！");
        }
        User user = new User();
        user.setId(claimMap.get("id").asLong());
        user.setUsername(claimMap.get("username").asString());
        local.set(user);
        return true;
    }

    public static User getUser() {
        return local.get();
    }
}
