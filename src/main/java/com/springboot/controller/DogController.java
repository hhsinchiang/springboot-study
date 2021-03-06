package com.springboot.controller;

import com.springboot.bean.Dog;
import com.springboot.bean.Person;
import com.springboot.service.DogService;
import com.springboot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class DogController {

    @Autowired(required = false)
    DogService dogService;


    @GetMapping("/dog/{id}")
    public Dog getDogById(@PathVariable Integer id){
       return dogService.getDogById(id);
    }


}
