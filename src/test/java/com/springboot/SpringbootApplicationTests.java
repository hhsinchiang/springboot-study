package com.springboot;

import com.springboot.bean.User;
import com.springboot.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootApplicationTests {

    @Autowired
    UserService userService ;

    @Test
    void contextLoads() {

        User user = userService.getUserByUsername("9");
        System.out.println(user);
    }

}
