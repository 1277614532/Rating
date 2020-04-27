package com.skyman.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("info_station")
public class InfoStation extends Model<InfoStation> {

    private static final long serialVersionUID = 1L;

    @TableId("S_ID")
    private int sId;

    @TableField("S_NAME")
    private String sName;
    @TableField("S_PROVINCE")
    private String sProvince;

    @Override
    protected Serializable pkVal() {
        return this.sId;
    }
}
