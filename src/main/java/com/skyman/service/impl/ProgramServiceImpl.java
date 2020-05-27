package com.skyman.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.skyman.dto.ProgramDto;
import com.skyman.entity.InfoProgram;
import com.skyman.mapper.DayTotalMapper;
import com.skyman.mapper.ProgramMapper;
import com.skyman.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProgramServiceImpl extends ServiceImpl<ProgramMapper, InfoProgram> implements ProgramService {

    @Autowired
    private DayTotalMapper dayTotalMapper;

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

    public String far(ProgramDto programDto){
        String pClicks = programDto.getPClicks();
        Long aLong = dayTotalMapper.countAllDayTotal();
        Long lo = Long.parseLong(pClicks);   //将前端获取的点播次数转换为Long
        Long los = aLong+lo;
        //String str = lo*1.0/los + "";
        String format = String.format("%.2f", lo * 1.0 / los);
        return format;
    }

    @Override
    public void programSave(ProgramDto programDto) {
        String format = far(programDto);
        programDto.setPRating(format);
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
        map.put("pclicks",programDto.getPClicks());
        String format = far(programDto);
        map.put("prating",format);
        baseMapper.programUpdate(map);
    }

    @Override
    public void programDeleteByStation(String string) {
        baseMapper.deleteByStation(string);
    }
}
