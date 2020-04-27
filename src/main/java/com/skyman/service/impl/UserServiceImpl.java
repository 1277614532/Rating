package com.skyman.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.skyman.dto.UserDto;
import com.skyman.entity.InfoLogin;
import com.skyman.mapper.UserMapper;
import com.skyman.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, InfoLogin> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void userSave(UserDto userDto) {
        baseMapper.insert(userDto);
    }

    @Override
    public List<InfoLogin> selectAllUser() {
        List<InfoLogin> allUser = baseMapper.selectAllUser();
        return allUser;
    }

    @Override
    public List<InfoLogin> getUserByLike(String str) {
        List<InfoLogin> userByLike = baseMapper.getUserByLike(str);
        return userByLike;
    }

    @Override
    public List<InfoLogin> getUserByPhone(String phone) {
        List<InfoLogin> userByPhone = userMapper.getUserByPhone(phone);
        return userByPhone;
    }

    @Override
    public List<InfoLogin> getUserByUsername(String username) {
        List<InfoLogin> userByUsername = userMapper.getUserByUsername(username);
        return userByUsername;
    }

    @Override
    public InfoLogin getUserById(int id) {
        InfoLogin userById = userMapper.getUserById(id);
        return userById;
    }


    @Override
    public void userUpdate(UserDto userDto) {
        Map<String,Object> map = new HashMap();
        map.put("username",userDto.getUsername());
        map.put("phone",userDto.getPhone());
        map.put("email",userDto.getEmail());
        map.put("address",userDto.getAddress());
        baseMapper.userUpdate(map);
    }


}
