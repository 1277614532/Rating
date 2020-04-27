package com.skyman.base;


import lombok.Data;

import java.io.Serializable;

@Data
public class ResultEntity implements Serializable {

    private int count;
    private Integer code;
    private String msg;
    private Object data;


    public ResultEntity() {
    }

    public ResultEntity(int count, Integer code, String msg, String data) {
        this.count = count;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultEntity(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }



}
