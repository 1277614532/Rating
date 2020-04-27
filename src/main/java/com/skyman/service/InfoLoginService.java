package com.skyman.service;

import com.baomidou.mybatisplus.service.IService;
import com.skyman.entity.InfoLogin;


public interface InfoLoginService extends IService<InfoLogin> {

    InfoLogin selectInfo(String username);

}
