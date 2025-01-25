package com.noob.algorithm.leetcode.q901_q1000.q912;

/**
 * 🟡 912 手撕快速排序（排序数组） - https://leetcode.cn/problems/sort-an-array/description/
 */
public class Solution2 {

    /**
     * 快速排序思路：
     * ① 选主（选择一个排序基准，可有多种方式选择：每次选第1位，每次选最后1位，每次选中间）
     * ② 分区：将base放在合适的位置（base左侧是比它小的数，base右侧是比它大的数）
     * ③ 递归：继续递归处理除base之外的左右区间
     */
    public int[] sortArray(int[] nums) {
        sortHelper(nums, 0, nums.length - 1);
        return nums;
    }

    private void sortHelper(int[] nums, int left, int right) {
        // 递归出口
        if (left >= right) {
            return;
        }

        // 选主、分区
        int baseIdx = partition(nums, left, right);

        // 递归处理左、右区间
        sortHelper(nums, left, baseIdx - 1);
        sortHelper(nums, baseIdx + 1, right);

    }


    // 对指定区间[left,right]进行分区，并返回base所在索引
    private int partition(int[] nums, int left, int right) {
        // ① 选择第1个元素作为base
        int base = nums[left];
        int cur = left; // 定义当前分界位置

        // ② 遍历元素，将base放在合适的位置
        for (int i = left + 1; i <= right; i++) {
            // 如果遇到比base小的元素则将其交换到前面来
            if (base > nums[i]) {
                cur++; // 分界位置往前移动一位（相当于指向交换位置，每次都是要执行交换前才空出位置）
                swap(nums, i, cur); // 执行交换
            }
        }

        // 最后将base交换到cur指向位置
        swap(nums, left, cur); // 原base位置为left，指向交换位置cur
        // 返回交换后的base的位置
        return cur;
    }

    // 交换元素
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
