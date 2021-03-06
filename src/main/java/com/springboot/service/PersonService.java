package com.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.springboot.bean.Person;
import com.springboot.bean.Shoes;

import java.util.List;

public interface PersonService extends IService<Person> {
    public Person getPersonById(Integer id);

    public List<Person> getAllPerson();
//    public List<Shoes> getAllShoe();
//
//    public void insertShoe(Shoes shoes);
}
