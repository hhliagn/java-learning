package com.javalearning.demo.leetcode.string;

public class addBinary {
    public String addBinary(String a, String b) {
        //从尾部开始
        //怎么连接
        //要连接什么
        //标志位怎么得出来
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i>=0 || j>=0){
            int sum = carry;
            if (i>=0) sum+= a.charAt(i--) - '0';
            if (j>=0) sum+= b.charAt(j--) - '0';
            sb.append(sum%2);
            carry = sum/2;
        }
        if (carry!=0) sb.append(carry);
        return sb.reverse().toString();
    }

    public String addBinary2(String a, String b) {
        return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
    }
}
