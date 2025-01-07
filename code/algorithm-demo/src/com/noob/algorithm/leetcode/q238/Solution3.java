package com.noob.algorithm.leetcode.q238;

/**
 * 🟡 238.除自身以外数组的乘积 - https://leetcode.cn/problems/product-of-array-except-self/
 */
public class Solution3 {
    /**
     * 思路：左右乘积（进阶）
     */
    public int[] productExceptSelf(int[] nums) {
        // 定义结果
        int[] res = new int[nums.length];

        /**
         * 填充结果集为累乘结果(1 2 3 4)
         * res[1]=res[0]*nums[0]= 1 * 1 = 1
         * res[2]=res[1]*nums[1]= 1 * 2 =2
         * res[3]=res[2]*nums[2]= 2 * 3 =6
         * ......
         */
        // 填充左侧乘积结果
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
            System.out.println(res[i]);
        }

        // 填充右侧乘积（右侧乘积是从尾部开始遍历）
        int right = 1; // 定义右侧的累乘值
        for (int i = nums.length - 1; i >= 0; i--) {
            // 进行结果累乘
            res[i] *= right;
            // 更新right
            right *= nums[i];
        }

        // 返回结果
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        Solution3 solution = new Solution3();
        System.out.println(solution.productExceptSelf(nums));
    }
}
