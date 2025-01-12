package com.noob.algorithm.leetcode.q001_100.q005;

/**
 * 🟡 005 最长回文子串 - https://leetcode.cn/problems/longest-palindromic-substring/
 */
public class Solution1 {

    /**
     * 双重检索；校验每个子串是否为回文串，记录最长回文子串长度值
     */
    public String longestPalindrome(String s) {
        int maxLen = 1;
        String maxHuiwenStr = "";
        // 构建循环，校验每个子串
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String subStr = s.substring(i, j + 1); // i为起点，j为终点
                if (isHuiWen(subStr)) {
                    if (subStr.length() >= maxLen) {
                        maxLen = Math.max(maxLen, j - i + 1); // 最大回文串长度更新
                        maxHuiwenStr = subStr;
                    }
                }
            }
        }
        // 返回结果
        return maxHuiwenStr;
    }

    // 校验指定范围字符串是否为回文子串
    private boolean isHuiWen(String str) {
        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }

}
