package com.skyman.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.skyman.dto.ProgramDto;
import com.skyman.entity.InfoProgram;
import com.skyman.mapper.ProgramMapper;
import com.skyman.service.ProgramService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public void programDelete(ProgramDto programDto) {
        baseMapper.deleteById(programDto.getPId());
    }

    @Override
    public InfoProgram getProgramById(int pId) {
        InfoProgram programById = baseMapper.getProgramById(pId);
        return programById;
    }

    @Override
    public void programUpdate(ProgramDto programDto) {
        Map<String,Object> map = new HashMap<>();
        map.put("pid",programDto.getPId());
        map.put("pname",programDto.getPName());
        map.put("pstation",programDto.getPStation());
        map.put("ptime",programDto.getPTime());
        map.put("pdesc",programDto.getPDesc());
        baseMapper.programUpdate(map);
    }

    @Override
    public void programDeleteByStation(String string) {
        baseMapper.deleteByStation(string);
    }
}
