package com.javalearning.demo.jichu;

public class demo2 {

    public static void main(String[] args) {
        int n = 50; //初始饮料总数
        int i = 0; //兑换次数
        while (true) {
            n -= 3; //喝 3 瓶
            n++; //兑换 1 瓶
            i++; //兑换次数+1
            if (n < 3) {
                System.out.println("共喝了" + (50 + i) + "瓶");
                break;
            }
        }
    }
}
