package com.noob.algorithm.leetcode.q1201_q1262;


/**
 * 🟡 1262 可被3整除的最大和 - https://leetcode.cn/problems/greatest-sum-divisible-by-three/description/
 */
public class Solution1 {

    public int maxSum = 0;
    public int curPathSum = 0; // 当前选择路径和

    /**
     * 提供一个整数数组 nums， 找出并返回能被三整除的元素 最大和
     */
    public int maxSumDivThree(int[] nums) {
        // 调用回溯算法
        backTrack(nums, 0);
        // 返回结果
        return maxSum;
    }

    // 回溯算法
    public void backTrack(int[] nums, int idx) {
        // 记录结果（所有元素遍历完成）
        if (curPathSum % 3 == 0) {
            // 更新元素最大和
            maxSum = Math.max(maxSum, curPathSum);
        }

        // 如果已经遍历完数组，返回
        if (idx >= nums.length) {
            return;
        }

        // 回溯处理
        for (int i = idx; i < nums.length; i++) {
            // 选择加上当前元素
            curPathSum += nums[i];
            // 递归下一个元素
            backTrack(nums, i + 1);
            // 恢复现场
            curPathSum -= nums[i];
        }
    }

}
