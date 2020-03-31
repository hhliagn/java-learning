package com.javalearning.demo.lambda;

import java.util.function.Supplier;

public class demo13 {

    /**
     * Supplier<T> : 生产者，负责生产数据。
     * 	抽象方法：T get(); 返回指定类型的数据
     */
    public static void main(String[] args) {
        String s = testSupplier(() -> "hello world");
        System.out.println(s);

        int[] arr = {1,1313,13,13143};
        Integer max_out = testSupplier(() -> {
            int max = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
            return max;
        });
        System.out.println(max_out);
    }

    public static <T> T testSupplier(Supplier<T> supplier){
        return supplier.get();
    }
}
