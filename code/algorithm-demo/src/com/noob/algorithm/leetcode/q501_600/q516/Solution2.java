package com.noob.algorithm.leetcode.q501_600.q516;

/**
 * 🟡 516 最长回文子序列 - https://leetcode.cn/problems/longest-palindromic-subsequence/description/
 */
public class Solution2 {

    /**
     * 回文：动态规划
     */
    public int longestPalindromeSubseq(String s) {
        int maxLen = 0;

        int n = s.length();
        // 1.dp[i][j] 表示[i,j]区间范围的字符串的最长回文子序列
        int[][] dp = new int[n][n];

        /**
         * 2.dp 递推
         * 此处基于回文子序列的概念，即是满足回文的前提下进行递推
         * -- 根据s[i]\s[j]是否相同来分情况讨论
         * - s[i]==s[j] 可以加入这两个字符来构成更长的回文串：dp[i][j] = dp[i+1][j-1] + 2
         * - s[i]!=s[j] 则考虑加入哪个字符串来构成更长的回文串
         * - 加入s[i] dp[i][j] = dp[i][j-1]
         * - 加入s[j] dp[i][j] = dp[i+1][j]
         */

        // 3.dp 初始化
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1; // 元素本身是一个回文串
        }

        // 4.dp 构建（构建顺序：从下往上，从左往右）
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
                // 更新max
                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }
        // 返回结果
        // return maxLen;
        // 返回结果(遍历顺序是从下往上，从左往右，因此第一行的最后一个元素为结果)
        return dp[0][n - 1];
    }

}
