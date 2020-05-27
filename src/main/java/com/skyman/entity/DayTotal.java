package com.skyman.entity;

import org.springframework.stereotype.Component;

import java.text.DecimalFormat;

@Component
public class DayTotal {
    String p_station;
    double rating;
    String p_name;
    String p_desc;

    public void setP_desc(String p_desc) {
        this.p_desc = p_desc;
    }

    public String getP_desc() {
        return p_desc;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public double getRating(long count){
        rating=p_clicks*100.00/count;
        return rating;
    }

    public double getRating() {
        return rating;
    }

    public String getP_station() {
        return p_station;
    }

    public void setP_station(String p_station) {
        this.p_station = p_station;
    }

    public int getP_clicks() {
        return p_clicks;
    }

    public void setP_clicks(int p_clicks) {
        this.p_clicks = p_clicks;
    }

    int p_clicks;
    public DayTotal(){}
    public DayTotal(String p_station, int p_clicks,String p_name,String  p_desc) {
        this.p_station = p_station;
        this.p_clicks = p_clicks;
        this.p_name=p_name;
        this.p_desc=p_desc;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("00.00");
        return "<br/>{" +
                "频道='" + p_station.split("-")[1]  + '\'' +", 节目：\""+p_name +
                "\", 节目描述：\""+p_desc+"\""+
                ", 收视率：\""+df.format(rating)+"%  \"}<br/>";
    }
}
