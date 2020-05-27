package com.skyman.controller;


import com.skyman.entity.City;
import com.skyman.entity.DayTotal;
import com.skyman.mapper.DayTotalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller

public class MapController {
    @Autowired
    private DayTotalMapper service;
    @RequestMapping("/")
    public String Index(){
        return  "statistics/bmap";
    }

    @RequestMapping(value="/allmap-data",method= RequestMethod.GET,produces="application/json")
    @ResponseBody
    public List<City> getAllDateTotal(){
        HashMap<String, City>map=new HashMap<>();
        List<DayTotal> list=service.getAllDayTotal();
        Long count=service.countAllDayTotal();
        if(count==null||count<=0)return new ArrayList<>();

        list.forEach(x->{
            x.getRating(count);
            String[] addres =x.getP_station().split("-");
            if(map.containsKey(addres[0])){
               City city= map.get(addres[0]);
               city.setValue(x.getRating());
               city.setInfo(city.getInfo()+x.toString());
            }else {
                City city=new City(addres[0], x.getRating());
                city.setNum( service.countTvName(addres[0]));
                city.setInfo(x.toString());
                map.put(addres[0],city);
            }
        });

        return new ArrayList<>(map.values());
    }
    @RequestMapping(value="/map-data",method= RequestMethod.GET,produces="application/json")
    @ResponseBody
    public List<DayTotal> getDateTotal(@RequestParam("startCreatetime")String startCreatetime,
                                                    @RequestParam("endCreatetime")String endCreatetime){

        try {
            System.out.println(startCreatetime+"  "+endCreatetime);
            List<DayTotal> list=service.getDayTotal(startCreatetime,endCreatetime);
            Long count=service.countAllDayTotalByTime(startCreatetime,endCreatetime);
            if(count==null||count<=0)return new ArrayList<>();
            list.forEach(x->x.getRating(count));
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    @RequestMapping(value = "/table")

    public String Table(){
        return  "statistics/tablemap";
    }
}
