package com.ai.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    // http://localhost:8080/baseType.do?xage=10
    @RequestMapping(value = "baseType.do")
    @ResponseBody
    public String baseType(@RequestParam("xage") int age) {
        return "age: " + age;
    }
    // http://localhost:8080/baseType.do?xage=10
    @RequestMapping(value = "baseType2.do")
    @ResponseBody
    public String baseType2(Integer age) {
        return "age2: " + age;
    }
}
