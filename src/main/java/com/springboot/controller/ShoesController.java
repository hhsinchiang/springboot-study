package com.springboot.controller;

import com.springboot.bean.Shoes;
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
public class ShoesController {

    @Autowired
    ShoesService shoesService;


    @GetMapping("/shoe/{id}")

    public Shoes getShoeById(@PathVariable Integer id){
       return shoesService.getShoeById(id);
    }


    @GetMapping("/getAllShoes")
    @ResponseBody
    public List<Shoes> getAllShoes(){
        return shoesService.getAllShoe();
    }


    @PostMapping("/shoe")
    public int insertShoe(Shoes shoe){
        shoesService.insertShoe(shoe);
        return shoe.getId();
    }

}
