package com.noob.algorithm.leetcode.q034;

/**
 * 🟡 034.在排序数组中查找元素的第一个和最后一个位置 - https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class Solution3 {

    // 二分查找法：正向一次二分查找目标值位置，然后基于这个位置出发，用双指针分别向左、右进行遍历得到最左、最右
    public int[] searchRange(int[] nums, int target) {
        // ① 获取target位置
        int findIdx = binarySearch(nums, target);
        if (findIdx == -1) {
            return new int[]{-1, -1};
        }

        // ② 基于当前的target位置，定义双指针从当前位置出发，分别找到最左、左右的位置
        int left = findIdx, right = findIdx;
        while (left >= 0 && nums[left] == target) left--;
        while (right < nums.length && nums[right] == target) right++;
        return new int[]{left + 1, right - 1};
    }

    public int binarySearch(int[] nums, int target) {
        // 定义左右指针
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            // 定义中间节点位置
            int mid = left + (right - left) / 2;
            // 校验target
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            }
        }
        // 如果target不存在返回-1（如果是要返回下一个可插入位置则是return left）
        return -1;
    }

}
