package com.noob.algorithm.leetcode.q153;

/**
 * 🟡 153.寻找旋转排序数组中的最小值 - https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/description/
 */
public class Solution2 {
    /**
     * 遍历法：由于无法界定排序数组是否真的旋转（轮次），因此基于去寻找这个旋转基点的思路去做
     * - ① 如果找到旋转基点（骤降）则其即为最小
     * - ② 如果不存在则说明没有旋转或者旋转刚好一个轮次（还是原来的排序数组），则nums[0]为最小
     */
    public int findMin(int[] nums) {
        int idx = validRotate(nums);
        return idx == -1 ? nums[0] : nums[idx];
    }

    /**
     * 判断是否存在旋转基点（骤降点）
     */
    private int validRotate(int[] nums) {
        // 旋转属于无效操作情况，不存在旋转基点的情况
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return -1;
        }

        int idx = -1;
        // 判断是否出现骤降点
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                idx = i; // 出现旋转基点
                break;
            }
        }

        // 返回查找的旋转基点
        return idx;
    }
}
