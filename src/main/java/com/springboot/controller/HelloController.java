package com.springboot.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@ResponseBody
@Controller
public class HelloController {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/hello")
    public String hello(Model model){

        String key = stringRedisTemplate.opsForValue().get("hello");


        stringRedisTemplate.opsForValue().increment("hello",1);

        String key1 = stringRedisTemplate.opsForValue().get("hello");
        model.addAttribute("number",key1);
       return "hello";
    }


    @RequestMapping("/login")
    public String login(String username,String password,Model model){
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户的登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);

        try {
            subject.login(token);//执行登录方法，如果没有异常则通过
            return "hello";
        } catch (UnknownAccountException e) {
            model.addAttribute("msg","用户名错误！");
            return "login";
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("msg", "密码错误！");
            return "login";
        }
    }



    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/level1")
    public String level1(){
        return "level1";
    }

    @RequestMapping("/level2")
    public String level2(){
        return "level2";
    }


    @RequestMapping("/rest")
    public String rest(){

        return "rest";
    }


    @RequestMapping("/testParam")
    public String testParam(){

        return "param";
    }

}
