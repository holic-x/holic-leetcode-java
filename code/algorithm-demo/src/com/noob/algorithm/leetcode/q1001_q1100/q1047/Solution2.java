package com.noob.algorithm.leetcode.q1001_q1100.q1047;

/**
 * 🟢 1047 删除字符串中的所有相邻重复项 - https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string/description/
 */
public class Solution2 {

    /**
     * 概要：删除两个相邻且相同的字母
     * 思路分析：StringBuffer模拟栈
     */
    public String removeDuplicates(String s) {
        // 定义StringBuffer模拟栈
        StringBuffer buffer = new StringBuffer();
        int topIdx = -1; // 模拟栈顶指针
        for (char ch : s.toCharArray()) {
            if (topIdx != -1) {
                // 校验栈顶元素和当前遍历元素
                char top = buffer.charAt(topIdx);
                if (top == ch) {
                    // 删除元素
                    buffer.deleteCharAt(topIdx);
                    topIdx--;
                } else {
                    buffer.append(ch);
                    topIdx++;
                }
            } else {
                buffer.append(ch);
                topIdx++;
            }
        }

        // 返回结果
        return buffer.toString();
    }
}
