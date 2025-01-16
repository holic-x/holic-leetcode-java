package com.noob.algorithm.leetcode.q401_500.q494;

/**
 * 🟡 494 目标和 - https://leetcode.cn/problems/target-sum/description/
 */
public class Solution2 {

    /**
     * 0-1 背包问题：转化为有多少种不同填满背包最大容量的方法
     * - 根据left[]+right[]=target、left[]+right[]=sum这两个公式可以得到left=(target+sum/2),因此可以得到背包容量bagSize
     * - 将问题转化为0-1背包问题(注意初始化的处理)
     */
    public int findTargetSumWays(int[] nums, int target) {
        // ① 前置处理
        int sum = 0;// 统计元素总和
        for (int num : nums) {
            sum += num;
        }
        // 根据公式获取到left（bagSize）
        if ((target + sum) % 2 == 1) {
            return 0; // 无方案（target+sum为奇数时没有方案）
        }
        if (Math.abs(target) > sum) {
            return 0; // 如果target的就绝对值大于sum，现有元素不可能组成和为target
        }
        int left = (target + sum) / 2;

        // ② 动态规划过程
        // 1.dp 定义:dp[i][j]表示从[0,i]中选择物品可凑满背包有多少种方案
        int m = nums.length, n = left + 1;
        int[][] dp = new int[m][n];

        /**
         * 2.dp 递推: dp[i][j]的方案是基于前面的策略推导
         * j<nums[i]:dp[i][j]=dp[i-1][j](继承状态)
         * j≥nums[i]:可选择装或者不装，这两种方案之和dp[i][j]=dp[i-1][j] + dp[i-1][j-nums[i]]
         */

        // 3.dp 初始化
        // 首行初始化：只有当容量j==nums[0]的情况下才能装满（方案数为1），其他情况要么装不满、要么装不下
        for (int j = 0; j < n; j++) {
            dp[0][j] = (j == nums[0]) ? 1 : 0;
        }

        // 首列初始化：如果nums均不为0则容量j==0只有1种方案就是不装，但是如果nums中存在元素为0的情况则要根据0的个数计算方案数（2^t^,t为0的个数）
        int zeroNum = 0; // 累计0的个数
        for (int i = 0; i < m; i++) {
            if (nums[i] == 0) {
                zeroNum++;
            }
            // 根据当前0的个数来决定方案数
            dp[i][0] = (int) Math.pow(2, zeroNum);
        }

        // 4.dp 构建
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (j < nums[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]];
                }
            }
        }

        // 返回结果
        return dp[m - 1][n - 1];
    }


}
