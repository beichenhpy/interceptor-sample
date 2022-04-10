package cn.beichenhpy.interceptor.sample.controller;

import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <PRE>
 *
 * </PRE>
 * CREATE_TIME: 2022/4/10 14:14
 *
 * @author beichenhpy
 * @version 1.0.0
 */
@RestController
@RequestMapping("user")
public class UserController {

    @SneakyThrows
    @GetMapping
    public ResponseEntity<?> users(@RequestParam("ex") Integer ex){
        if (ex == 1){
            throw new Exception("抛出异常");
        }
        return ResponseEntity.ok("ok");
    }
}
