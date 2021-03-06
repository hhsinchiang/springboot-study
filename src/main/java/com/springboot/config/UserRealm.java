package com.springboot.config;

import com.springboot.bean.User;
import com.springboot.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("执行了授权！");

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //info.addStringPermission("user:level1");

        //拿到当前的登录的这个对象
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User) subject.getPrincipal();//拿到当前user对象
        info.addStringPermission(currentUser.getPerms());
        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行了认证！");

//        String name = "root";
//        String password = "123456";

        UsernamePasswordToken userToken = (UsernamePasswordToken) token;

        //链接数据库
        User user = userService.getUserByUsername(((UsernamePasswordToken) token).getUsername());


        if(user==null){
            return null;//抛出异常 UnknownAccountException
        }

        //密码认证,shiro做

        return new SimpleAuthenticationInfo(user,user.getPassword(),"");
    }
}
