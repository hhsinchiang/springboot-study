package com.springboot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Shoes {
    private Integer id;
    private String name;
    private String color;
    private String brand;
    private Integer price;
    private List<Person> personList;
}
