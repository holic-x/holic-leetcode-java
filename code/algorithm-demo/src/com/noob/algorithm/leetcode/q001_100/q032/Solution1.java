package com.noob.algorithm.leetcode.q001_100.q032;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 🔴 032 最长有效括号 - https://leetcode.cn/problems/longest-valid-parentheses/
 */
public class Solution1 {
    /**
     * 思路分析：遍历每个子串，校验子串是否有有效括号序列，记录有效括号序列的最大长度
     */
    public int longestValidParentheses(String s) {
        int n = s.length();
        int maxLen = 0;
        // 分割子串
        for (int i = 0; i < n - 1; i++) {
            for (int j = i; j < n; j++) {
                String subStr = s.substring(i, j + 1);
                if (valid(subStr)) {
                    maxLen = Math.max(maxLen, subStr.length());
                }
            }
        }
        // 返回结果
        return maxLen;
    }

    // 校验子串是否为有效括号序列
    private boolean valid(String str) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        // 借助栈辅助遍历
        Stack<Character> stack = new Stack<>();
        // 遍历子串
        for (char ch : str.toCharArray()) {
            // 如果符号为右括号，则从栈中取出元素进行匹配
            if (map.containsKey(ch)) {
                // 判断栈是否为空，如果为空则说明不匹配
                if (stack.isEmpty()) {
                    return false;
                }
                if (map.get(ch) != stack.pop()) {
                    return false;
                }
            } else {
                // 如果为左括号则入栈
                stack.push(ch);
            }
        }
        // 遍历结束，如果栈为空则说明括号序列完全匹配
        return stack.isEmpty();
    }
}
