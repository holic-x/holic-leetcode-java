package com.noob.algorithm.leetcode.q401_500.q494;

/**
 * 🟡 494 目标和 - https://leetcode.cn/problems/target-sum/description/
 */
public class Solution1 {

    public int cnt = 0; // 构成目标和的方案数量

    public int curPathSum = 0; // 计算当前路径和

    /**
     * 回溯法
     */
    public int findTargetSumWays(int[] nums, int target) {
        // 调用回溯算法
        backTrack(nums, 0, target);
        // 返回结果
        return cnt;
    }


    /**
     * 回溯法
     */
    private void backTrack(int[] nums, int idx, int target) {
        // 递归出口
        if (idx >= nums.length) {
            if (curPathSum == target) {
                cnt++;
            }
            return;
        }

        // 回溯处理:回溯列表（+、-两种情况）
        // 处理+的情况
        curPathSum += nums[idx];
        backTrack(nums, idx + 1, target);
        curPathSum -= nums[idx];

        // 处理-的情况
        curPathSum -= nums[idx];
        backTrack(nums, idx + 1, target);
        curPathSum += nums[idx];
    }

}
