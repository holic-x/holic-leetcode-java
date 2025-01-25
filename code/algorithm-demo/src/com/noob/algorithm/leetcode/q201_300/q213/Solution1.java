package com.noob.algorithm.leetcode.q201_300.q213;

/**
 * 🟡 213 打家劫舍II - https://leetcode.cn/problems/house-robber-ii/description/
 */
public class Solution1 {

    /**
     * 思路：环形房屋的偷盗方案
     * 偷盗范围:[0,n-1]的环形范围，因此可以将其平展为两个偷盗的范围
     * ① 如果偷了0，则不能偷n-1（0与n-1紧紧挨着），因此偷盗范围为[0,n-2]
     * ② 如果投了n-1，则不能偷0，因此偷盗范围为[1,n-1]
     * 基于上述两种情况，分别计算两种情况的偷盗金额的最大值
     */
    public int rob(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            if (n == 0) return 0;
            if (n == 1) return nums[0];
            if (n == 2) return Math.max(nums[0], nums[1]);
        }

        // ① 计算[0,n-2]范围偷窃的最大金额
        int robAmount1 = robByRange(nums, 0, n - 2);
        // ② 计算[1,n-1]范围偷窃的最大金额
        int robAmount2 = robByRange(nums, 1, n - 1);
        // 返回两种情况的最大值
        return Math.max(robAmount1, robAmount2);
    }


    /**
     * 计算指定范围[start,end]的偷窃方案的最大值
     */
    private int robByRange(int[] nums, int start, int end) {
        int n = end - start + 1;
        if (n < 2) {
            return n == 0 ? 0 : nums[0];
        }

        // 1.dp 定义：dp[i] 表示偷到第i间房屋可获得的最大金额
        int[] dp = new int[n];
        // 2.dp 递推：dp[i] = max{dp[i-1],dp[i-2]+nums[i]}

        // 3.dp 初始化
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);

        // 4.dp 构建
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[start + i]);
        }

        // 返回指定范围区域偷窃的最大金额
        return dp[n - 1];
    }

}
