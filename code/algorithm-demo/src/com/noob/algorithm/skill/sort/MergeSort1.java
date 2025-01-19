package com.noob.algorithm.skill.sort;

import java.util.PriorityQueue;

/**
 * 归并排序
 */
public class MergeSort1 {

    /**
     * 归并排序：划分、合并
     *
     * @param nums       待合并数组
     * @param left,right 待合并区间
     */
    void mergeSort(int[] nums, int left, int right) {
        // 终止条件
        if (left >= right) {
            return; // 当子数组长度为 1 时终止递归
        }

        // ① 划分阶段
        int mid = left + (right - left) / 2; // 计算中点
        mergeSort(nums, left, mid); // 递归左子数组
        mergeSort(nums, mid + 1, right); // 递归右子数组

        // ② 合并阶段
        merge(nums, left, mid, right);
    }

    // 根据指定区域合并数组
    /*
    private void merge(int[] nums, int left, int mid, int right) {
        // 创建临时数组存放合并后的元素
        int len = right - left + 1;
        int[] temp = new int[len];

        // 定义双指针用于合并两个数组：左子数组取值[left,mid] 右子数组取值(mid,right]/[mid+1,right]
        int p1 = left, p2 = mid + 1;
        int cur = 0; // cur 指向当前合并位置
        while (p1 <= mid || p2 <= right) {
            int val1 = (p1 <= mid) ? nums[p1] : Integer.MAX_VALUE;
            int val2 = (p2 <= right) ? nums[p2] : Integer.MAX_VALUE;
            if (val1 <= val2) {
                temp[cur++] = val1;
                p1++;
            } else {
                temp[cur++] = val2;
                p2++;
            }
        }

        // 将临时数组元素重新填充到nums（此处需注意temp[0,len] => nums[left,right]）
        for (int i = 0; i < len; i++) {
            nums[left + i] = temp[i];
        }
    }
     */

    private void merge(int[] nums, int left, int mid, int right) {
        // 创建临时数组存放合并后的元素
        int len = right - left + 1;
        int[] temp = new int[len];

        // 定义双指针用于合并两个数组：左子数组取值[left,mid] 右子数组取值(mid,right]/[mid+1,right]
        int p1 = left, p2 = mid + 1;
        int cur = 0; // cur 指向当前合并位置
        while (p1 <= mid && p2 <= right) {
            if (nums[p1] <= nums[p2]) {
                temp[cur++] = nums[p1++];
            } else {
                temp[cur++] = nums[p2++];
            }
        }
        // 补充尾部
        while (p1 <= mid) {
            temp[cur++] = nums[p1++];
        }
        while (p2 <= right) {
            temp[cur++] = nums[p2++];
        }

        // 将临时数组元素重新填充到nums（此处需注意temp[0,len] => nums[left,right]）
        for (int i = 0; i < len; i++) {
            nums[left + i] = temp[i];
        }
    }

}
