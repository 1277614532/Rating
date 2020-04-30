package com.skyman.controller;

import com.skyman.base.ExceptionEnum;
import com.skyman.base.ResultEntity;
import com.skyman.base.ResultUtil;
import com.skyman.dto.ProgramDto;
import com.skyman.entity.InfoProgram;
import com.skyman.service.ProgramService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/ProgramController")
public class ProgramController {

    @Autowired
    private ProgramService programService;

    @GetMapping(value = "infoProgram")
    public String infoProgram(){
        return "program/listProgram";
    }

    @GetMapping(value = "selectAllProgram")
    @ResponseBody
    public ResultEntity selectAllProgram(){
        List<InfoProgram> infoPrograms = programService.queryAllProgram();
        return ResultUtil.success("OK",infoPrograms);
    }

    @GetMapping(value = "programAdd")
    public String programAdd(Model model){
        model.addAttribute(new InfoProgram());
        return "program/programAdd";
    }

    @PostMapping(value = "programSave")
    @ResponseBody
    public ResultEntity programSave(ProgramDto programDto){
        List<InfoProgram> programBySname = programService.getProgramBySname(programDto.getPName());
        //判断是否存在重复的节目名
        if(programBySname != null && programBySname.size() != 0){
            return ResultUtil.error(ExceptionEnum.PNAME_REPEAT.getCode(),ExceptionEnum.PNAME_REPEAT.getMsg());
        }else{
            programService.programSave(programDto);
            return ResultUtil.success();
        }

    }

    @GetMapping(value = "programEdit")
    public String programEdit(Model model, InfoProgram infoProgram){
        InfoProgram programById = programService.getProgramById(infoProgram.getPId());
        if(programById != null){
            model.addAttribute(programById);
        }
        return "program/programEdit";
    }

    @PutMapping(value = "programUpdate")
    @ResponseBody
    public ResultEntity programUpdate(ProgramDto programDto){
        List<InfoProgram> programBySname = programService.getProgramBySname(programDto.getPName());
        //判断是否存在重复的用户名和电话
        if(programBySname != null && programBySname.size() != 0 && !(programBySname.get(0).getPName().equals(programDto.getPName()))){
            return ResultUtil.error(ExceptionEnum.PNAME_REPEAT.getCode(),ExceptionEnum.PNAME_REPEAT.getMsg());
        }else{
            programService.programUpdate(programDto);
            return ResultUtil.success();
        }

    }

    @PostMapping(value = "programDelete")
    @ResponseBody
    public ResultEntity programDelete(ProgramDto programDto){
        programService.programDelete(programDto);
        return ResultUtil.success();
    }
}
