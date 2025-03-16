package com.noob.algorithm.leetcode.q301_400.q334;

/**
 * 🟡 334.递增的三元子序列 - https://leetcode.cn/problems/increasing-triplet-subsequence/description/
 */
public class Solution2 {

    /**
     * 判断这个数组中是否存在长度为 3 的递增子序列
     * 判断是否存在三元组：满足下标i<j<k,nums[i]<nums[j]<nums[k],存在则返回true、不存在则返回false
     * 双向遍历思路:
     * ① 遍历数组，分别求每个元素左侧的最小值、右侧的最大值（维护leftMin[]、rightMax[]）
     * ② 再次遍历数组，确认是否存在 leftMin[i-1]<nums[i]<rightMax[i+1]
     */
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }

        // 定义leftMin
        int[] leftMin = new int[n];
        leftMin[0] = nums[0];
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], nums[i]);
        }

        // 定义rightMax
        int[] rightMax = new int[n];
        rightMax[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
        }

        // 再次遍历数组，确认是否存在递增的三元子序列
        for (int i = 1; i < n - 1; i++) {
            if (leftMin[i - 1] < nums[i] && nums[i] < rightMax[i + 1]) {
                return true;
            }
        }

        // 不存在符合条件的三元组
        return false;
    }

}
