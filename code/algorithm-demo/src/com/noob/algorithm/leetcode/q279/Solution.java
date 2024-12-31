package com.noob.algorithm.leetcode.q279;

/**
 * 279.动态规划
 */
public class Solution {
    // 转化为完全背包问题：n为背包，完全平方数即为物品（可重复使用），将题意转化为用最少的物品数量凑满背包
    public int numSquares(int n) {
        // 1.定义动态数组(dp[k]表示和为k的完全平方数的最少数量)
        int[] dp = new int[n + 1];

        // 2.推导公式dp[k] = min(dp[k-i*i]+1,dp[k])

        // 3.dp数组初始化
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE; // 其余数组元素初始化为最大值，避免递推过程中被min覆盖
        }

        // 4.确定遍历顺序（完全背包概念）
        /* 实现思路1：外层物品、内层背包
        // 外层遍历物品（i为物品、j为背包）
        for (int i = 1; i * i <= n; i++) { // 物品个数受限于背包容量
            // 内层遍历背包
            for (int j = i * i; j <= n; j++) { // 背包容量受限于n
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
         */

        // 实现思路2：外层背包，内层物品
        for (int i = 1; i <= n; i++) { // 背包容量受限于n
            for (int j = 1; j * j <= i; j++) { // 物品个数受限于当前背包容量
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        // 返回结果
        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numSquares(12));
    }
}
