package com.noob.algorithm.leetcode.q401_500.q474;

/**
 * 🟡 474 一和零 - https://leetcode.cn/problems/ones-and-zeroes/description/
 */
public class Solution1 {

    /**
     * 动态规划：0-1背包问题，只不过此处背包的维度限制有两个，分别是0和1的个数限制
     * 回归0-1背包问题的二维数组，那么此处可以联想到用三维数组来控制
     * 此处则是基于0-1背包问题的一维数组思路来做，其核心思路分析如下：
     * - ① 分别统计strs中0和1的个数（也可以在dp推导过程中处理）
     * - ② 基于一维数组的0-1背包思路处理
     */
    public int findMaxForm(String[] strs, int m, int n) {
        // 1.dp 定义：dp[i][j] 表示最多有i个0、j个1的最大子集长度（i表示0背包的容量，j表示1背包的容量）
        int[][] dp = new int[m + 1][n + 1];

        /**
         * 2.dp 推导：
         * 先物品后背包（背包逆序）: dp[i][j]可以从前一个str中推导出来，前一个str中有zeroNum个0，那么
         * dp[i][j] = max{dp[i][j],dp[i-zeroNum][j-oneNum]+1}
         */

        // 3.dp 初始化
        dp[0][0] = 0; // 0和1的背包容量都为0，则无法装入任何物品，整体最大价值初始化为0


        // 4.dp 构建: 外层物品，内层背包逆序
        for (String str : strs) {
            // 计算当前遍历字符串中0、1的个数
            int[] nums = getNum(str);
            int zeroNum = nums[0];
            int oneNum = nums[1];

            // dp 处理
            for (int i = m; i >= zeroNum; i--) { // i的取值范围[zeroNum,m]
                for (int j = n; j >= oneNum; j--) { // j的取值范围[oneNum,n]
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }

        // 返回结果
        return dp[m][n];
    }


    // 计算字符串中的0、1的个数，返回new int[]{zeroNum,oneNum}
    private int[] getNum(String str) {
        int zeroNum = 0, oneNum = 0;
        for (char ch : str.toCharArray()) {
            switch (ch) {
                case '0': {
                    zeroNum++;
                    break;
                }
                case '1': {
                    oneNum++;
                    break;
                }
            }
        }
        return new int[]{zeroNum, oneNum};
    }
}
