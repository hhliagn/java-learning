package com.javalearning.demo.leetcode.arrayAndstring.test;

public class addBinary {
    public String addBinary(String a, String b) {
        int m = a.length();
        int n = b.length();
        if (m<n) return addBinary(b,a);
        int max = Math.max(m, n);
        int carry = 0, j = n - 1;
        StringBuilder sb = new StringBuilder();
        for(int i = max-1; i >= 0; i--){
            if (a.charAt(i) == '1'){
                carry++;
            }
            if (j>=0 && b.charAt(j--) == '1'){
                carry++;
            }

            if (carry % 2 == 1){
                sb.append("1");
            }else {
                sb.append("0");
            }

            carry /=2;
        }
        if (carry ==1){
            sb.append("1");
        }
        sb.reverse();
        return sb.toString();
    }
}
