package com.noob.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {
    /**
     * 冒泡排序算法
     */
    public int[] bubbleSort(int[] arr) {
        // 冒泡：循环遍历数组，依次比较两个相邻的元素，按照递增或者递减的规则决定元素的交换，将当前轮次的min或max交换到数组末尾
        for(int i = 0; i < arr.length - 1; i++) {
            // 依次比较相邻两个元素（此处边界设定考虑有两个因素：一是相邻两个元素比较，二是数组尾部的是前面轮次放置的最大值，因此在后面的轮次中无需重复比较）
            for(int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    // 将较大的元素交换到后面
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        // 返回排序后的数组
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 5, 15, 26, 27, 2, 36 };
        BubbleSort bubbleSort = new BubbleSort();
        Arrays.stream(bubbleSort.bubbleSort(arr)).forEach(System.out::println);
    }
}
