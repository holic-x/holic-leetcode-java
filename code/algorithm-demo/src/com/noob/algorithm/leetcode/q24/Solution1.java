package com.noob.algorithm.leetcode.q24;

import java.util.HashSet;

/**
 * 24-两两交换链表中的节点
 * 在不修改节点值的情况下进行操作
 */
public class Solution1 {

    public ListNode swapPairs(ListNode head) {
        // 增设虚拟头节点
        ListNode dummy = new ListNode(0, head);
        // 设置节点指针
        ListNode cur = dummy;

        // 遍历链表，进行元素交换(结合图示分析，链表节点交换操作需要两个元素)
        while (cur.next != null && cur.next.next != null) {
            // 记录节点信息
            ListNode node3 = cur.next.next.next;
            ListNode node1 = cur.next;
            ListNode node2 = cur.next.next;
            // 执行节点交换
            cur.next = node2;
            node2.next = node1;
            node1.next = node3;
            // 指针后移，准备下一轮交换(需注意此处cur指向的要遍历的下一个节点应为node1,而非cur.next)
            cur = node1;
        }
        // 返回链表
        return dummy.next;
    }

}


/**
 * 链表节点定义
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}