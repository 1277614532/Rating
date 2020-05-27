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
    @Select({"select p_station,  p_clicks,p_name,p_desc from info_program "})
    List<DayTotal> getAllDayTotal();
    @Select("select `p_station`, p_clicks ,`p_name`,`p_desc` FROM info_program WHERE unix_timestamp(`p_time`) BETWEEN unix_timestamp(#{time})  AND  unix_timestamp(#{time2})  ")
    List<DayTotal> getDayTotal(@Param("time") String time, @Param("time2") String time2);
    @Select({"select sum(p_clicks)  p_clicks from info_program " })
    Long countAllDayTotal();
    //如果参数date满足yyyy-MM-dd HH:mm:ss形式，则可以直接unix_timestamp(string date) 得到参数对应的时间戳
    //或者满足yyyy-MM-dd形式
    @Select({"select  sum(p_clicks)  FROM info_program WHERE unix_timestamp(`p_time`) BETWEEN unix_timestamp(#{time})  AND  unix_timestamp(#{time2}) "})
    Long countAllDayTotalByTime(@Param("time") String time, @Param("time2") String time2);
    @Select("SELECT COUNT(*)  FROM (SELECT  DISTINCT  `p_name` FROM `info_program` WHERE `p_station` LIKE '${p_name}%') `name`")
    Long countTvName(@Param("p_name") String p_name);
}