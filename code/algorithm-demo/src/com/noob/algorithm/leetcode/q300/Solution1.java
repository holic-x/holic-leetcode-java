package com.noob.algorithm.leetcode.q300;

import java.util.Arrays;

/**
 * 🟡 300.最长子序列 - https://leetcode.cn/problems/longest-increasing-subsequence/description/
 */
public class Solution1 {

    public int lengthOfLIS(int[] nums) {
        // 1.确定dp（dp[i]表示以nums[i]元素结尾的最长子序列长度）
        int[] dp = new int[nums.length];

        // 2.敲定状态转移方程（以nums[i]结尾的序列，对于升序序列而言如果后面的元素大于前面的元素，则表示升序）

        // 3.初始化dp
        Arrays.fill(dp, 1); // dp元素初始化为1

        // 循环（因此校验以nums[i]结尾的元素的最长子序列）
        for (int i = 0; i < nums.length; i++) {
            // 内层循环（0-i中判断以nums[i]结尾的最长子序列）
            for (int j = 0; j < i; j++) {
                // 如果后一个元素大于前一个元素则为升序
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1); // 则选择看接在0-i之间的哪个元素后面能构成更大的升序元素，计算其最大子序列长度即可
                }
            }
        }

        // 4.返回整个数组的最长子序列长度（dp[k]存储的是以某个元素结尾的最长子序列长度，因此此处需要遍历整个dp返回最大值）
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}