package com.javalearning.demo.test.enumerated;

import com.javalearning.demo.test.util.Enums;

enum SecurityCategory {

    STOCK(Security.Stock.class),
    BOND(Security.BOND.class)
    ;

    SecurityCategory(Class<? extends Security> tClass){
        values = tClass.getEnumConstants();
    }

    private Security[] values;

    interface Security {
        enum Stock implements Security {
            A, B, C
        }

        enum BOND implements Security {
            X, Y, Z
        }
    }

    public Security randomSelection(){
        return Enums.random(values);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            SecurityCategory category = Enums.random(SecurityCategory.class);
            Security security = category.randomSelection();
            System.out.println(category + ": " + security);
        }
    }


}
