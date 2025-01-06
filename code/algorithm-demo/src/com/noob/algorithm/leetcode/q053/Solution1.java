package com.noob.algorithm.leetcode.q053;

/**
 * 🟡 53.最大子数组和 - https://leetcode.cn/problems/maximum-subarray/description/
 */
public class Solution1 {

    /**
     * 暴力双层循环：外层敲定起点、内层敲定终点
     */
    public int maxSubArray(int[] nums) {
        // 定义结果
        int res = Integer.MIN_VALUE; // res = -999999999

        for (int i = 0; i < nums.length; i++) {
            int currentCount = 0;
            // 内存循环敲定终点，通过累加获取最大值
            for (int j = i; j < nums.length; j++) {
                currentCount += nums[j];
                // 更新最大值（此处需区分整数和负数的情况，因为res初始化为MIN_VALUE）
                res = Math.max(res, currentCount);
            }
        }
        // 返回结果
        return res;
    }

    public static void main(String[] args) {
        // 可能存在问题：初始化了res为0，忽略了可能存在负数的情况，导致一些边界没有覆盖到,因此此处需用MIN进行比较
        int[] nums = {-1};
        Solution1 solution = new Solution1();
        System.out.println(solution.maxSubArray(nums)); // 理论返回-1，但是如果没有处理res就会返回0
    }

}
