package com.noob.algorithm.leetcode.q201_300.q239;

import com.noob.algorithm.base.util.PrintUtil;

/**
 * 🔴 239 滑动窗口的最大值 - https://leetcode.cn/problems/sliding-window-maximum/description/
 */
public class Solution1 {
    /**
     * 思路：模拟法
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        // 依次移动窗口，获取窗口内的最值
        for (int i = 0; i < n - k + 1; i++) {
            res[i] = getMax(nums, i, i + k - 1); // 窗口内为k个元素，因此此处限定校验范围为[i,i+k-1]
        }
        return res;
    }

    // 获取指定数组范围内的max
    private int getMax(int[] nums, int left, int right) {
        int maxVal = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            maxVal = Math.max(nums[i], maxVal);
        }
        return maxVal;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        Solution1 solution = new Solution1();
        int[] res = solution.maxSlidingWindow(nums, 3);
        PrintUtil.print(res);
    }
}
