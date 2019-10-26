package com.jianghu.jwt.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BaseException extends Exception {
    private Integer code;
    private String message;

}

