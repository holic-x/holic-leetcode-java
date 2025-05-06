package com.noob.algorithm.leetcode.q001_100.q020;

/**
 * 🟢 020 有效的括号 - https://leetcode.cn/problems/valid-parentheses/description/
 */
public class Solution3 {

    /**
     * 概要：限定字符串序列s只包括括号字符，给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效
     * 思路分析：替换法
     */
    public boolean isValid(String s) {

        while(s.contains("{}") || s.contains("()") || s.contains("[]")){
            // 替换括号对为空字符串
            s = s.replace("{}","");
            s = s.replace("()","");
            s = s.replace("[]","");
        }

        // 如果括号对全部被替换则说明字符串有效
        return s.isEmpty();
    }
}
