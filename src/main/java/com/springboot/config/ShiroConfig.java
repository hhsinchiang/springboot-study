package com.springboot.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);

        //添加shiro的内置过滤器
        /*
            anon: 无需认证就可以访问
            authc: 必须认证才能访问
            user: 必须拥有 记住我 功能才能用
            perms: 拥有对某个资源的权限才能访问
            role: 拥有某个角色权限才能访问
         */

        //拦截
        Map<String,String> filterMap = new LinkedHashMap<>();



        //认证
        filterMap.put("/level1","authc");
        filterMap.put("/level2","authc");

        //授权
        filterMap.put("/level1","perms[user:level1]");
        filterMap.put("/level2","perms[user:level2]");

        bean.setFilterChainDefinitionMap(filterMap);


        //设置登录的请求
        bean.setLoginUrl("/toLogin");
        return bean;
    }



    @Bean(name="securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

        //关联userRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }



    //创建realm对象，需要自定义类
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }
}
