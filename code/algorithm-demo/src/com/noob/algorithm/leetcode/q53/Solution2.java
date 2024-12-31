package com.noob.algorithm.leetcode.q53;

/**
 * 53.最大子数组和
 * 动态规划
 */
public class Solution2 {

    public int maxSubArray(int[] nums) {
        // 定义结果
        int res = nums[0];

        // 定义当前最大值
        int currentMax = nums[0];

        // 单层循环
        for (int i = 1; i < nums.length; i++) {
            // 获取当前子组合的最大值（当前子组合的最大值被拆解为两部分：上一个子组合的最大值+num[i]、其自身num[i]）
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            // 更新最大值
            res = Math.max(res, currentMax);
        }

        // 返回结果
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1};
        Solution2 solution = new Solution2();
        System.out.println(solution.maxSubArray(nums));
    }

}
