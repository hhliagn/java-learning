package com.javalearning.demo.operate_log.controlle;

import com.google.gson.Gson;
import com.javalearning.demo.operate_log.anno.OperateLog;
import com.javalearning.demo.operate_log.anno.OperateType;
import com.javalearning.demo.operate_log.param.AddOrderParam;
import com.javalearning.demo.operate_log.resp.OryxResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class OrderController {

    private static Gson gson = new Gson();

    @OperateLog(type = OperateType.ORDER_ADD)
    @PostMapping("/api/order/add")
    public OryxResponse addOrder(@RequestBody AddOrderParam addOrderParam){
        Integer res = 200;
        return OryxResponse.success(res);
    }

    @OperateLog(type = OperateType.GET_ORDER_LIST)
    @GetMapping("/api/order/findByIds")
    public OryxResponse addOrder(@RequestParam List<Integer> ids){
        Integer res = 200;
        return OryxResponse.success(res, OryxResponse.LogContent.build(gson.toJson(ids)));
    }

    @OperateLog(type = OperateType.ORDER_DELIVER)
    @GetMapping("/api/order/deliver")
    public OryxResponse importOrder(@RequestParam Integer companyId, @RequestParam String orderNo){
        Integer res = 200;
        return OryxResponse.success(res, OryxResponse.LogContent.build(orderNo));
    }

    @OperateLog(type = OperateType.ORDER_IMPORT)
    @PostMapping("/api/order/import")
    public OryxResponse importOrder(@RequestBody MultipartFile file){
        Integer res = 200;
        return OryxResponse.success(res, OryxResponse.LogContent.build(file.getOriginalFilename()));
    }
}
