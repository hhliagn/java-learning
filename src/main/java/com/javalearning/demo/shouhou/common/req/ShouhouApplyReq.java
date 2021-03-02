package com.javalearning.demo.shouhou.common.req;

import lombok.Data;

import java.util.List;

@Data
public class ShouhouApplyReq {

    private String orderNo;
    private Integer companyId;
    private ApplyReason reason;
    private Long amt;
    private List<ApplyItem> items;

    enum ApplyReason{
        SEVENDAY, QUALITY_ISSUES
        ;
    }

    @Data
    public class ApplyItem {
        private Integer orderItemId;
        private Integer num;
    }
}
