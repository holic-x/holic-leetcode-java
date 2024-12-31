package com.noob.algorithm.leetcode.q215;

import java.util.PriorityQueue;

/**
 * 215.数组中的第K个最大元素
 * 思路：排序法
 */
public class Solution {

    // 堆（优先队列）
    public int findKthLargest(int[] nums, int k) {
        // 基于Java提供的PriorityQueue构建小顶堆
        PriorityQueue<Integer> queue = new PriorityQueue();

        // 遍历数组的前k个元素，将它们加入最小堆中
        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }

        // 遍历数组的剩余元素
        for (int i = k; i < nums.length; i++) {
            // 如果当前元素大于堆顶元素（即堆中最小的元素），则替换掉堆顶元素
            if (nums[i] > queue.peek()) {
                queue.poll(); // 移除堆顶元素
                queue.offer(nums[i]); // 添加新的较大元素到堆中
            }
            // 注意：这里不需要else，因为此处只关心当nums[i]大于堆顶时的情况。如果nums[i]小于等于堆顶，那么它就不会成为前k大的元素之一
        }

        // 堆顶元素即为第k大的元素，返回它
        return queue.peek();
    }

    // 排序法
    public int findKthLargest1(int[] nums, int k) {
        // 将数组元素按照逆序排序，然后返回nums[k]，排序可以借助工具类进行排序，此处可以使用冒泡排序
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    // 逆序排序，将较小的值交换到后排
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        // 返回排序后第K个最大元素（数组下标从0开始）
        return nums[k - 1];
        // 如果是降序排序，则返回nums[n-k]
    }
}
