package com.noob.algorithm.leetcode.q238;

/**
 * 238.除自身以外数组的乘积
 * 思路：暴力循环（双层循环）
 */
public class Solution1 {
    public int[] productExceptSelf(int[] nums) {
        // 定义结果
        int[] res = new int[nums.length];

        // 暴力双层循环，外层循环敲定指定元素，内存循坏做除自身外的累乘操作
        for (int i=0;i<nums.length;i++) {
            res[i] = 1; // 1乘以任何数都等于本身
            for(int j=0;j<nums.length;j++){
                if(i!=j){
                    // 排除自身进行累乘操作
                    res[i] *= nums[j];
                }
            }
        }
        // 返回结果
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        Solution1 solution = new Solution1();
        System.out.println(solution.productExceptSelf(nums));
    }
}
