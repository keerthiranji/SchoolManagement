package com.keerthi.CourseService.exception;

import java.io.Serializable;

public class Error implements Serializable {
    String message;
    Integer code;

    public  Error(String message, Integer code){
        this.message = message;
        this.code = code;
    }
}
