package com.skyman.controller;

import com.skyman.base.ExceptionEnum;
import com.skyman.base.ResultEntity;
import com.skyman.base.ResultUtil;
import com.skyman.dto.StationDto;
import com.skyman.entity.InfoStation;
import com.skyman.service.StationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/StationController")
public class StationController {

    @Autowired
    private StationService stationService;

    @GetMapping(value = "infoStation")
    public String infoStation(){
        return "station/listStation";
    }

    @GetMapping(value = "selectAllStation")
    @ResponseBody
    public ResultEntity selectAllStation(){
        List<InfoStation> infoStations = stationService.queryAllStation();
        return ResultUtil.success("OK",infoStations);
    }

    @GetMapping(value = "stationAdd")
    public String stationAdd(Model model){
        model.addAttribute(new InfoStation());
        return "station/stationAdd";
    }

    @PostMapping(value = "stationSave")
    @ResponseBody
    public ResultEntity stationSave(StationDto stationDto){
        List<InfoStation> stationBySname = stationService.getStationBySname(stationDto.getSName());
        //判断是否存在重复的卫视名
        if(stationBySname != null && stationBySname.size() != 0){
            return ResultUtil.error(ExceptionEnum.SNAME_REPEAT.getCode(),ExceptionEnum.SNAME_REPEAT.getMsg());
        }else{
            stationService.stationSave(stationDto);
            return ResultUtil.success();
        }

    }
}
