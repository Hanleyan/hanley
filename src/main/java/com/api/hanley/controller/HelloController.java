package com.api.hanley.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author hanley
 * @date 2019/7/26 10:44
 * 风萧萧兮易水寒
 */
@RestController
public class HelloController {

    @Value("${server.port}")
    Integer port;

    @GetMapping("/set")
    public String set(HttpSession session){
        session.setAttribute("user","Hello,java!");
        return String.valueOf(port);
    }
    @GetMapping("/get")
    public String get(HttpSession session){
        return session.getAttribute("user")+":"+port;
    }
}
