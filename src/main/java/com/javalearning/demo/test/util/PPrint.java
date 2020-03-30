package com.javalearning.demo.test.util;

import java.util.Arrays;
import java.util.Collection;

public class PPrint {

    public static String pformat(Collection<?> c){

        if (c.size() == 0){
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        for (Object o : c) {
            if (c.size() != 1){
                sb.append("\n ");
            }
            sb.append(o);
        }

        if (c.size() != 1){ //最后一个括号换行
            sb.append("\n");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void pprint(Collection<?> c){
        System.out.println(pformat(c));
    }
    public static void pprint(Object[] objs){
        System.out.println(pformat(Arrays.asList(objs)));
    }


}
