package com.skyman.shiro;

import com.skyman.entity.InfoLogin;
import com.skyman.service.InfoLoginService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

/**
 * 自定义Realm
 */
public class Realm extends AuthorizingRealm {

    @Autowired
    private InfoLoginService infoLoginService;

    /**
     * 执行授权逻辑
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");
        return null;
    }

    /**
     * 执行认证逻辑
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    @Bean
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证逻辑");
        /*//假设的用户名和密码，以后要从数据库里取
        String username = "123";
        String password = "123";*/

        //编写Shiro判断逻辑，判断用户名和密码
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        InfoLogin infoLogin = infoLoginService.selectInfo(token.getUsername());
        if(null == infoLogin){
           return null; //Shiro底层会自动抛出UnKnowAccountException
        }
        return new SimpleAuthenticationInfo("",infoLogin.getPassword(),"");
    }
}
