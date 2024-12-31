package com.noob.algorithm.leetcode.q153;

/**
 * 153.寻找旋转排序数组中的最小值
 */
public class Solution {
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
