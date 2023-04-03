package com.ww.message.pojo;

import lombok.Data;

import java.util.Date;
//留言

@Data
public class Message {
    private Integer id;
    private String content;
    private Integer userId;
    private Date createTime;
}
