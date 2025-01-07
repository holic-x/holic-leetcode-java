package com.noob.algorithm.leetcode.q001_100.q033;

/**
 * 🟡 033 搜索旋转排序数组 - https://leetcode.cn/problems/search-in-rotated-sorted-array/description/
 */
public class Solution2 {

    /**
     * 思路：寻转旋转基点 + 二分检索，区分有旋转和无旋转两种情况分析
     */
    public int search(int[] nums, int target) {
        int findRotateIdx = searchRotateIdx(nums);
        if (findRotateIdx == -1) {
            // 无旋转，直接调用二分法检索
            return binarySearch(nums, 0, nums.length - 1, target);
        } else {
            // 有旋转，拆分数组进行二分法检索
            int find1 = binarySearch(nums, 0, findRotateIdx - 1, target);
            int find2 = binarySearch(nums, findRotateIdx, nums.length - 1, target);
            return find1 != -1 ? find1 : find2;
        }
    }

    // 寻找旋转基点
    private int searchRotateIdx(int[] nums) {
        int idx = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                idx = i;
                break; // 出现骤降点
            }
        }
        return idx;
    }

    /**
     * 二分检索(针对指定检索范围)
     */
    private int binarySearch(int[] nums, int start, int end, int target) {
        int left = start, right = end;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            }
        }
        return -1; // 未找到指定target
    }

}