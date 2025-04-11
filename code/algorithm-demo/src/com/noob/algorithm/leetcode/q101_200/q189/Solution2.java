package com.noob.algorithm.leetcode.q101_200.q189;


/**
 * 🟡 189 轮转数组 - https://leetcode.cn/problems/rotate-array/description/
 */
public class Solution2 {

    /**
     * 思路分析：给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数
     * 3次反转：全反转、前k反转、后n-k反转
     * 原地算法：自定义反转逻辑
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;

        // 计算反转轮次
        k = k % nums.length;

        // 反转整个集合
        reverse(nums, 0, n - 1);

        // 反转前K个数据
        reverse(nums, 0, k - 1);

        // 反转后n-k个数据
        reverse(nums, k, n - 1);
    }

    // 自定义反转算法（限定反转区域）
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            // 交换元素
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            // 指针移动
            start++;
            end--;
        }
    }


}
