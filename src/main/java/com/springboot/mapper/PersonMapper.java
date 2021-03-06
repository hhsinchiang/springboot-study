package com.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.bean.Person;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PersonMapper extends BaseMapper<Person> {
    Person getPersonById(Integer id);

    List<Person> getAllPerson();
}
