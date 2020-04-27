package com.skyman.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro的配置类--java安全框架
 */
@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //添加Shiro内置过滤器
        Map<String,String> filterMap = new LinkedHashMap<>();
        //key为资源路径，value为过滤器类型
        filterMap.put("/add","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        //修改真实的跳转页面
        shiroFilterFactoryBean.setLoginUrl("/TestController/login");
        return shiroFilterFactoryBean;
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("realm") Realm realm){
        DefaultWebSecurityManager d = new DefaultWebSecurityManager();
        //关联Realm
        d.setRealm(realm);
        return d;
    }

    @Bean(name = "realm")
    public Realm getRealm(){
        return new Realm();
    }
}
