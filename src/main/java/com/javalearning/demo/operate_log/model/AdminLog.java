package com.javalearning.demo.operate_log.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class AdminLog {
    private Integer companyId;
    private Integer operateUserId;
    private String ip;
    private String operateType;
    private String content;
    private Date createdAt;
}
