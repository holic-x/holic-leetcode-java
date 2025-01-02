package com.noob.algorithm.leetcode.q33;

import java.util.Arrays;

/**
 * 33.搜索旋转排序数组
 */
public class Solution {
    public int search(int[] nums, int target) {
        // 区分有无旋转两种情况，通过判断nums是否完全升序来界定
        int validOrderRes = validOrder(nums);
        if (validOrderRes == -1) {
            // 无旋转，直接进行一次二分检索
            return binarySearch(nums, target);
        } else {
            // 有旋转，基于轴点分别进行二分检索，返回最终检索值(copyOfRange [from,to))
            int[] nums1 = Arrays.copyOfRange(nums, 0, validOrderRes+1);
            int[] nums2 = Arrays.copyOfRange(nums, validOrderRes+1, nums.length);
            int search1 = binarySearch(nums1, target);
            int search2 = binarySearch(nums2, target);
            if (search1 != -1) {
                return search1;
            }
            if (search2 != -1) {
                return search2 + nums1.length; // 返回的是索引，需加上前面的数组长度
            }
            return -1;
        }
    }

    public int validOrder(int[] nums) {
        // 如果数组为空或者数组长度为1，视作无旋转
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return -1;
        }
        // 如果完全升序则返回-1，如果非完全升序则返回"轴点"（出现降序的索引位置）
        for (int i = 0; i < nums.length -1; i++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 定义二分检索方法
     */
    public int binarySearch(int[] nums, int target) {
        // 定义左右节点
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            // 定义中间节点
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
        // 无匹配结果
        return -1;
    }

    public static void main(String[] args) {
//        int[] nums = {4, 5, 6, 7, 0, 1, 2};
//        int[] nums = {4, 5, 6, 7, 0, 1, 2};
//        int[] nums = {1,3};
        int[] nums = {3,1};
        Solution solution = new Solution();
        System.out.println(solution.search(nums, 1));
    }
}
