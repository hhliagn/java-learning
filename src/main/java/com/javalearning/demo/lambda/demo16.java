package com.javalearning.demo.lambda;

import java.util.Arrays;
import java.util.function.Predicate;

public class demo16 {

    /**
     * 有时候我们需要对某种类型的数据进行判断，从而得到一个boolean值结果。这时可以使用`java.util.function.Predicate<T>`接口。
     */
    public static void main(String[] args) {
        String[] array = { "迪丽热巴,女", "古力娜扎,女",
                "马尔扎哈,男", "赵丽颖,女" };

        // 条件1：必须是女生
        Predicate<String> one = s -> s.split(",")[1].equals("女");
        // 条件2：姓名必须是4个字
        Predicate<String> two = s -> s.split(",")[0].length() == 4;

        Arrays.stream(array).filter(one.and(two)).forEach(n -> System.out.println(n));
    }
}
