package com.skyman.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.skyman.dto.StationDto;
import com.skyman.entity.InfoStation;
import com.skyman.mapper.StationMapper;
import com.skyman.service.StationService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StationServiceImpl extends ServiceImpl<StationMapper, InfoStation> implements StationService {


    @Override
    public List<InfoStation> queryAllStation() {
        List<InfoStation> infoStations = baseMapper.selectAllStation();
        return infoStations;
    }

    @Override
    public List<InfoStation> getStationBySname(String sName) {
        List<InfoStation> stationBySname = baseMapper.getStationBySname(sName);
        return stationBySname;
    }

    @Override
    public void stationSave(StationDto stationDto) {
        baseMapper.insert(stationDto);
    }

    @Override
    public InfoStation getStationById(int sId) {
        InfoStation stationById = baseMapper.getStationById(sId);
        return stationById;
    }

    @Override
    public void stationUpdate(StationDto stationDto) {
        Map<String,Object> map = new HashMap<>();
        map.put("sid",stationDto.getSId());
        map.put("sname",stationDto.getSName());
        map.put("sprovince",stationDto.getSProvince());
        baseMapper.stationUpdate(map);
    }

    @Override
    public void stationDelete(StationDto stationDto) {
        baseMapper.deleteById(stationDto.getSId());
    }
}
