package com.javalearning.demo.guava.ordering;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    public static void main(String[] args) {

        Double d0 = 2.0;
        System.out.println(String.format("%.2f", d0));

        Integer num = 1;
        System.out.println(round(num.doubleValue(), 2));

//        System.out.println(b);
//        double t = 1.00;
//        DecimalFormat format = new DecimalFormat("0.00");
//        String format1 = format.format(num.doubleValue());
//        System.out.println(Double.parseDouble(format1));

//        double v3 = num.doubleValue() * 1.000;
//        System.out.println(v3);

//        BigDecimal bigDecimal3 = new BigDecimal(String.valueOf(v3));
//        BigDecimal bigDecimal4 = bigDecimal3.setScale(2, RoundingMode.HALF_UP);
//        double v5 = bigDecimal4.doubleValue();
//        System.out.println(v5);

//        String format0 = String.valueOf(v3);
//        double v4 = Double.valueOf(format0);
//        System.out.println(v3);
//        System.out.println(format0);
//        System.out.println(v4);

        BigDecimal bigDecimal3 = new BigDecimal(num).setScale(2, RoundingMode.HALF_UP);
        System.out.println(bigDecimal3 + "," + Double.valueOf(bigDecimal3.toString()));

        double d = 1.2354;

        // 默认是四舍五入的
        double v = Double.parseDouble(String.format("%f", d));
        double v0 = Double.parseDouble(String.format("%.2f", d));
        double v1 = Double.parseDouble(String.format("%.3f", d));
        double v2 = Double.parseDouble(String.format("%.4f", d));

        //考虑正负的情况
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(d));
        BigDecimal bigDecimal0 = bigDecimal.setScale(2, RoundingMode.DOWN); //两边都是收缩的
        System.out.println(bigDecimal0);

        bigDecimal = new BigDecimal(String.valueOf(d));
        BigDecimal bigDecimal1 = bigDecimal.setScale(2, RoundingMode.CEILING); //向大的方向扩展
        System.out.println(bigDecimal1);

        bigDecimal = new BigDecimal(String.valueOf(d));
        BigDecimal bigDecimal2 = bigDecimal.setScale(2, RoundingMode.FLOOR); //向小的方向扩展
        System.out.println(bigDecimal2);

        System.out.println("---------");

        System.out.println(v);
        System.out.println(v0);
        System.out.println(v1);
        System.out.println(v2);


//        Ordering<String> ordering = new Ordering<String>() {
//            @Override
//            public int compare(@Nullable String s, @Nullable String t1) {
//                return Ints.compare(s.length(), t1.length());
//            }
//        };
//
//        List<String> list = new ArrayList<>();
//        list.add("a");
//        list.add("bb");
//        list.add(null);
//        list.add("ccc");
//        list.add("zz");
//        list.add("y");
//        System.out.println(list);


//        Collections.sort(list, ordering);
//        System.out.println(list);


//        Comparator<String> comparator = new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return Ints.compare(o1.length(), o2.length());
//            }
//        };
//
//        Ordering<String> from = Ordering.from(comparator);
//        Collections.sort(list, from);
//        System.out.println(list);


//        Ordering<Comparable> natural = Ordering.natural();
//        Collections.sort(list, natural);
//        System.out.println(list);


//        Ordering<Object> usingToString = Ordering.usingToString();
//        Collections.sort(list, usingToString);
//        System.out.println(list);


//        Ordering<Comparable> reverse = Ordering.natural().reverse();
//        Collections.sort(list, reverse);
//        System.out.println(list);


//        Ordering<Comparable> nullsFirst = Ordering.natural().nullsFirst();
//        Collections.sort(list, nullsFirst);
//        System.out.println(list);


//        Ordering<Comparable> nullLast = Ordering.natural().nullsLast();
//        Collections.sort(list, nullLast);
//        System.out.println(list);


        // NPE
//        Ordering<Comparable> hasNull = Ordering.natural();
//        Collections.sort(list, hasNull);
//        System.out.println(list);


//        Ordering<String> natural = Ordering.natural();
//        Ordering<Iterable<String>> lexicographical = natural.lexicographical();
//        Collections.sort(list, lexicographical);
//        System.out.println(list);
    }
}
