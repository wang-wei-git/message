package com.ww.message.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Reply {
    private Integer id;
    private String content;
    private Integer userId;
    private Integer messageId;
    private Date createTime;
}
