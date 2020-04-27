package com.skyman.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import com.skyman.mapper.InfoLoginMapper;
import com.skyman.entity.InfoLogin;
import com.skyman.service.InfoLoginService;
import org.springframework.stereotype.Service;

@Service
public  class InfoLoginServiceImpl extends ServiceImpl<InfoLoginMapper , InfoLogin> implements InfoLoginService {


    @Override
    public InfoLogin selectInfo(String username) {
        InfoLogin infoLogin = baseMapper.selectInfos(username);
        return infoLogin;
    }


}
