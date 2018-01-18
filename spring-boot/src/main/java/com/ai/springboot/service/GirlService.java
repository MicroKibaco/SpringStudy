package com.ai.springboot.service;

import com.ai.springboot.domain.Girl;
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
}
