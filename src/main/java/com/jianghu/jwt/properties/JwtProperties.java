package com.jianghu.jwt.properties;

import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

/**
 * @Auther: JY
 * @Date: 2019/10/28 14:37
 * @Description:
 */
@Data
@Getter
public class JwtProperties {
    @Value("${jianghu.secret}")
    public static String SECRET;
}
