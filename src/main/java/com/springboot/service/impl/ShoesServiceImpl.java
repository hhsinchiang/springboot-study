package com.springboot.service.impl;

import com.springboot.bean.Shoes;
import com.springboot.mapper.ShoesMapper;
import com.springboot.service.ShoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoesServiceImpl implements ShoesService {

    @Autowired(required = false)
   private ShoesMapper shoesMapper;

    @Override
    public Shoes getShoeById(Integer id) {
        Shoes shoes = shoesMapper.getShoeById(id);
        return shoes;
    }

    @Override
    public List<Shoes> getAllShoe() {
        return shoesMapper.getAllShoe();
    }

    @Override
    public void insertShoe(Shoes shoes) {
        shoesMapper.insertShoe(shoes);
    }

}
