package com.skyman.service;

import com.baomidou.mybatisplus.service.IService;
import com.skyman.dto.ProgramDto;
import com.skyman.entity.InfoProgram;

import java.util.List;

public interface ProgramService extends IService<InfoProgram> {
    List<InfoProgram> queryAllProgram();

    List<InfoProgram> getProgramBySname(String pName);

    void programSave(ProgramDto programDto);

    void programDelete(ProgramDto programDto);

    InfoProgram getProgramById(int pId);

    void programUpdate(ProgramDto programDto);

    void programDeleteByStation(String string);
}
