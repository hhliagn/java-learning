package com.javalearning.demo.leetcode.string;

public class longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        //先把第一个看作结果
        //从第二个开始找，indexOf返回零就是找到
        //没找到就把原来的削掉尾部继续找，没法再减就返回
        //找到立马跳到下一个，同样的方法去找
        if (strs.length==0){
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix)!=0){
                prefix = prefix.substring(0,prefix.length()-1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}
