package com.javalearning.demo.lambda;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class demo9 {

    /**
     * IntStream、LongStream 和 DoubleStream 等流的类中，有个非常有用的方法叫做 summaryStatistics() 。可
     * 以返回 IntSummaryStatistics、LongSummaryStatistics 或者 DoubleSummaryStatistic s，描述流中元素的各种
     * 摘要数据。在本例中，我们用这个方法来计算列表的最大值和最小值。它也有 getSum() 和 getAverage() 方法来获
     * 得列表的所有元素的总和及平均值。
     */
    public static void main(String[] args) {
        //获取数字的个数、最小值、最大值、总和以及平均值
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics statistics = primes.stream().mapToInt(x -> x).summaryStatistics();

        int min = statistics.getMin();
        int max = statistics.getMax();
        long sum = statistics.getSum();
        double average = statistics.getAverage();

        System.out.println("min: " + min);
        System.out.println("max: " + max);
        System.out.println("sum: " + sum);
        System.out.println("average: " + average);
    }
}
