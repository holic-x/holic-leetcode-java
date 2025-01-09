package com.noob.algorithm.leetcode.q701_800.q718;

/**
 * 🟡 718 最长重复子数组 - https://leetcode.cn/problems/maximum-length-of-repeated-subarray/description/
 */
public class Solution1 {

    /**
     * 思路：动态规划
     */
    public int findLength(int[] nums1, int[] nums2) {
        // 1.dp 定义（dp[i][j] 表示text1[0,i-1] text2[0,j-1]的最长重复子数组长度）
        int m = nums1.length + 1, n = nums2.length + 1;
        int[][] dp = new int[m][n];
        /**
         * 2.dp 递推
         * - 校验text1[i-1] 与 text2[j-1] 的值是否匹配，从而确定最长重复子数组是否连续
         * - ①  text1[i-1] == text2[j-1] 当前值匹配，校验其是否连续（连续：dp[i][j] = dp[i-1][j-1]+1;）
         * - ② text1[i-1] != text2[j-1] 不考虑
         * 此处重复子数组只关心的是右下方向的连续1个数
         */

        // 3.dp 初始化
        for (int j = 0; j < n; j++) {
            dp[0][j] = 0;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 0;
        }

        // 4.dp 构建
        int max = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        // 返回结果
        return max;
    }

}
