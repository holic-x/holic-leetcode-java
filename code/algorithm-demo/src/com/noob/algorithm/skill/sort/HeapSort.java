package com.noob.algorithm.skill.sort;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSort {

    /**
     * 堆排序：
     * ① 构建大顶堆（用于辅助构建升序序列）
     * ② 顶底交换 + 堆化调整：
     * - 将堆顶元素和堆底元素进行交换，交换后堆的有效范围减1，已排序序列加1
     * - 交换后可能会破坏原有的堆结构，需要自顶向下进行堆化操作，以恢复堆结构
     * ③ 重复n-1次步骤②
     */
    public void heapSort(int[] arr) {
        // 1.构建大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            // 从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr, i, arr.length);
        }

        // 顶底交换 + 堆化调整
        for (int j = arr.length - 1; j > 0; j--) { // 此处从底部元素位置开始遍历
            swap(arr, 0, j);// 将堆顶元素与末尾元素进行交换
            adjustHeap(arr, 0, j);// 从根结点开始到指定范围，由顶到底进行堆化
        }

    }

    // 交换数组元素
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 堆化调整(此处堆化调整是针对大顶堆已构建的基础上)
    private void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];//先取出当前元素i
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {// 从i结点的左子结点开始，也就是2i+1处开始
            if (k + 1 < length && arr[k] < arr[k + 1]) {// 如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if (arr[k] > temp) {// 如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;// 将temp值放到最终的位置
    }

    public static void main(String[] args) {
        HeapSort hs = new HeapSort();
        // int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] arr = new int[]{7, 3, 2, 6, 0, 1, 5, 4};
        hs.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
