package com.javalearning.demo.commonmistakes.equals.intandstringequal;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@Slf4j
@RequestMapping("intandstringequal")
public class IntAndStringEqualController {

    @GetMapping("stringcompare")
    public void stringcompare(){
        String a = "1";
        String b = "1";
        log.info("\nString a = \"1\";\n" +
                "String b = \"1\";\n" +
                "a == b ? {}", a == b); //true

        String c = new String("2");
        String d = new String("2");
        log.info("\nString c = new String(\"2\");\n" +
                "String d = new String(\"2\");" +
                "\nc == d ? {}", c == d); //false

        String e = new String("3").intern();
        String f = new String("3").intern();
        log.info("\nString e = new String(\"3\").intern();\n" +
                "String f = new String(\"3\").intern();" +
                "\ne == f ? {}", e == f); //true

        String h = new String("4");
        String i = new String("4");
        log.info("\nString h = new String(\"4\");\n" +
                "String i = new String(\"4\");" +
                "\nh equals i ? {}", h.equals(i)); //true
    }

    @GetMapping("intcompare")
    public void intcompare(){
        Integer a = 127;
        Integer b = 127;
        log.info("\nInteger a = 127;\n" +
                "Integer b = 127;\n" +
                "a == b ? {}", a == b); //true

        Integer c = 128;
        Integer d = 128;
        log.info("\nInteger c = 128;\n" +
                "Integer d = 128;\n" +
                "c == d ? {}", c == d); //false

        Integer e = new Integer(127);
        Integer f = new Integer(127);
        log.info("\nInteger e = new Integer(127);\n" +
                "Integer f = new Integer(127);\n" +
                "e == f ? {}", e == f); //false

        //unbox
        Integer h = 128;
        int i = 128;
        log.info("\nInteger h = 128;\n" +
                "int i = 128;\n" +
                "h == i ? {}", h == i); //true
    }

    List<String> list = new ArrayList<>();

    @GetMapping(value = "internperformance")
    public void internperformance(@RequestParam(value = "size", defaultValue = "10000000") int size){
        //-XX:+PrintStringTableStatistics
        //-XX:StringTableSize=10000000
        long begin = System.currentTimeMillis();
        list = IntStream.rangeClosed(1, size)
                .mapToObj(i -> String.valueOf(i).intern())
                .collect(Collectors.toList());

        log.info("size: {}, took: {} ms", list.size(), System.currentTimeMillis() - begin);
    }

    @PostMapping("enumcompare")
    public void enumcompare(OrderQuery orderQuery){
        StatusEnum statusEnum = StatusEnum.DELIVERED;
        log.info("订单状态为已送到：{}，==", orderQuery.getStatus() == statusEnum.status);
        log.info("订单状态为已送到：{}，equals", orderQuery.getStatus().equals(statusEnum.status));
    }

    enum StatusEnum {
        CREATED(1000, "已创建"),
        PAID(1001, "已支付"),
        DELIVERED(1002, "已送到"),
        FINISHED(1003, "已完成");

        private final Integer status;
        private final String desc;

        StatusEnum(Integer status, String desc) {
            this.status = status;
            this.desc = desc;
        }
    }
}
