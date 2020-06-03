package com.javalearning.demo.commonmistakes.redundantcode.reflection;

import com.javalearning.demo.commonmistakes.redundantcode.reflection.demo.BetterBankService;
import com.javalearning.demo.commonmistakes.redundantcode.reflection.wrong.BankService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;

@Slf4j
@RestController
@RequestMapping("reflection")
public class ReflectionController {

    @Autowired
    private BetterBankService betterBankService;

    @PostMapping("/bank/createUser")
    public String createUser(@RequestBody String data) {
        log.info("createUser called with argument {}", data);
        return "1";
    }

    @PostMapping("/bank/pay")
    public String pay(@RequestBody String data) {
        log.info("pay called with argument {}", data);
        return "OK";
    }

    @GetMapping("wrong")
    public void wrong() throws IOException {
        BankService.createUser("zhuye", "xxxxxxxxxxxxxxxxxx", "13612345678", 36);
        BankService.pay(1234L, new BigDecimal("100.5"));

    }

    @GetMapping("right")
    public void right() throws IOException {
        betterBankService.createUser("zhuye", "xxxxxxxxxxxxxxxxxx", "13612345678", 36);
        betterBankService.pay(1234L, new BigDecimal("100.5"));
    }
}
