package cn.beichenhpy.interceptor.sample.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <PRE>
 *
 * </PRE>
 * CREATE_TIME: 2022/4/10 14:16
 *
 * @author beichenhpy
 * @version 1.0.0
 */
@RestControllerAdvice
public class ControllerExceptionHandler {


    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> ExceptionHandler(Exception e){
        return ResponseEntity.ok(e.getMessage());
    }
}
