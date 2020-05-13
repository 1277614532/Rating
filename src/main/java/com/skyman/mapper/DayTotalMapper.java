package com.skyman.mapper;

import com.skyman.entity.DayTotal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface DayTotalMapper {
    @Select({"select p_sration,  p_clicks,p_name,p_desc from info_program_copy "})
    List<DayTotal> getAllDayTotal();
    @Select("select `p_sration`, p_clicks ,`p_name`,`p_desc` FROM info_program_copy WHERE unix_timestamp(`p_time`) BETWEEN unix_timestamp(#{time})  AND  unix_timestamp(#{time2})  ")
    List<DayTotal> getDayTotal(@Param("time") String time, @Param("time2") String time2);
    @Select({"select sum(p_clicks)  p_clicks from info_program_copy " })
    Long countAllDayTotal();
    @Select({"select  sum(p_clicks)  FROM info_program_copy WHERE unix_timestamp(`p_time`) BETWEEN unix_timestamp(#{time})  AND  unix_timestamp(#{time2}) "})
    Long countAllDayTotalByTime(@Param("time") String time, @Param("time2") String time2);
    @Select("SELECT COUNT(*)  FROM (SELECT  DISTINCT  `p_name` FROM `info_program_copy` WHERE `p_sration` LIKE '${p_name}%') `name`")
    Long countTvName(@Param("p_name") String p_name);
}