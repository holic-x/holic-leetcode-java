package com.noob.algorithm.skill.sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort2 {

    /**
     * 归并排序：划分、合并（基于拷贝数组实现）
     *
     * @param nums 待合并数组
     */
    int[] mergeSort(int[] nums) {
        // 递归出口
        if (nums.length < 2) {
            return nums;
        }

        // ① 划分阶段
        // int mid = (int) Math.floor(nums.length / 2); // 计算中点
        int mid = nums.length / 2;
        int[] left = Arrays.copyOfRange(nums, 0, mid); // [0,mid)
        int[] right = Arrays.copyOfRange(nums, mid, nums.length); // [mid,n)

        // ② 合并阶段(对排序后的左右子数组进行合并)
        return merge(mergeSort(left), mergeSort(right));
    }

    // 合并两个有序数组
    private int[] merge(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] merge = new int[m + n];
        // 定义指针分别遍历两个数组以及处理合并后的数组
        int p1 = 0, p2 = 0; // p1、p2分别用于遍历nums1，nums2
        int cur = 0; // cur 指向当前merge数组处理的位置
        while (p1 < m || p2 < n) {
            // 处理数组边界情况，如果越界则设置为MAX（辅助处理，简化尾部处理）
            int val1 = (p1 < m ? nums1[p1] : Integer.MAX_VALUE);
            int val2 = (p2 < n ? nums2[p2] : Integer.MAX_VALUE);
            // 择选较小的值载入
            if (val1 <= val2) {
                merge[cur++] = val1;
                p1++;
            } else {
                merge[cur++] = val2;
                p2++;
            }
        }
        // 返回合并后的数组
        return merge;
    }

}
