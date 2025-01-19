package com.noob.algorithm.skill.sort;


import com.noob.algorithm.base.util.PrintUtil;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {

    /* 快速排序 */
    public void quickSort(int[] nums, int left, int right) {
        // 子数组长度为 1 时终止递归
        if (left >= right) {
            return;
        }

        // 哨兵划分
        int pivot = partition(nums, left, right);
        // 递归左子数组、右子数组
        quickSort(nums, left, pivot - 1);
        quickSort(nums, pivot + 1, right);
    }

    // partition 单指针分区处理（限定对指定区域范围进行分区处理）
    private int partition1(int[] nums, int left, int right) {
        // 设置基准值(初始化)，此处nums[]取值为闭区间[left,right]
        int pivot = nums[left]; // 选择第一个数作为分区标准
        int idx = left; // idx 指向当前分区的起始位置（随着遍历移动，最终会指向基准数所在位置）
        // 从数组的第2个元素开始遍历，如果当前遍历元素比pivot大，则跳过
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] <= pivot) {
                // 如果找到了小于当前pivot的数，则需要将其与前面较大的数进行交换（此处相当于将较大的数逐步置换到后面去）
                idx++;
                swap(nums, i, idx);
            }
        }
        // 上述遍历完成，最终需将比较元素交换到期望位置
        swap(nums, left, idx);
        // 返回基准值索引位置
        return idx;
    }

    private int partition(int[] nums, int left, int right) {
        // 设置基准值(初始化)，此处nums[]取值为闭区间[left,right]
        int pivot = nums[right]; // 选择最后1个数作为分区标准
        int idx = right; // idx 指向当前分区的起始位置（随着遍历移动，最终会指向基准数所在位置）
        // 从后往前遍历元素，将较大的值置换到后面
        for (int i = right - 1; i >= left; i--) {
            if (nums[i] >= pivot) {
                // 如果找到了大于等于当前pivot的数，则需要将其与后面较小的数进行交换（此处相当于将较大的数逐步置换到后面去）
                idx--;
                swap(nums, i, idx);
            }
        }
        // 上述遍历完成，最终需将比较元素交换到期望位置
        swap(nums, right, idx);
        // 返回基准值索引位置
        return idx;
    }

    // 交换指定位置的数组元素
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
//        int[] nums = new int[]{3, 6, 12, 4, 26};
//        int[] nums = new int[]{2,4,1,0,3,5};
        int[] nums = new int[]{2, 1, 4, 0, 3, 5};
        quickSort.quickSort(nums, 0, nums.length - 1);
        Arrays.stream(nums).forEach(System.out::println);

    }

}
