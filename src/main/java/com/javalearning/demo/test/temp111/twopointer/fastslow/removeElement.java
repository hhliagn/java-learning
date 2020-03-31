package com.javalearning.demo.test.temp111.twopointer.fastslow;

public class removeElement {
    //定义两个指针，一个快指针每次前移一步，另一个慢指针只在需要的时候前移一步
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
