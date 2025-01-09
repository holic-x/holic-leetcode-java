package com.noob.algorithm.leetcode.q1101_q1200.q1143;

/**
 * 🟡 1143 最长公共子序列
 */
public class Solution1 {
    /**
     * 思路分析：动态规划思路
     */
    public int longestCommonSubsequence(String text1, String text2) {
        // 1.dp 定义：长度为[0, i - 1]的字符串text1与长度为[0, j - 1]的字符串text2的最长公共子序列为dp[i][j]
        int m = text1.length() + 1, n = text2.length() + 1;
        int[][] dp = new int[m + 1][n + 1];

        /**
         * 2.dp 递推：dp[i][j]推导的基础是基于text1[i-1]与text2[j-1]的值判断
         * - ① text1[i-1]=text2[j-1]：说明当前校验字符匹配，进行累加 =》 dp[i][j] = dp[i-1][j-1] + 1
         * - ② text1[i-1]！=text2[j-1]：说明当前校验字符不匹配，则基于其左侧或者上方的状态选择最大值继承 =》 dp[i][j] = max{dp[i][j-1],dp[i-1][j]}
         */

        // 3.dp 初始化(对第0行、第0列进行初始化)
        for (int j = 0; j < n; j++) {
            dp[0][j] = 0; // 此时text1字符串为空，因此最长公共序列为0
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 0; // 此时text2字符串为空，因此最长公共序列为0
        }

        // 4.dp 构建
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        // 返回结果(最右下角的数是继承前面的状态的，因此最大)
        return dp[m - 1][n - 1];
    }

}
