package com.skyman.entity;

import org.springframework.stereotype.Component;

import java.text.DecimalFormat;

@Component
public class DayTotal {
    String p_sration;
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

    public String getP_sration() {
        return p_sration;
    }

    public void setP_sration(String p_sration) {
        this.p_sration = p_sration;
    }

    public int getP_clicks() {
        return p_clicks;
    }

    public void setP_clicks(int p_clicks) {
        this.p_clicks = p_clicks;
    }

    int p_clicks;
    public DayTotal(){}
    public DayTotal(String p_sration, int p_clicks,String p_name,String  p_desc) {
        this.p_sration = p_sration;
        this.p_clicks = p_clicks;
        this.p_name=p_name;
        this.p_desc=p_desc;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("00.00");
        return "<br/>{" +
                "频道='" + p_sration.split("-")[1]  + '\'' +", 节目：\""+p_name +
                "\", 节目描述：\""+p_desc+"\""+
                ", 收视率：\""+df.format(rating)+"%  \"}<br/>";
    }
}
