package com.skyman.controller;

import com.skyman.base.ExceptionEnum;
import com.skyman.base.ResultEntity;
import com.skyman.base.ResultUtil;
import com.skyman.dto.UserDto;
import com.skyman.entity.InfoLogin;
import com.skyman.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/UserController")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "selectAllUser")
    @ResponseBody
    public ResultEntity loginInfo(@RequestParam(required = false,defaultValue = "") String content){
        if(content.equals("")){
            List<InfoLogin> allUser = userService.selectAllUser();
            return ResultUtil.success("OK",allUser);
        }else {
            List<InfoLogin> userByLike = userService.getUserByLike(content);
            return ResultUtil.success("OK",userByLike);
        }
    }

    /*@GetMapping(value = "fuzzySearch")
    public ResultEntity fuzzySearch(@RequestParam(required = false,defaultValue = "") String content){
        if(content.equals("")){
            return ResultUtil.error(ExceptionEnum.PARAMETER_MISSING.getCode(),ExceptionEnum.PARAMETER_MISSING.getMsg());
        }else {
            List<InfoLogin> userByLike = userService.getUserByLike(content);
            return ResultUtil.success("OK",userByLike);
        }
    }*/

    @GetMapping(value = "userAdd")
    public String userAdd(Model model){
        model.addAttribute(new InfoLogin());
        return "user/userAdd";
    }

    @PostMapping(value = "userSave")
    @ResponseBody
    public ResultEntity userSave(UserDto userDto){
//        userDto.setPassword(MD5.crypt(userDto.getPassword()));
//        userDto.setRole("普通用户");
        List<InfoLogin> byPhone = userService.getUserByPhone(userDto.getPhone());
        List<InfoLogin> byUsername = userService.getUserByUsername(userDto.getUsername());
        //判断是否存在重复的用户名和电话
        if(byPhone != null && byPhone.size() != 0){
            return ResultUtil.error(ExceptionEnum.PHONE_REPEAT.getCode(),ExceptionEnum.PHONE_REPEAT.getMsg());
        }else if(byUsername != null && byUsername.size() != 0){
            return ResultUtil.error(ExceptionEnum.USERNAME_REPEAT.getCode(),ExceptionEnum.USERNAME_REPEAT.getMsg());
        }else{
            userService.userSave(userDto);
            return ResultUtil.success();
        }

    }

    @GetMapping(value = "userEdit")
    public String userEdit(Model model,InfoLogin infoLogin){
        InfoLogin userById = userService.getUserById(infoLogin.getId());
        if(userById != null){
            model.addAttribute(userById);
        }
        return "user/userEdit";
    }

    @PutMapping(value = "userUpdate")
    @ResponseBody
    public ResultEntity userUpdate(UserDto userDto){
//        userDto.setPassword(MD5.crypt(userDto.getPassword()));
//        userDto.setRole("普通用户");
        List<InfoLogin> byPhone = userService.getUserByPhone(userDto.getPhone());
        List<InfoLogin> byUsername = userService.getUserByUsername(userDto.getUsername());
        //判断是否存在重复的用户名和电话
        if(byPhone != null && byPhone.size() != 0 && !(byPhone.get(0).getPhone().equals(userDto.getPhone()))){
            return ResultUtil.error(ExceptionEnum.PHONE_REPEAT.getCode(),ExceptionEnum.PHONE_REPEAT.getMsg());
        }else if(byUsername != null && byUsername.size() != 0 && !(byUsername.get(0).getUsername().equals(userDto.getUsername()))){
            return ResultUtil.error(ExceptionEnum.USERNAME_REPEAT.getCode(),ExceptionEnum.USERNAME_REPEAT.getMsg());
        }else{
            userService.userUpdate(userDto);
            return ResultUtil.success();
        }

    }

    @PostMapping(value = "userDelete")
    @ResponseBody
    public ResultEntity userDelete(UserDto userDto){
            userService.userDelete(userDto);
            return ResultUtil.success();
    }
}
