package com.springboot.controller;

import com.springboot.bean.Person;
import com.springboot.bean.Shoes;
import com.springboot.service.PersonService;
import com.springboot.service.ShoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
public class PersonController {

    @Autowired(required = false)
    PersonService personService;


    @GetMapping("/person/{id}")
    public Person getPersonById(@PathVariable Integer id){
       return personService.getPersonById(id);
    }


    @GetMapping("/allPerson")
    public List<Person> getAllPersonByPlus(){
        return personService.list();
    }



    @GetMapping("/person")
    public List<Person> getAllPerson(){
        return personService.getAllPerson();
    }


//    @GetMapping("/getAllShoes")
//    @ResponseBody
//    public List<Shoes> getAllShoes(){
//        return shoesService.getAllShoe();
//    }
//
//
//    @PostMapping("/shoe")
//    public int insertShoe(Shoes shoe){
//        shoesService.insertShoe(shoe);
//        return shoe.getId();
//    }

}
