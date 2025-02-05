package com.noob.algorithm.leetcode.q501_600.q583;

/**
 * 🟡 583 两个字符串的删除操作 - https://leetcode.cn/problems/delete-operation-for-two-strings/description/
 */
public class Solution1 {
    /**
     * 思路：动态规划
     */
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        // 1.dp 定义：dp[i][j] 表示可以使得 以i-1位置结尾的字符串word1、j-1位置结尾的字符串word2 相同所需的最小步数
        int[][] dp = new int[len1 + 1][len2 + 1];

        /**
         * 2.dp 递推:
         * w1[i-1] == w2[j-1]: 字符匹配 不需要增删元素，继承上一状态 =》 dp[i][j] = dp[i-1][j-1]
         * w1[i-1] != w2[j-1]: 字符不匹配 则有3种情况讨论
         * - ① 删除w1的1个元素，然后走1步（删1个加1个让其匹配）
         * - ② 删除w2的1个元素，然后走1步（删1个加1个让其匹配）
         * - ③ 删除w1、w2，然后走2步（删掉2个，各自加1个让其匹配）
         * =》 dp[i][j] = min{dp[i-1][j]+1,dp[i][j-1]+1,dp[i-1][j-1]+2}
         */

        // 3.dp 初始化
        // 首行初始化（w1为空字符串，则w2需要删除自身长度的元素个数才能匹配空字符串）
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }

        // 首列初始化（w2为空字符串，则w1需要删除自身长度的元素个数才能匹配空字符串）
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }

        // 4.dp 构建
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + 2);
                }
            }
        }

        // 返回结果
        return dp[len1][len2];
    }

}
