package com.springboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.bean.Person;
import com.springboot.mapper.PersonMapper;
import com.springboot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper,Person> implements PersonService{

    @Autowired(required = false)
    PersonMapper personMapper;

    @Override
    public Person getPersonById(Integer id) {
        return personMapper.getPersonById(id);
    }

    @Override
    public List<Person> getAllPerson() {
        return personMapper.getAllPerson();
    }
}
