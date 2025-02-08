package com.noob.algorithm.leetcode.q101_200.q115;

/**
 * 🔴 115 不同的子序列 - https://leetcode.cn/problems/distinct-subsequences/description/
 */
public class Solution1 {
    /**
     * 动态规划法：判断s的子序列中t出现的个数（即s是source、t是target）
     */
    public int numDistinct(String s, String t) {
        // 字符串长度定义
        int sLen = s.length(), tLen = t.length();
        // 1.dp 定义：dp[i][j] 表示以下标i-1结尾的字符串s的子序列中出现 以下标j-1结尾的字符串t的个数 为dp[i][j]
        int[][] dp = new int[sLen + 1][tLen + 1];

        /**
         * 2.dp 递推：基于s可以通过删除字符得到t的思路去分析，判断s[i-1]与t[j-1]是否匹配，然后判断是否通过s[i-1]匹配分情况讨论
         * ① s[i-1]==t[j-1]: 以s:bagg、t:bag为例
         * - 匹配s[i-1]（例如s[0]s[1]s[3]组成）即不考虑当前s子串和t子串的最后一位字母的情况
         * - 不匹配s[i-1](例如s[0]s[1]s[2]组成)
         * =》 dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
         * ② s[i-1]!=t[j-1]: dp[i][j] = dp[i-1][j]
         */

        // 3.dp 初始化
        // 首行初始化
        dp[0][0] = 1; // 空字符串s可以删除任意元素，其在空字符串t中出现的个数为1
        for (int j = 0; j <= tLen; j++) {
            dp[0][j] = 0; // 空字符串s可以删除任意元素，其无法构成以j-1结尾的t，因此个数为0
        }
        // 首列初始化：以i-1结尾的字符串s可以通过删除元素构成空字符串
        for (int i = 0; i <= sLen; i++) {
            dp[i][0] = 1;
        }

        // 4.dp 构建
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= tLen; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // 返回结果
        return dp[sLen][tLen];

    }

}
