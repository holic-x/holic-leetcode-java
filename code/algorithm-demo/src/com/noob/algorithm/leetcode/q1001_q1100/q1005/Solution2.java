package com.noob.algorithm.leetcode.q1001_q1100.q1005;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 🟢 1005 K 次取反后最大化的数组和 - https://leetcode.cn/problems/maximize-sum-of-array-after-k-negations/description/
 */
public class Solution2 {

    /**
     * 重复k次将某个元素nums[i]变成其相反数-nums[i]
     * 思路：堆思路（优化排序过程）
     */
    public int largestSumAfterKNegations(int[] nums, int k) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1 - o2; // 构建最小堆
                    }
                }
        );

        // 遍历元素依次入堆
        for (int i = 0; i < nums.length; i++) {
            priorityQueue.offer(nums[i]);
        }

        // 执行k次对最小的元素取反操作
        while (k-- > 0) {
            int val = priorityQueue.poll();
            priorityQueue.offer(-1 * val);
        }

        // 统计累加和
        int res = 0;
        while (!priorityQueue.isEmpty()) {
            res += priorityQueue.poll();
        }

        return res;
    }

}
