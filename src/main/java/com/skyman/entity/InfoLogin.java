package com.skyman.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("info_login")
public class InfoLogin extends Model<InfoLogin> {

    private static final long serialVersionUID = 1L;

    @TableId("ID")
    private int id;

    @TableField("USERNAME")
    private String username;
    @TableField("PASSWORD")
    private String password;
    @TableField("ROLE")
    private String role;
    @TableField("SEX")
    private String sex;
    @TableField("EMAIL")
    private String email;
    @TableField("PHONE")
    private String phone;
    @TableField("ADDRESS")
    private String address;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
