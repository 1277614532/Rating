package com.skyman.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.skyman.entity.InfoLogin;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoLoginMapper extends BaseMapper<InfoLogin> {

    InfoLogin selectInfos(String username);


}
