package com.noob.algorithm.leetcode.q101_200.q162;

/**
 * 🟡 162 寻找峰值 - https://leetcode.cn/problems/find-peak-element/description/
 */
public class Solution2 {

    /**
     * 峰值元素：严格大于左右相邻值的元素；如果数组中包含多个峰值，则返回任意一个峰值的位置
     * 思路：数组中无重复元素，转化为求数组的max的思路
     */
    public int findPeakElement(int[] nums) {
        int maxIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[maxIdx] < nums[i]) {
                maxIdx = i; // 更新最大值索引
            }
        }
        return maxIdx;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
    }

}
