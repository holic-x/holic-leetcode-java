package com.noob.algorithm.leetcode.q201_300.q209;

/**
 * 🟡 209 长度最小的子数组 - https://leetcode.cn/problems/minimum-size-subarray-sum/
 * 求满足数组中其总和大于等于target的长度最小的子数组
 */
public class Solution209_01 {

    /**
     * 思路分析：
     * 模拟法：双层遍历，统计每个子数组的数组和，并计算其minLen概念
     */
    public int minSubArrayLen(int target, int[] nums) {
        // 初始化minLen为一个最大值，确保在后面的更新中能被正常处理
        int minLen = Integer.MAX_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) { // i 起点
            int curSum = 0;
            for (int j = i; j < n; j++) { // j 终点
                curSum += nums[j];
                // 判断curSum与target的关系
                if (curSum >= target) {
                    // 更新最小子数组长度
                    minLen = Math.min(minLen, j - i + 1);
                }
            }
        }
        // 返回结果
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

}
