package com.skyman.controller;

import com.skyman.base.ExceptionEnum;
import com.skyman.base.ResultEntity;
import com.skyman.base.ResultUtil;
import com.skyman.dto.StationDto;
import com.skyman.entity.InfoStation;
import com.skyman.service.ProgramService;
import com.skyman.service.StationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/StationController")
public class StationController {

    @Autowired
    private StationService stationService;
    @Autowired
    private ProgramService programService;

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

    @GetMapping(value = "stationEdit")
    public String stationEdit(Model model, InfoStation infoStation){
        InfoStation stationById = stationService.getStationById(infoStation.getSId());
        if(stationById != null){
            model.addAttribute(stationById);
        }
        return "station/stationEdit";
    }

    @PutMapping(value = "stationUpdate")
    @ResponseBody
    public ResultEntity stationUpdate(StationDto stationDto){
        List<InfoStation> stationBySname = stationService.getStationBySname(stationDto.getSName());
        //判断是否存在重复的用户名
        if(stationBySname != null && stationBySname.size() != 0 && !(stationBySname.get(0).getSName().equals(stationDto.getSName()))){
            return ResultUtil.error(ExceptionEnum.SNAME_REPEAT.getCode(),ExceptionEnum.SNAME_REPEAT.getMsg());
        }else{
            stationService.stationUpdate(stationDto);
            return ResultUtil.success();
        }

    }

    @PostMapping(value = "stationDelete")
    @ResponseBody
    @Transactional
    public ResultEntity stationDelete(StationDto stationDto){
        InfoStation stationById = stationService.getStationById(stationDto.getSId());
        programService.programDeleteByStation(stationById.getSName());
        stationService.stationDelete(stationDto);
        return ResultUtil.success();
    }
}
