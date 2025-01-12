package com.noob.algorithm.leetcode.q501_600.q560;

/**
 * 🟡 560.和为K的子数组 - https://leetcode.cn/problems/subarray-sum-equals-k/
 */
public class Solution1 {

    public int subarraySum(int[] nums, int k) {
        // 定义结果
        int res = 0;

        // 暴力遍历
        for (int i = 0; i < nums.length; i++) {
            int currentCount = 0;
            // 内层遍历是为了找到对应的值(此处j指针起点是i（表示可以是其本身）)
            for (int j = i; j < nums.length; j++) {
                currentCount += nums[j];
                if (currentCount == k) {
                    res++;
                }
            }
        }
        // 返回结果
        return res;
    }

}
