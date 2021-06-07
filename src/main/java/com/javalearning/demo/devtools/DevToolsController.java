package com.javalearning.demo.devtools;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author lhh
 * @date 2021/5/17
 */
@RestController
public class DevToolsController {

    @GetMapping("/testDevToolHotSwap")
    public String testDevToolHotSwap() {
        return "OK_swap_new_kas_222";
    }

    public static void main(String[] args) {

        BigDecimal estimatedIncomeB = new BigDecimal("1.5");
        BigDecimal goodsCommissionRateB = new BigDecimal("0.14");

        BigDecimal amtCommissionB = estimatedIncomeB.divide(goodsCommissionRateB, 0, RoundingMode.DOWN);

        System.out.println(amtCommissionB.longValue());
    }
}
