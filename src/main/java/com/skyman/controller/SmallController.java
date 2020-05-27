package com.skyman.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/SmallController")
public class SmallController {

    @GetMapping(value = "helloo")
    public  String test(){
        return "small/helloo";
    }

    @GetMapping(value = "indexx")
    public  String indexx(){
        return "small/indexx";
    }

    @GetMapping(value = "infoProgram")
    public String infoProgram(){
        return "small/listProgramm";
    }

    @GetMapping(value = "infoStation")
    public String infoStation(){
        return "small/listStationn";
    }
}
