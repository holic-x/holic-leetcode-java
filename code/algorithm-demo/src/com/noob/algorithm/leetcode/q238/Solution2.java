package com.noob.algorithm.leetcode.q238;

/**
 * 238.除自身以外数组的乘积
 * 思路：左右乘积
 */
public class Solution2 {
    public int[] productExceptSelf(int[] nums) {
        // 定义变量存放数组长度
        int n = nums.length;

        // 定义结果
        int[] res = new int[n];

        // 分别定义数据用于存放当前i位置的左侧累乘、右侧累乘结果
        int[] left = new int[n];
        int[] right = new int[n];

        // 左侧累乘操作
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
            System.out.println(res[i]);
        }

        // 右侧累乘操作(从尾部开始)
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        // 左右乘积相乘得到结果
        for (int i = 0; i < n; i++) {
            res[i] = left[i] * right[i];
        }

        // 返回结果
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        Solution2 solution = new Solution2();
        System.out.println(solution.productExceptSelf(nums));
    }
}
