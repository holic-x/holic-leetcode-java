package com.noob.algorithm.leetcode.q001_100.q063;

/**
 * 🟡 063 不同路径II - https://leetcode.cn/problems/unique-paths-ii/
 */
public class Solution1 {

    /**
     * 动态规划思路：对于每个点(i,j),到达该点的不同数量可由其左侧和上侧两个方向推导处理
     * 但是如果该点事障碍物所在点说明该点不可达，此时到达该点的路径为0
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;

        // 1.dp 定义（dp[i][j] 表示到达(i,j)点的不同路径和（不包括障碍物））
        int[][] dp = new int[m][n];

        /**
         * 2.dp推导：需根据当前点（i,j）是否存在障碍物进行判断
         * obstacleGrid[i][j] = 1(存在障碍物)：该点不可达 =》dp[i][j]=0
         * obstacleGrid[i][j] = 0（不存在障碍物）：该点可达 =》dp[i][j] = dp[i][j-1] + dp[i-1][j]
         */

        // 3.dp 初始化
        boolean hasRowObstacle = false;
        for (int j = 0; j < n; j++) {
            // 对于首行：一旦出现障碍物则当前点及后面的点都不可达
            if (obstacleGrid[0][j] == 1) {
                hasRowObstacle = true;
            }
            dp[0][j] = hasRowObstacle ? 0 : 1;
        }

        boolean hasColObstacle = false;
        for (int i = 0; i < m; i++) {
            // 对于首列，一旦出现障碍物则当前点及后面的点都不可达
            if (obstacleGrid[i][0] == 1) {
                hasColObstacle = true;
            }
            dp[i][0] = hasColObstacle ? 0 : 1;
        }

        // 4.dp 构建
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 根据当前点是否存在障碍物进行处理
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }

        // 返回到达右下角的有效路径数
        return dp[m - 1][n - 1];
    }

}
