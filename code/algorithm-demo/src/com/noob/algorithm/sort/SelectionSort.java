package com.noob.algorithm.sort;

public class SelectionSort {

    /**
     * 选择排序算法(基础)
     */
    public int[] selectionSortBase(int[] arr) {
        // 选择：每一轮都将当前元素和其后面的元素进行比较，按照升序或降序的要求进行数据交换
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    // 将较大的元素交换到后面
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        // 返回排序后的数组
        return arr;
    }


    /**
     * 选择排序算法(优化)
     * 选择排序实际在每一轮比较中选择的是当前轮次（当前元素所在位置之后的元素）的min或max，最终交换也是将这个最值和当前轮次索引位置进行交换
     * 因此对于过程中的比较可以记录这个最值索引，然后在当前轮次结束后执行一次交换即可（省略过程中一些不必要的交换）
     */
    public int[] selectionSort(int[] arr) {
        // 选择：循环遍历数组，依次比较两个相邻的元素，按照递增或者递减的规则决定元素的交换，将当前轮次的min或max交换到数组末尾
        for (int i = 0; i < arr.length - 1; i++) {
            // 初始化当前轮次的最小值
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    // 更新当前轮次的最值索引
                    minIndex = j;
                }
            }
            // 一轮比较结束之后执行交换（如果minIndex!=i说明最小值索引更新了需要执行交换操作）
            if(minIndex != i) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
        // 返回排序后的数组
        return arr;
    }
}
