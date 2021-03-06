package com.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.bean.Dog;
import com.springboot.bean.Person;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DogMapper extends BaseMapper {
    Dog getDogById(Integer id);
}
