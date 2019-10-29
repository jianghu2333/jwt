package com.jianghu.jwt.vo;

import lombok.Data;

/**
 * 公共返回对象
 *
 * @Auther: JY
 * @Date: 2019/10/29 14:33
 * @Description:
 */
@Data
public class ResultVo {
    private String code;
    private Object object;
}
