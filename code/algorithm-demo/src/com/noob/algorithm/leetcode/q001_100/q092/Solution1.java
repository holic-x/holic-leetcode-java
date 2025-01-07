package com.noob.algorithm.leetcode.q001_100.q092;

import com.noob.algorithm.base.dataStructure.linkedList.ListNode;

/**
 * 🟡 92 反转链表II
 */
public class Solution1 {

    /**
     * 反转指定范围后的链表
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 遍历链表，找到反转位置并截断
        ListNode cur = head;
        ListNode preStartNode = null, endNode = null;
        for (int i = 0; i <= right; i++) {
            if (i == left - 1) {
                preStartNode = cur;
            }
            if (i == right) {
                endNode = cur;
            }
            cur = cur.next;
        }
        ListNode startNode = preStartNode.next;
        // 将链表拆成3段，然后将中间段进行反转后拼接
        preStartNode.next = null; // 断开连接
        ListNode endNxtNode = endNode.next; // 记录结束节点的下一个节点链表
        endNode.next = null; // 断开连接

        // 对startNode这节链表进行反转
        ListNode reverseNode = reverse(startNode);

        // 重新拼接
        preStartNode.next = reverseNode;
        startNode.next = endNxtNode;

        // 返回拼接后的链表
        return head;
    }

    /**
     * 反转指定链表
     */
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            // 滚动更新指针
            cur = nxt;
            pre = cur;
        }
        // 返回反转后的链表
        return pre;
    }
}
