package com.skyman.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.skyman.dto.ProgramDto;
import com.skyman.entity.InfoProgram;
import com.skyman.mapper.ProgramMapper;
import com.skyman.service.ProgramService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramServiceImpl extends ServiceImpl<ProgramMapper, InfoProgram> implements ProgramService {
    @Override
    public List<InfoProgram> queryAllProgram() {
        List<InfoProgram> allProgram = baseMapper.getAllProgram();
        return allProgram;
    }

    @Override
    public List<InfoProgram> getProgramBySname(String pName) {
        List<InfoProgram> proByName = baseMapper.getProByName(pName);
        return proByName;
    }

    @Override
    public void programSave(ProgramDto programDto) {
        baseMapper.insert(programDto);
    }
}
