package com.skyman.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.skyman.entity.InfoProgram;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgramMapper extends BaseMapper<InfoProgram> {
    List<InfoProgram> getAllProgram();

    List<InfoProgram> getProByName(String pname);
}
