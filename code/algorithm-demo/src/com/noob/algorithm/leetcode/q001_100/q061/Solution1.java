package com.noob.algorithm.leetcode.q001_100.q061;


import com.noob.algorithm.base.dataStructure.linkedList.ListNode;

/**
 * 🟡 061 旋转链表 - https://leetcode.cn/problems/rotate-list/description/
 */
public class Solution1 {

    /**
     * 给定链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置
     * 寻找分割点，分别反转这两部分然后进行拼接
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // 计算链表长度
        int len = 1;
        ListNode tail = head;
        while (tail.next != null) { // 遍历后tail处于最后一个节点
            tail = tail.next;
            len++;
        }

        // 处理k大于链表长度的情况
        k = k % len;
        if (k == 0) {
            return head;
        }

        // 寻找分割点
        ListNode cur = head;
        for (int i = 1; i < len - k; i++) {
            cur = cur.next;
        }

        // 分割链表
        ListNode newHead = cur.next;
        cur.next = null;
        tail.next = head; // 重新拼接

        // 返回结果
        return newHead;
    }

}
