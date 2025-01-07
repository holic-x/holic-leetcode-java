package com.noob.algorithm.leetcode.q101_200.q153;

/**
 * 🟡 153.寻找旋转排序数组中的最小值 - https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/description/
 */
public class Solution1 {
    /**
     * 二分法思路：旋转后的排序数组可能会被拆分为两个升序数组，因此需要找到后半部分的第一个元素，可以基于二分法处理
     */
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2; // 等价于int pivot = (low + high ) /2;
            if (nums[pivot] < nums[high]) { // 因为最小值一定存在，此处只需要不断缩圈
                high = pivot;
            } else {
                low = pivot + 1;
            }
        }
        return nums[low];
    }
}
