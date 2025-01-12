package com.noob.algorithm.leetcode.q701_800.q704;

/**
 * 🟢704 二分查找 - https://leetcode.cn/problems/binary-search/description/
 */
public class Solution1 {

    /**
     * 思路分析：基于升序数组进行二分查找，如果找到目标值则返回下标，否则返回-1
     * 三种解法思路：闭区间、左闭右开、开区间
     * 每种解法需要注意初始化取值、循环条件、边界缩圈处理
     */
    public int search(int[] nums, int target) {
//        int res = binarySearch1(nums, target);
//        int res = binarySearch2(nums, target);
        int res = binarySearch3(nums, target);
        return res;
    }

    // 【闭区间】的二分查找
    private int binarySearch1(int[] nums, int target) {
        // 定义检索边界
        int left = 0, right = nums.length - 1;
        // 检索
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 检验nums[mid]与target的关系
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                // target较小，则右侧缩边
                right = mid - 1;
            } else if (target > nums[mid]) {
                // target较大，则左侧缩边
                left = mid + 1;
            }
        }
        // 没有找到目标值
        return -1;
    }

    // 【左闭右开】的二分查找
    private int binarySearch2(int[] nums, int target) {
        // 定义检索边界
        int left = 0, right = nums.length;
        // 检索
        while (left < right) { // 左闭右开，left不能取到right
            int mid = left + (right - left) / 2;
            // 检验nums[mid]与target的关系
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                // target较小，则右侧缩边
                right = mid; // 左闭右开
            } else if (target > nums[mid]) {
                // target较大，则左侧缩边
                left = mid + 1;
            }
        }
        // 没有找到目标值
        return -1;
    }

    // 【开区间】的二分查找
    private int binarySearch3(int[] nums, int target) {
        // 定义检索边界
        int left = -1, right = nums.length; // 开区间
        // 检索
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            // 检验nums[mid]与target的关系
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                // target较小，则右侧缩边
                right = mid;
            } else if (target > nums[mid]) {
                // target较大，则左侧缩边
                left = mid;
            }
        }
        // 没有找到目标值
        return -1;
    }

}