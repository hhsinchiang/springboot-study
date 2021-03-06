package com.springboot.service.impl;

import com.springboot.bean.Dog;
import com.springboot.bean.Person;
import com.springboot.mapper.DogMapper;
import com.springboot.mapper.PersonMapper;
import com.springboot.service.DogService;
import com.springboot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DogServiceImpl implements DogService {

    @Autowired
    DogMapper dogMapper;


    @Override
    public Dog getDogById(Integer id) {
        return dogMapper.getDogById(id);
    }
}
