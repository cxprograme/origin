package com.codecrane.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by crane on 16/3/11.
 */
@Controller
public class ErrorHandlerController {
    /**
     * 错误的请求视图
     * @param errorCode
     * @return
     */
    @RequestMapping("/error/{code}")
    public String forbiddenError(@PathVariable("code")String errorCode){
        return "error/"+errorCode;
    }
}
