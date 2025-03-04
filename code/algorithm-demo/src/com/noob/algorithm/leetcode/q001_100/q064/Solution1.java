package com.noob.algorithm.leetcode.q001_100.q064;

/**
 * 🟡 064 最小路径和 - https://leetcode.cn/problems/minimum-path-sum/description/
 */
public class Solution1 {

    /**
     * 思路：动态规划
     * 要从[0,0]走到[m,n]点，则需从其上方坐标或者左侧坐标进行推演,每次选择路径和最小的方向前进
     * dp[i][j] = min{dp[i-1][j],dp[i][j-1]} + val[i][j]
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // 1.dp 定义：dp[i][j] 表示从[0,0]位置走到点[i,j]的路径数
        int[][] dp = new int[m][n]; // 如果坐标要取到[m,n]，则此处初始化为[m+1][n+1]

        /**
         * 2.dp 递推：dp[i][j] = min{dp[i-1][j],dp[i][j-1]} + val[i][j]
         */

        // 3.dp 初始化
        // dp[0][j] 对于首行，路径和为经过点累加值
        dp[0][0] = grid[0][0];
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        // dp[i][0] 对于首列，路径和为经过点累加值
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // 4.dp 构建
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        // 返回
        return dp[m - 1][n - 1];
    }
}
