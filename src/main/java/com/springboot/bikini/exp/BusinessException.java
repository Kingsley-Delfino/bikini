package com.springboot.bikini.exp;

public class BusinessException extends RuntimeException {
    public  BusinessException(String message){
        super(message);
    }
}
