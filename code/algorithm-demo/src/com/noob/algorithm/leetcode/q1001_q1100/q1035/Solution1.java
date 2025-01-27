package com.noob.algorithm.leetcode.q1001_q1100.q1035;

/**
 * 🟡 1035 不相交的线 - https://leetcode.cn/problems/uncrossed-lines/description/
 */
public class Solution1 {

    /**
     * 思路分析：基于动态规划，转化为求两个字符串最长公共子序列（二维数组构建）
     */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length + 1, n = nums2.length + 1;
        // 1.dp 定义：dp[i][j] 表示以[0,i-1]的数组1、[0,j-1]的数组2的最长公共子序列
        int[][] dp = new int[m][n];

        /**
         * 2.dp 递推：dp[i][j]的状态基于其左侧、上侧、左上方的状态进行推导，根据当前指针指向位置元素是否相等来进行情况讨论
         * ① nums1[i-1] == num2[j-1]: dp[i][j] = dp[i-1][j-1] + 1
         * ② nums1[i-1] != nums2[j-1]: dp[i][j] = max{dp[i][j-1],dp[i-1][j]}
         */

        // 3.dp 初始化(首行、首列,两个数组中其中一个为空，则其最长公共子序列只能为0)
        for (int j = 0; j < n; j++) {
            dp[0][j] = 0;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 0;
        }

        // 4.dp 构建（遍历顺序）
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        // 返回结果
        return dp[m - 1][n - 1];
    }

}
