package com.ai.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GirlController {
    @Autowired
    private GirlRepository mGirlRepository;

    @Autowired
    private GirlService mGirlService;

    /**
     * 查询女生所有列表
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
        return mGirlRepository.findAll();
    }

    /**
     * 新增女生列表
     */
    @PostMapping(value = "/girls")
    public Girl girlAdd(@RequestParam("cupSize") String cupSize,
                        @RequestParam("age") Integer age) {

        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return mGirlRepository.save(girl);
    }

    // 查询女生
    @GetMapping(value = "/girls/{id}")

    public Girl findGirlOne(@PathVariable("id") Integer id) {
        return mGirlRepository.findOne(id);
    }

    // 更新
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id, @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return mGirlRepository.save(girl);
    }

    // 删除
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id) {
        mGirlRepository.delete(id);
    }

    // 通过年龄查询女生列表
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age) {
        return mGirlRepository.findByAge(age);
    }

    @PostMapping(value = "/girls/two")
    public void girlTwo() {
        mGirlService.insertTwo();
    }


}
