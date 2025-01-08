package com.noob.algorithm.leetcode.q001_100.q023;

import com.noob.algorithm.base.dataStructure.linkedList.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 🔴 023 合并K个升序链表 - https://leetcode.cn/problems/merge-k-sorted-lists/description/
 */
public class Solution3 {

    /**
     * 思路：基于优先队列思路，维护k个元素的小顶堆
     * - 取出：每次取出一个元素node（最小堆的堆顶元素）
     * - 入堆：选出node入队，将node.next重新入堆
     */
    public ListNode mergeKLists(ListNode[] lists) {
        // 构建优先队列辅助存储
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(
                new Comparator<ListNode>() {
                    @Override
                    public int compare(ListNode o1, ListNode o2) {
                        return o1.val - o2.val;
                    }
                }
        );

        // 将集合链表依次入队
        for (ListNode node : lists) {
            if (node != null) {
                priorityQueue.offer(node);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        // 遍历队列
        while (!priorityQueue.isEmpty()) {
            ListNode node = priorityQueue.poll();
            ListNode nxt = node.next;

            // 拼接新链表
            node.next = null; // 断开连接
            cur.next = node;
            cur = cur.next;

            // 将nxt节点入堆
            if (nxt != null) {
                priorityQueue.offer(nxt);
            }
        }

        // 返回构建的新链表
        return dummy.next;
    }

}
