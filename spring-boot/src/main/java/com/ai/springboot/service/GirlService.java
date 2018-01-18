package com.ai.springboot.service;

import com.ai.springboot.domain.Girl;
import com.ai.springboot.enums.ResultEnum;
import com.ai.springboot.exception.GirlException;
import com.ai.springboot.repository.GirlRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GirlService {

    @Autowired
    private GirlRepository mGirlRepository;

    @Transactional
    public void insertTwo() {
        Girl a = new Girl();
        a.setCupSize("A");
        a.setAge(18);
        mGirlRepository.save(a);

        Girl b = new Girl();
        b.setCupSize("B");
        b.setAge(19);
        mGirlRepository.save(b);
    }

    public void getAge(Integer id) throws Exception {
        Girl girl = mGirlRepository.findOne(id);
        Integer age = girl.getAge();
        if (age < 10) {
            // "返回,你还在上小学吧"
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        } else if (age > 10 && age < 16) {
            // "返回,你可能在上初中"
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL );
        }
    }
}
