package com.jianghu.jwt.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.jianghu.jwt.properties.JwtProperties;
import io.jsonwebtoken.JwsHeader;

import java.util.Map;

/**
 * @Auther: JY
 * @Date: 2019/10/28 10:20
 * @Description: JWT工具类
 */
public class JWTUtils {
    /**
     * 功能描述:
     *
     * @param: map
     * @return: token
     * @date: 2019/10/28 10:27
     */
    public static Map<String, Claim> verifyToken(String token) {

        JWTVerifier jwt = JWT.require(Algorithm.HMAC256(JwtProperties.SECRET)).build();
        DecodedJWT verify = null;
        try {
            verify= jwt.verify(token);
        }catch (Exception e){
            System.out.println("登陆过期");
        }
        return verify.getClaims();

    }
}
