package com.noob.algorithm.leetcode.q001_100.q088;

import com.noob.algorithm.base.util.PrintUtil;

/**
 * 🟢 088 合并两个有序数组 - https://leetcode.cn/problems/merge-sorted-array/description/
 */
public class Solution1 {

    /**
     * 给定两个非递减顺序，合并nums2到nums1（ nums1(预留空间为m+n)，将nums2合并到nums1 ）
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx = m + n - 1; // idx 指向当前填充位置
        // 用两个指针分别遍历两个数组元素，采用逆序遍历思路将较大的元素依次填充到指定位置
        int p1 = m - 1, p2 = n - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] >= nums2[p2]) {
                // 选择nums1中的元素
                nums1[idx--] = nums1[p1--]; // 填充元素，且两个指针移动
            } else {
                // 选择nums2中的元素
                nums1[idx--] = nums2[p2--]; // 填充元素，且两个指针移动
            }
        }
        // 校验剩余元素（如果是nums1有剩余则不需要动（本身nums1就是结果集），如果nums2有剩余则继续填充处理）
        while (p2 >= 0) {
            nums1[idx--] = nums2[p2--]; // 填充元素，且两个指针移动
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = new int[]{2, 5, 6};
        int n = 3;
        Solution1 solution = new Solution1();
        solution.merge(nums1, m, nums2, n);
        PrintUtil.print(nums1);
    }
}
