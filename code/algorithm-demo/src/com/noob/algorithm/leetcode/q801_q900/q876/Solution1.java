package com.noob.algorithm.leetcode.q801_q900.q876;

import com.noob.algorithm.base.dataStructure.linkedList.ListNode;

/**
 * 🟢 876 链表的中间节点 - https://leetcode.cn/problems/middle-of-the-linked-list/description/
 */
public class Solution1 {
    /**
     * 思路：快慢指针（两个指针同时出发，慢指针走1步、快指针走两步，当快指针走到链表末尾时此时慢指针指向中点位置）
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next; // 慢指针走1步
            fast = fast.next.next; // 快指针走2步
        }

        // 在无环情况下fast走到链表尾部，此时slow为中点位置
        return slow; // 链表节点个数为奇数slow指向中间结点，链表个数为偶数slow指向第2个中间结点
    }

    public ListNode middleNode1(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode slow = dummy, fast = dummy;
        while (fast != null && fast.next != null) {
            slow = slow.next; // 慢指针走1步
            fast = fast.next.next; // 快指针走2步
        }

        // 在无环情况下fast走到链表尾部，此时slow为中点位置
        return slow; // 链表节点个数为奇数slow指向中间结点，链表个数为偶数slow指向第1个中间结点
    }
}
