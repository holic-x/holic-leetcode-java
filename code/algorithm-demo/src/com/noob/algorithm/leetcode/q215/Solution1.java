package com.noob.algorithm.leetcode.q215;

import java.util.PriorityQueue;

/**
 * 🟡 215.数组中的第K个最大元素 - https://leetcode.cn/problems/kth-largest-element-in-an-array/description/
 * 思路：排序法
 */
public class Solution1 {

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

}