package com.javalearning.demo.test.temp111.twopointer.fastslow;

public class minSubArrayLen {
    //定义一个累加数sum，从0到n遍历开始累加
    //循环检视sum>s，成立则减掉左边的数，得到一个最小长度，继续循环
    //不满足则加上右边的数，再通过检视
    public static int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while (sum >= s){
                res = Math.min(res, i+1-left);
                sum -= nums[left++];
            }
        }
        return res == Integer.MAX_VALUE?0:res;
    }

    public static void main(String[] args) {
        int[] a = new int[]{12,28,83,4,25,26,25,2,25,25,25,12};
        int i = minSubArrayLen(213, a);
        System.out.println(i);
    }
}
