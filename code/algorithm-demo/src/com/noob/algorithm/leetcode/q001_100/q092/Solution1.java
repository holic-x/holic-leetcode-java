package com.noob.algorithm.leetcode.q001_100.q092;

import com.noob.algorithm.base.dataStructure.linkedList.ListNode;

/**
 * 🟡 092 反转链表II - https://leetcode.cn/problems/reverse-linked-list-ii/description/
 */
public class Solution1 {

    /**
     * 分段处理：分段 + 反转 + 重新链接
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 构建虚拟头节点，基于dummy遍历寻找要进行反转的区间范围相关节点
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;
        // 获取开始节点的前一个节点
        for (int i = 0; i < left - 1; i++) {
            cur = cur.next;
        }

        ListNode preStartNode = cur; // 记录反转起点的前一个节点
        ListNode startNode = cur.next; // 记录反转起点
        for (int i = 0; i < right - left + 1; i++) {
            cur = cur.next;
        }
        ListNode endNode = cur; // 记录反转终点
        ListNode endNxtNode = cur.next; // 记录反转终点的下一个节点

        // ① 断开链表
        preStartNode.next = null;
        endNode.next = null;
        // ② 反转中间段链表
        ListNode reverseNode = reverse(startNode);
        // ③ 重新链接
        preStartNode.next = reverseNode;
        startNode.next = endNxtNode; // 范围反转后原起点变为反转后的链表终点，将其和下一段链表链接在一起

        // 返回结果
        return dummy.next;
    }

    // 反转链表
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nxt = cur.next; // 记录下一个节点
            cur.next = pre;
            // 更新指针
            pre = cur;
            cur = nxt;
        }
        // 返回反转后的链表
        return pre;
    }
}
