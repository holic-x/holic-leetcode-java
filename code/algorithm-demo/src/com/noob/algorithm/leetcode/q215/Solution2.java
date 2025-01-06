package com.noob.algorithm.leetcode.q215;

/**
 * 🟡 215.数组中的第K个最大元素 - https://leetcode.cn/problems/kth-largest-element-in-an-array/description/
 * 思路：排序法
 */
public class Solution2 {

    // 排序法
    public int findKthLargest(int[] nums, int k) {
        // 将数组元素按照逆序排序，然后返回nums[k]，排序可以借助工具类进行排序，此处可以使用冒泡排序
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    // 逆序排序，将较小的值交换到后排
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        // 返回排序后第K个最大元素（数组下标从0开始）
        return nums[k - 1];
        // 如果是降序排序，则返回nums[n-k]
    }
}
