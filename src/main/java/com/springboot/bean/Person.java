package com.springboot.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private Integer id;
    private String name;
    private String address;
    private Integer age;
    @TableField(exist = false)
    private List<Dog> dogList;
//    private List<Shoes> shoesList;
}
