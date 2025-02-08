package com.noob.algorithm.leetcode.q601_q700.q647;

/**
 * 🟡 647 回文子串 - https://leetcode.cn/problems/palindromic-substrings/description/
 */
public class Solution1 {

    /**
     * 思路分析: 模拟法（校验每个子串是否为回文串）
     */
    public int countSubstrings(String s) {
        // 特例判断
        if (s == null || "".equals(s) || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        int cnt = 0;
        // 双层循环遍历：外层控制起点，内层控制终点
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String str = s.substring(i, j + 1);
                if (isHuiWen(str)) {
                    cnt++;
                }
            }
        }
        // 返回结果
        return cnt;
    }

    // 校验回文字符串
    private boolean isHuiWen(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

}
