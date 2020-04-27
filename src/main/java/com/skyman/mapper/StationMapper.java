package com.skyman.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.skyman.entity.InfoStation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StationMapper extends BaseMapper<InfoStation> {

    List<InfoStation> selectAllStation();

    List<InfoStation> getStationBySname(String sName);
}
