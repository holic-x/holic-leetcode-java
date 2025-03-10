package com.noob.algorithm.leetcode.q101_200.q162;

/**
 * 🟡 162 寻找峰值 - https://leetcode.cn/problems/find-peak-element/description/
 */
public class Solution3 {

    /**
     * 峰值元素：严格大于左右相邻值的元素；如果数组中包含多个峰值，则返回任意一个峰值的位置
     * 思路：贪心二分搜索（锁定上升序列）
     */
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 校验nums[mid] 与 nums[mid+1];
            if (nums[mid] <= nums[mid + 1]) { // <||<= 题目限定元素不重复
                // 上升序列在右侧，左侧缩边
                left = mid + 1;
            } else if (nums[mid] > nums[mid + 1]) {
                // 上升序列在左侧，右侧缩边
                right = mid;
            }
        }
        // 返回结果
        return left;
    }

}
