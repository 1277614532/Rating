package com.skyman.service;

import com.baomidou.mybatisplus.service.IService;
import com.skyman.dto.UserDto;
import com.skyman.entity.InfoLogin;

import java.util.List;

public interface UserService extends IService<InfoLogin> {

    void userSave(UserDto userDto);

    List<InfoLogin> selectAllUser();

    List<InfoLogin> getUserByPhone(String phone);

    List<InfoLogin> getUserByUsername(String username);

    void userUpdate(UserDto userDto);

    InfoLogin getUserById(int id);

    List<InfoLogin> getUserByLike(String str);
}
