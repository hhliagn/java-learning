package com.javalearning.demo.concurrency.thread_pool.split_task;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.Date;

@Data
@JsonNaming
public class OrderInfo {

    private Integer orderId;
    private Integer companyId;
    private Integer userId;
    private Date createTime;
}
