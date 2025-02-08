package com.noob.algorithm.leetcode.q001_100.q072;

/**
 * 🟡 072 编辑距离 - https://leetcode.cn/problems/edit-distance/description/
 */
public class Solution1 {

    /**
     * 思路分析：动态规划
     */
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        // 1.dp 定义：dp[i][j] 表示使得以i-1位置结尾的word1 转化为 以j-1位置结尾的word2 的最小操作数
        int[][] dp = new int[len1 + 1][len2 + 1];

        /**
         * 2.dp 递推：根据w1[i-1]与w2[j-1]是否匹配分情况讨论：
         * w1[i-1]==w2[j-1]: 字符匹配，不需要执行操作 =》dp[i][j] = dp[i-1][j-1]
         * w1[i-1]!=w2[j-1]: 字符不匹配，则选择执行操作让其达到匹配：此处限定操作可以是插入、替换、删除
         * - ① w1 或者 w2 删除1个元素 ② w1 或者 w2 插入1个元素 =》dp[i][j] = min{dp[i-1][j]+1,dp[i][j-1]+1}
         * - ① ② 删除、插入操作可以视为等价处理：w1删除一个元素（i-1,j-1）（dp[i][j]=dp[i-1][j]+1）等价于w2在（i-2,j-1）基础上新增一个元素
         * - ③ w1 或者 w2 替换1个元素：在原基础上执行1次操作 => dp[i][j] = dp[i-1][j-1] + 1
         * => dp[i][j] = min{dp[i-1][j]+1,dp[i][j-1]+1,dp[i-1][j-1] + 1}
         */

        // 3.dp 初始化
        // 首行初始化（w1为空字符串，则w2需要执行删除自身长度的元素个数才能变为空字符串）
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }
        // 首列初始化（w2为空字符串，则w1需要执行删除自身长度的元素个数才能变为空字符串）
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }

        // 4.dp 构建
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                }
            }
        }

        // 返回结果
        return dp[len1][len2];
    }
}
