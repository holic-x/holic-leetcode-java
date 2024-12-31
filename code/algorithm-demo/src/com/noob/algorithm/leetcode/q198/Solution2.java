package com.noob.algorithm.leetcode.q198;

/**
 * 198.打家劫舍（获取偷取的最大总金额，相邻两个房间不能连着偷）
 * 滚动数组：每间房的最高偷窃金额和前两间房相关，可以基于滚动数组来实现（p、q、r）
 */
public class Solution2 {
    public int rob(int[] nums) {
        // 边界值判断
        if(nums==null || nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }

        // 初始化（初始化p、q、r概念，分别表示k-2、k-1、k）
        int p = nums[0]; // 只有一间房屋(p初始化对应1间)
        int q = Math.max(nums[0], nums[1]); // 有两间房屋，不能连着偷，选择最大值（q初始化对应2间选一间）
        int max = Integer.MIN_VALUE; // 定义第K间房的最大偷窃金额
        // 遍历房间，计算每个房间可能偷到的最大金额
        for(int k = 2; k < nums.length; k++) {
            // 当偷到第k间房，有两种方案（偷或者不偷，分别计算两种情况下可能偷到的金额，然后取最大值）
            int todo = p + nums[k]; // 偷了K，则不能偷K-1，其max为dp[K-2]+nums[i]
            int undo = q; // 不偷K，其max为dp[k-1]
            // 记录最大值（选择偷窃方案，然后进入下一步）
            max = Math.max(todo, undo);
            // 数组滚动,进入下一轮
            p = q;
            q = max;
        }
        // 返回偷窃的最大值
        return max;
    }
}
