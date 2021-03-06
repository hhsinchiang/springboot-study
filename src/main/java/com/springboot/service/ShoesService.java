package com.springboot.service;

import com.springboot.bean.Shoes;

import java.util.List;

public interface ShoesService {
    public Shoes getShoeById(Integer id);

    public List<Shoes> getAllShoe();

    public void insertShoe(Shoes shoes);
}
