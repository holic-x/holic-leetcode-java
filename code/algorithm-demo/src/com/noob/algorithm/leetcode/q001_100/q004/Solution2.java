package com.noob.algorithm.leetcode.q001_100.q004;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 🔴 004 寻找两个正序数组的中位数 - https://leetcode.cn/problems/median-of-two-sorted-arrays/
 */
public class Solution2 {

    /**
     * 思路：堆思路（维护一个大顶堆(left)和一个小顶堆(right)）
     * 大顶堆（left）：存储[0,mid]的元素
     * 小顶堆（right）：存储[mid+1,size-1]的元素
     * 如果元素总和为偶数则两个堆的大小是一样的，如果元素总和为奇数则left堆比right堆多1个元素
     * 整体思路构建如下：参考295-数据流的中位数处理思路
     * ① 构建leftQueue（大顶堆）、rightQueue（小顶堆）维护所有元素，这两个堆衔接起来构成一个有序的序列
     * ② 初始化堆：根据当前堆中元素个数差值来决定当前遍历num的入堆处理：
     * - leftSize == rightSize：当前总元素个数为偶数个，则num需要插入到leftQueue。此处采用置换的思路，先将元素num插入rightQueue，然后将排序后的rightQueue的堆顶元素置换出来放到leftQueue
     * - leftSize != rightSize：当前总元素个数为奇数个，则num需要插入到rightQueue。同理，此处先将元素num插入leftQueue，然后将排序后的leftQueue的堆顶元素置换出来放到rightQueue
     * - 此处处理的设计巧妙之处在于充分利用堆的特性和置换思路，而不用自行手动做各种封装比较
     * ③ 基于处理好的堆，此时leftQueue 和 rightQueue 的堆顶元素恰好对应着中位数的关键，根据元素总数的奇偶性处理即可
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // ① 定义小顶堆、大顶堆维护元素信息
        PriorityQueue<Integer> leftQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1; // 左侧大顶堆
            }
        });
        PriorityQueue<Integer> rightQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2; // 右侧小顶堆
            }
        });

        // ② 遍历元素（根据当前堆元素的数量差来处理载入元素）
        int m = nums1.length, n = nums2.length;
        for (int i = 0; i < m; i++) {
            addNum(leftQueue, rightQueue, nums1[i]);
        }
        for (int j = 0; j < n; j++) {
            addNum(leftQueue, rightQueue, nums2[j]);
        }

        // ③ 根据排序好的堆元素的奇偶来获取中位数
        if ((m + n) % 2 == 0) {
            return (leftQueue.peek() + rightQueue.peek()) / 2.0;
        } else if ((m + n) % 2 == 1) {
            return leftQueue.peek();
        }
        return -1;
    }

    // 处理元素
    private void addNum(PriorityQueue<Integer> leftQueue, PriorityQueue<Integer> rightQueue, int num) {
        // 根据当前左、右堆的元素个数来处理
        if (leftQueue.size() == rightQueue.size()) {
            // 当两个集合元素个数相等（偶数），需要向leftQueue插入元素：将元素num插入到rightQueue，随后将rightQueue的堆顶元素置换到leftQueue（以此确保left始终比right多一个元素）
            rightQueue.offer(num);
            leftQueue.offer(rightQueue.poll());
        } else {
            // 当两个即可元素个数不相等（奇数），需要向rightQueue插入元素：将元素num插入到leftQueue，随后将leftQueue的堆顶元素置换到rightQueue
            leftQueue.offer(num);
            rightQueue.offer(leftQueue.poll());
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        Solution2 solution = new Solution2();
        double res = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
    }

}
