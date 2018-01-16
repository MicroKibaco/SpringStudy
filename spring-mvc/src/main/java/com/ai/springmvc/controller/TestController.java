package com.ai.springmvc.controller;

import com.ai.springmvc.bean.Admin;
import com.ai.springmvc.bean.User;
import com.ai.springmvc.bean.UserListForm;
import com.ai.springmvc.bean.UserMapForm;
import com.ai.springmvc.bean.UserSetForm;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class TestController {
    // Todo: http://localhost:8080/baseType.do?xage=10
    @RequestMapping(value = "baseType.do")
    @ResponseBody
    public String baseType(@RequestParam("xage") int age) {
        return "age: " + age;
    }

    // Todo: http://localhost:8080/baseType2.do?age=10
    @RequestMapping(value = "baseType2.do")
    @ResponseBody
    public String baseType2(Integer age) {
        return "age2: " + age;
    }

    // Todo: http://localhost:8080/array.do?name=Tom&name=Yang
    @RequestMapping(value = "array.do")
    @ResponseBody
    public String array(String[] name) {
        StringBuffer sbf = new StringBuffer();
        for (String item : name) {
            sbf.append(item).append(" ");
        }
        return sbf.toString();
    }

    // Todo: http://localhost:8080/object.do?name=Tom&name=Yang&contactInfo.phone=10086
    @RequestMapping(value = "object.do")
    @ResponseBody
    public String object(User user, Admin admin) {
        return user.toString() + admin.toString();
    }

    // Todo: http://localhost:8080/object.do?user.name=Tom&admin.name=Yang&admin.contactInfo.phone=10086
    @InitBinder("user")
    public void initUser(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("user.");
    }

    @InitBinder("admin")
    public void initAdmin(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("admin.");
    }

    // Todo: http://localhost:8080/list.do?users[0].name=Tom&users[1].name=MicroKibaco
    @RequestMapping(value = "list.do")
    @ResponseBody
    public String list(UserListForm userListForm) {
        return "listSize: " + userListForm.getUsers().size() + "  " + userListForm.toString();
    }

    // Todo: http://localhost:8080/set.do?users[0].name=Tom&users[1].name=MicroKibaco
    @RequestMapping(value = "set.do")
    @ResponseBody
    public String set(UserSetForm usersetform) {
        return usersetform.toString();
    }

    // Todo: http://localhost:8080/map.do?users['X'].name=Tom&users['X'].age=10&users['Y'].name=Lucy
    @RequestMapping(value = "map.do")
    @ResponseBody
    public String map(UserMapForm userMapForm) {
        return userMapForm.toString();
    }

    // application/json
    @RequestMapping(value = "json.do")
    @ResponseBody
    public String json(@RequestBody User user) {
        return user.toString();
    }

    // application/xml
    @RequestMapping(value = "xml.do")
    @ResponseBody
    public String xml(@RequestBody Admin admin) {
        return admin.toString();
    }

    // Todo: http://localhost:8080/date1.do?date1=2017-01-01
    @RequestMapping(value = "date1.do")
    @ResponseBody
    public String date1(Date date1){
        return date1.toString();
    }

    @InitBinder("date1")
    public void initDate1(WebDataBinder binder){
        binder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
    }

}
