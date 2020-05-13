package com.skyman.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("info_program")
public class InfoProgram extends Model<InfoProgram> {

    private static final long serialVersionUID = 1L;
    @TableId("P_ID")
    private int pId;

    @TableField("P_NAME")
    private String pName;
    @TableField("P_STATION")
    private String pStation;
    @TableField("P_TIME")
    private String pTime;
    @TableField("P_DESC")
    private String pDesc;
    @TableField("P_CLICKS")
    private String pClicks;
    @TableField("P_RATING")
    private String pRating;

    @Override
    protected Serializable pkVal() {
        return this.pId;
    }
}
