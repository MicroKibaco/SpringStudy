package com.ai.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
// Said this is a controller, when the request will be scan to see if there is match RequestMapping
@RequestMapping("/hello") // Said mapping routing, said here is /hello/index
public class HelloMvcController {
    // http://localhost:8888/hello/home
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String index(HttpServletRequest request) {
        return "home"; //  表示使用的模版是index，也就是 webapp/index.jsp
    }
}