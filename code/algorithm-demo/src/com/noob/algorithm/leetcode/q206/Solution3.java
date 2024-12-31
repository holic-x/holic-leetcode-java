package com.noob.algorithm.leetcode.q206;

import java.util.Stack;

/**
 * 206.反转链表
 * 思路：迭代
 */
public class Solution3 {
    public ListNode reverseList(ListNode head) {

        // 记录当前节点和当前节点的上一个节点
        ListNode prev = null;
        ListNode curr = head;

        // 迭代链表
        while (curr != null) {
            ListNode next = curr.next; // 记录当前节点的下一个节点
            curr.next = prev; // 将当前节点的next指向指向prev
            prev = curr; // prev设定为当前节点（会作为下一节点的prev）
            curr = next; // curr指向下一个节点（继续遍历）
        }

        // 返回链表
        return prev;
    }
}


