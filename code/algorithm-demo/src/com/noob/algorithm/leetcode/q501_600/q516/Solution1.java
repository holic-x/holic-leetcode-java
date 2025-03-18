package com.noob.algorithm.leetcode.q501_600.q516;

/**
 * 🟡 516 最长回文子序列
 */
public class Solution1 {

    /**
     * 回文：模拟法
     * 校验每个子序列，看其是否符合回文
     * ❌ 此处错误的问题主要在于将其处理成子串回文串概念，但实际题目要求是子序列（要求可以通过删除字符获取到回文串）
     * 例如`bbbab` 如果是最大回文子串答案为3、最大回文子序列则应该为4
     */
    public int longestPalindromeSubseq(String s) {
        int maxLen = 0;
        // 校验子序列
        for (int i = 0; i < s.length(); i++) { // i 起点
            for (int j = i; j < s.length(); j++) { // j终点
                String subStr = s.substring(i, j + 1);
                if (isHuiwen(s, i, j)) {
                    maxLen = Math.max(maxLen, subStr.length());
                }
            }
        }
        // 返回结果
        return maxLen;
    }

    // 校验回文
    private boolean isHuiwen(String s, int left, int right) {
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            // 指针移动
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
//        String s = "cbbd";
        String s = "bbbab";
        Solution1 sol = new Solution1();
        sol.longestPalindromeSubseq(s);
    }
}
