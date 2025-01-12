package com.noob.algorithm.leetcode.q201_300.q215;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 🟡 215.数组中的第K个最大元素 - https://leetcode.cn/problems/kth-largest-element-in-an-array/description/
 * 思路：排序法
 */
public class Solution3 {

    // 堆（优先队列）:大顶堆
    public int findKthLargest(int[] nums, int k) {
        // 基于Java提供的PriorityQueue构建大顶堆
        PriorityQueue<Integer> queue = new PriorityQueue(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return (int) o2 - (int) o1;
            }
        });

        // 初始化大顶堆
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
        }

        // 弹出K-1个元素
        for (int i = 1; i <= k - 1; i++) {
            queue.poll();
        }
        // 返回第K大元素
        return queue.peek();
    }

}