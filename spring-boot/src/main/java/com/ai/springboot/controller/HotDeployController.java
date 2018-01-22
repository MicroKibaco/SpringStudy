package com.ai.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HotDeployController {


    @RequestMapping(value = "/say",method = RequestMethod.GET)
    public String say(HttpServletRequest request){
        request.setAttribute("say","HotDeployController");
        return "index";

    }

}
