package com.noob.algorithm.leetcode.q001;

/**
 * 🟢 1.两数之和
 * https://leetcode.cn/problems/two-sum/description/
 */
public class Solution1 {

    /**
     * 思路1：双层循环
     */
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        // 没有匹配到满足的条件
        return new int[0];
    }
}
