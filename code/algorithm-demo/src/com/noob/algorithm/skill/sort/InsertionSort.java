package com.noob.algorithm.skill.sort;

/**
 * 插入排序
 */
public class InsertionSort {
    /**
     * 选择排序算法(基础)
     */
    public int[] selectionSortBase(int[] arr) {
        // 插入：类似排扑克牌的思路，
        // 外循环：已排序区间为 [0, i-1]（i位置前面的元素已经完成排序）
        for (int i = 1; i < arr.length; i++) { // 从第2个元素开始执行第1轮插入
            // 待插入元素
            int curKey = arr[i];
            // 待插入位置（起始从i-1位置开始往前进行比较，确认插入位置）
            int idx = i - 1;
            // 内循环：找到[0,i-1]区间内满足的插入位置，将 base 插入到已排序区间 [0, i-1] 中的正确位置
            while (idx >= 0 && arr[idx] > curKey) { // 如果curKey相对较小则依次往前比较，直到找到第一个合适的位置（此处的while子句实际等价于for循环找位置）
                arr[idx + 1] = arr[idx]; // 将 arr[idx] 向右移动一位
                idx--;
            }
            arr[idx + 1] = curKey;        // 将curKey赋值到正确位置
        }
        // 返回排序后的数组
        return arr;
    }
}
