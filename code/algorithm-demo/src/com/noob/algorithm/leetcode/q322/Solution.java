package com.noob.algorithm.leetcode.q322;

/**
 * 322.零钱兑换
 */
public class Solution {

    // 转化为相应的完全背包问题：amount为背包容量，coins为物品重量（不限定物品个数），求如何使用最少数量的物品装满背包
    public int coinChange(int[] coins, int amount) {
        // 1.敲定dp数组（dp[k]表示装满K容量的最小物品个数，即对应凑满amount的最小coins个数（PS：不是所有K都能凑））
        int[] dp = new int[amount + 1];

        // 2.确认递推公式 dp[k] = min(dp[k-coins[i]] + 1, dp[k])

        // 3.初始化dp,使用max填充其他元素（因为递推过程中求的是min）
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;  // dp[i] = Integer.MAX_VALUE;（只要设置一个比amount大即可，能确保凑不上）
            // 如果此处设定为Integer.MAX_VALUE，则下方和amount比较的时候会被转为负数导致结果错误，因此粗出设定为一个比amount大的数即可
        }

        // 4.确定循环（填充dp）
        // 外层背包容量、内层物品个数
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                // dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1); // 需限定条件
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        // 结果返回（返回dp[k],但并不是每个k都能凑，因此如果）
        // return dp[amount];
        return dp[amount] > amount ? -1 : dp[amount]; // 此处根据测试用例返回结果，正常直接返回对应元素，此处如果凑不满则设为-1

        // 5.验证
    }
}
