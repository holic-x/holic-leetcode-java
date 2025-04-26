package com.noob.algorithm.leetcode.q401_500.q486;


/**
 * 🟡 486 预测赢家 -  https://leetcode.cn/problems/predict-the-winner/description/
 */
public class Solution486_01 {

    public boolean predictTheWinner(int[] nums) {
        int ans = helper(nums, 0, nums.length - 1);
        return ans >= 0;
    }

    // 定义递归辅助方法(计算当前玩家在子数组nums[left...right]中的最大优势)
    private int helper(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left]; // 递归出口:只剩最后一个数字，直接返回
        }
        // 计算玩家选择左端后的优势
        int pickLeft = nums[left] - helper(nums, left + 1, right);
        // 计算玩家选择右端后的优势
        int pickRight = nums[right] - helper(nums, left, right - 1);

        // 返回最大优势
        return Math.max(pickLeft, pickRight);
    }

}
