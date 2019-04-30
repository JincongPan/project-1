package com.rent.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/test")
    public void index(HttpServletRequest request){
        System.out.println("回调开始....");


    }
}
