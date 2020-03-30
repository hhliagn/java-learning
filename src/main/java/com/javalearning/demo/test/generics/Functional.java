package com.javalearning.demo.test.generics;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

interface Combiner<T>{
    T combine(T t1, T t2);
}
interface UnaryFunction<R, T>{
    R function(T x);
}
interface Collector<T> extends UnaryFunction<T, T>{
    T result();
}
interface UnaryPredicate<T>{
    boolean test(T t);
}
public class Functional {
    public static <T> T reduce(Iterable<T> it, Combiner<T> combiner){
        Iterator<T> iterator = it.iterator();
        if (iterator.hasNext()){
            T result = iterator.next();
            while (iterator.hasNext()){
                result = combiner.combine(result, iterator.next());
            }
            return result;
        }
        return null;
    }

    public static <R, T> List<R> transform(Iterable<T> seq, UnaryFunction<R, T> func){
        List<R> result = new ArrayList<>();
        for (T t : seq) {
            R function = func.function(t);
            result.add(function);
        }
        return result;
    }

    public static <T> Collector<T> forEach(Iterable<T> seq, Collector<T> func){
        for (T t : seq) {
            func.function(t);
        }
        return func;
    }

    public static <T> List<T> fliter(Iterable<T> seq, UnaryPredicate<T> func){
        List<T> result = new ArrayList<>();
        for (T t : seq) {
            if (func.test(t)){
                result.add(t);
            }
        }
        return result;
    }

    //classes
    static class IntegerAdder implements Combiner<Integer>{

        @Override
        public Integer combine(Integer t1, Integer t2) {
            return t1 + t2;
        }
    }

    static class IntegerSubtracter implements Combiner<Integer>{

        @Override
        public Integer combine(Integer t1, Integer t2) {
            return t1 - t2;
        }
    }

    static class BigDecimalAdder implements Combiner<BigDecimal>{

        @Override
        public BigDecimal combine(BigDecimal t1, BigDecimal t2) {
            return t1.add(t2);
        }
    }

    static class BigIntegerAdder implements Combiner<BigInteger>{

        @Override
        public BigInteger combine(BigInteger t1, BigInteger t2) {
            return t1.add(t2);
        }
    }

    static class AtomicLongAdder implements Combiner<AtomicLong>{

        @Override
        public AtomicLong combine(AtomicLong t1, AtomicLong t2) {
            return new AtomicLong(t1.addAndGet(t2.get()));
        }
    }

    static class BigDemicalUlp implements UnaryFunction<BigDecimal, BigDecimal>{

        @Override
        public BigDecimal function(BigDecimal x) {
            return x.ulp();
        }
    }

    static class GraterThan<T extends Comparable<T >> implements UnaryPredicate<T>{

        private T bound;
        GraterThan(T bound){
            this.bound = bound;
        }
        @Override
        public boolean test(T t) {
           return t.compareTo(bound) > 0;
        }
    }

    static class MultiplyingIntegerCollector implements Collector<Integer>{

        private Integer value = 1;
        @Override
        public Integer function(Integer x) {
            value *= x;
            return value;
        }

        @Override
        public Integer result() {
            return value;
        }
    }

    public static void main(String[] args) {

        List<Integer> li = Arrays.asList(1,2,3,4,5,6,7);

        Integer result = reduce(li, new IntegerAdder());
        System.out.println(result);

        result = reduce(li, new IntegerSubtracter());
        System.out.println(result);

        System.out.println(fliter(li, new GraterThan<Integer>(4)));

        System.out.println(forEach(li, new MultiplyingIntegerCollector()).result());

        System.out.println(forEach(fliter(li, new GraterThan<Integer>(4)), new MultiplyingIntegerCollector()).result());

        //....
    }
}
