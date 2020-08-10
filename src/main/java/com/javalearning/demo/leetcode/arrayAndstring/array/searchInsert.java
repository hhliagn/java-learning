package com.javalearning.demo.leetcode.arrayAndstring.array;

public class searchInsert {

    public static int searchInsert(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        int ans = 0;

        while (left <= right){
            int mid = (right - left) / 2 + left;

            if (target > nums[mid]){
                left = mid + 1;
            }else if (target < nums[mid]){
                ans = mid;
                right = mid - 1;
            }
        }

        return ans;

//        int n = nums.length;
//        int left = 0, right = n - 1, ans = n;
//        while (left <= right) {
//            int mid = ((right - left) >> 1) + left;
//            if (target <= nums[mid]) {
//                ans = mid;
//                right = mid - 1;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return ans;


    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 7;
        System.out.println(searchInsert(nums, target));
    }
}
