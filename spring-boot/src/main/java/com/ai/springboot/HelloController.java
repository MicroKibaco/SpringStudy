package com.ai.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private GirlProperties mGirlProperties;

    // @RequestMapping(value = {"/say"})
    @GetMapping(value = "/say")
    public String say(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
        return "id: " + id;
    }

}
