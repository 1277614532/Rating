package com.skyman.controller;

import com.skyman.entity.InfoLogin;
import com.skyman.service.InfoLoginService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



//@RestController
@Controller
@Slf4j
@RequestMapping("/TestController")
public class TestController {

    @Autowired
    private InfoLoginService infoLoginService;

    @GetMapping(value = "hello")
    public  String test(){
        //log.info("hello!!!");
        return "hello";
    }

    @GetMapping(value = "add")
    public  String add(){
        return "add";
    }

    @GetMapping(value = "login")
    public  String login(){
        return "login";
    }

    @GetMapping(value = "infoLogin")
    public  String infoLogin(){
        return "infoLogin";
    }

    @GetMapping(value = "index")
    public  String index(HttpServletRequest request, Model model){
        String username = request.getParameter("username");
        model.addAttribute("username",username);
        return "index";
    }

    @PostMapping(value = "login")
    public String login(String username, String password, Model model){

        //使用Shiro进行认证处理
        //1.获取subject
        Subject subject = SecurityUtils.getSubject();
        //2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        /*if(true){
            model.addAttribute("username",username);
            return "index";
        }*/
        //3.执行登录方法
        try {
            subject.login(token);
            InfoLogin infoLogin = infoLoginService.selectInfo(username);
            String str = "admin";
            if (str.equals(infoLogin.getRole())){       //防止空指针
                return "redirect:/TestController/infoLogin";
            }else {
                return "redirect:/TestController/index";
            }

        } catch (UnknownAccountException e) {
            model.addAttribute("msg","用户名不存在");
            return "login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误");
            return "login";
        }


    }

}
