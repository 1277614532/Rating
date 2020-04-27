package com.skyman.service;

import com.baomidou.mybatisplus.service.IService;
import com.skyman.dto.StationDto;
import com.skyman.entity.InfoStation;

import java.util.List;

public interface StationService extends IService<InfoStation> {
    List<InfoStation> queryAllStation();

    List<InfoStation> getStationBySname(String sName);

    void stationSave(StationDto stationDto);
}
