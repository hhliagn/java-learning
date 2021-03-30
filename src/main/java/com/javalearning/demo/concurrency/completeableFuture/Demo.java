package com.javalearning.demo.concurrency.completeableFuture;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author lhh
 * @date 2021/3/30
 */
public class Demo {

    public static void main(String[] args) {
        List<Supplier<List<Men>>> suppliers = new ArrayList<>();
        suppliers.add(Demo::getMens);
        List<Men> results = CFUtils.query(suppliers, 3);
        System.out.println(results);
    }

    public static List<Men> getMens() {
        return Lists.newArrayList();
    }
}
