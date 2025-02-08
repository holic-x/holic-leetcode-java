package com.noob.algorithm.leetcode.q501_600.q583;

/**
 * 🟡 583 两个字符串的删除操作 - https://leetcode.cn/problems/delete-operation-for-two-strings/description/
 */
public class Solution2 {
    /**
     * 思路：动态规划(基于最长公共子序列的思路扩展)：
     * x为两个字符串word1、word2的最长公共子序列，则使得word1、word2达到相同的操作的最小步数为（len1+len2）- 2*x
     */
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        // 1.dp 定义：dp[i][j] 表示以i-1位置结尾的word1、以j-1位置结尾的word2的最长公共子序列长度
        int[][] dp = new int[len1 + 1][len2 + 1];

        /**
         * 2.dp 递推: 根据w1[i-1]与w2[j-1]的值是否相同来分情况讨论
         * w1[i-1]==w2[j-1]: 从左上方推导 =》dp[i][j] = dp[i-1][j-1] + 1
         * w1[i-1]!=w2[j-1]: 从左侧、上侧推导得到maxLen =》dp[i][j] = max{dp[i][j-1],dp[i-1][j]}
         */

        // 3.dp 初始化
        // 首行初始化（w1为空字符串，最长公共子序列长度只能为0）
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = 0;
        }

        // 首列初始化（w2为空字符串，最长公共子序列长度只能为0）
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = 0;
        }

        // 4.dp 构建
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        // 返回结果(len1+len2-2*x)
        return len1 + len2 - 2 * dp[len1][len2];
    }

}
