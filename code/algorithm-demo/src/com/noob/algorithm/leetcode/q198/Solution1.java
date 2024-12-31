package com.noob.algorithm.leetcode.q198;

/**
 * 198.打家劫舍（获取偷取的最大总金额，相邻两个房间不能连着偷）
 */
public class Solution1 {
    public int rob(int[] nums) {
        // 定义数组存储每到一个房间可能偷到的最大金额
        int[] dp = new int[nums.length];

        // 边界值判断
        if(nums==null || nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }

        // 初始化
        dp[0] = nums[0]; // 只有一间房屋
        dp[1] = Math.max(nums[0], nums[1]); // 有两间房屋，不能连着偷，选择最大值

        // 遍历房间，计算每个房间可能偷到的最大金额
        for(int k = 2; k < nums.length; k++) {
            // 当偷到第k间房，有两种方案（偷或者不偷，分别计算两种情况下可能偷到的金额，然后取最大值）
            int todo = dp[k-2] + nums[k]; // 偷了K，则不能偷K-1，其max为dp[K-2]+nums[i]
            int undo = dp[k-1]; // 不偷K，其max为dp[k-1]
            // 记录最大值（选择偷窃方案，然后进入下一步）
            dp[k] = Math.max(todo, undo);
        }
        // 返回偷窃的最大值
        return dp[nums.length-1];
    }
}
