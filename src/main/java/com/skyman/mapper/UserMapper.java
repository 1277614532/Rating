package com.skyman.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.skyman.entity.InfoLogin;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper extends BaseMapper<InfoLogin>{

    List<InfoLogin> selectAllUser();

    List<InfoLogin> getUserByPhone(String phone);

    List<InfoLogin> getUserByUsername(String username);

    InfoLogin getUserById(int id);

    void userUpdate(Map<String,Object> map);

    List<InfoLogin> getUserByLike(String param);
}
