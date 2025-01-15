package com.noob.algorithm.leetcode.q001_100.q004;

import java.util.ArrayList;
import java.util.List;

/**
 * 🔴 004 寻找两个正序数组的中位数 - https://leetcode.cn/problems/median-of-two-sorted-arrays/
 */
public class Solution1 {

    /**
     * 思路：暴力思路（将两个数组合为1个数组进行处理）
     * ① 合并两个有序数组
     * ② 返回合并后的数组的中位数
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // ① 合并两个有序数组
        List<Integer> list = merge(nums1, nums2);

        // ② 返回合并后的数组的中位数
        int size = list.size();
        if (size % 2 == 0) {
            // return (list.get(size / 2) + list.get(size / 2 - 1)) / 2.0;
            int left = 0, right = size - 1, mid = left + (right - left) / 2;
            return (list.get(mid) + list.get(mid + 1)) / 2.0;
        } else if (size % 2 == 1) {
            return list.get(size / 2);
        }
        return -1;
    }

    /**
     * 合并两个有序数组
     * 思路1：循环条件取p1 < m || p2 < n，只有两个数组都遍历完成才跳出循环，在循环中处理边界条件
     * 思路2：循环条件取p1 < m && p2 < n，当有一个数组遍历结束则跳出循环，跳出循环后处理尾部
     */
    private List<Integer> merge(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        List<Integer> list = new ArrayList<>();

        int p1 = 0, p2 = 0;
        while (p1 < m || p2 < n) {
            // 处理设置（处理数组边界问题）
            int val1 = (p1 < m ? nums1[p1] : Integer.MAX_VALUE); // 注意此处如果是遇到边界不能简单取0，会导致OOM，因为处理条件导致指针不会移动引发无限循环（需处理好边界关系）
            int val2 = (p2 < n ? nums2[p2] : Integer.MAX_VALUE);
            if (val1 <= val2 && val1 != Integer.MAX_VALUE) {
                list.add(val1);
                p1++;
            } else if (val2 < val1 && val2 != Integer.MAX_VALUE) {
                list.add(val2);
                p2++;
            }
        }

        // 返回合并结果
        return list;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        Solution1 solution = new Solution1();
        double res = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
    }

}
