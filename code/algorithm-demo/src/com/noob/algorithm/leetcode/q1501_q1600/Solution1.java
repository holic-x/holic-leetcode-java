package com.noob.algorithm.leetcode.q1501_q1600;

/**
 * 🟢 1556. 千位分隔数 - https://leetcode.cn/problems/thousand-separator/description/
 */
public class Solution1 {

    /**
     * 给你一个整数 n，请你每隔三位添加点（即 "." 符号）作为千位分隔符，并将结果以字符串格式返回
     */
    public String thousandSeparator(int n) {
        StringBuffer ans = new StringBuffer();
        // 将n转化为字符串形式
        String nStr = String.valueOf(n);
        char[] nArr = nStr.toCharArray();
        // 逆序遍历nStr内容，每隔3位添加分隔符
        int cnt = 0; // 计数器
        for (int i = nArr.length - 1; i >= 0; i--) {
            ans.insert(0, nArr[i]);
            cnt++;
            // 校验分隔符
            if (cnt % 3 == 0 && i != 0) {
                // 计数达到3，添加分隔符号
                ans.insert(0, '.');
            }
        }
        // 返回结果
        return ans.toString();
    }
}
