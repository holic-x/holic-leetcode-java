package com.noob.algorithm.leetcode.q001_100.q041;

import java.util.Arrays;

/**
 * 🔴 041 缺失的第1个正数 - https://leetcode.cn/problems/first-missing-positive/
 */
public class Solution2 {
    /**
     * 给定一个未排序的数组nums，找出其中没有出现的最小正整数（题目限定时间复杂度为O(n),且只能使用常数级别的空间）
     * 思路②：排序+二分查找
     */
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // 对数组元素进行排序
        Arrays.sort(nums);

        // 遍历集合，通过二分查找快速判断[1,n]区间内哪个数不在集合中（因为此处是确定了校验区间的遍历顺序，当找到第1个不在区间内的最小正整数则返回）
        for (int i = 1; i <= n; i++) {
            // 调用二分检索，如果目标数不存在则返回这个值
            if (binarySearch(nums, i) == -1) {
                return i;
            }
        }
        // [1,n]区间内都有值，则返回n+1
        return n + 1;
    }

    // 二分查找法
    private int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1; // 闭区间
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                // 目标数在左侧，右侧边界缩边
                right = mid - 1;
            } else {
                // 目标数在右侧，左侧边界缩边
                left = mid + 1;
            }
        }
        // 目标数不存在
        return -1;
    }
}
