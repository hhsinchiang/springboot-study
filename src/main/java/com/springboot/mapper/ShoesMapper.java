package com.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.bean.Shoes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ShoesMapper extends BaseMapper {

//    @Select("select * from shoes where #{id} = id")
    Shoes getShoeById(Integer id);

    List<Shoes> getAllShoe();

    void insertShoe(Shoes shoe);
}
