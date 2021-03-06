package com.springboot.controller;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Controller
public class RestController {

    HttpServletRequest httpServletRequest;



    @GetMapping(value = "/testREST/{id}")
    public String getUserById(@PathVariable("id")Integer id){
        System.out.println("testREST-id="+id);
        return "hello";

    }


    @PostMapping(value = "/testREST")
    public String addUser(){
        //System.out.println(httpServletRequest.getParameter("_method"));
        System.out.println("进入add");
        System.out.println("testPOST!");
        return "hello";

    }


    @PutMapping(value = "/testREST")
    public String updateUser(){
//        System.out.println(httpServletRequest.getParameter("_method"));
        System.out.println("进入update");
        System.out.println("testPUT!!!!");
        return "hello";

    }

    @DeleteMapping(value = "/testREST/{id}")
    public String deleteUserById(@PathVariable("id")Integer id){
       // System.out.println(httpServletRequest.getParameter("_method"));
        System.out.println("进入delete");
        System.out.println("testDelete!!!!id="+id);
        return "hello";

    }

}
