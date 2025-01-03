package com.noob.algorithm.leetcode.q019;

import com.noob.algorithm.base.dataStructure.linkedList.ListNode;

import java.util.Stack;

/**
 * 🟡019-删除倒数第N个节点（链表） - https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 * 思路2：利用栈的先进后出特性，第1次遍历依次进栈、第2次遍历依次出栈
 * 需要注意的是，不需要设定为将节点加入新链表，主要是定位到那个要删除的节点的前一个节点prev，然后设置`prev.next=prev.next.next`
 */
public class Solution2 {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        // 定义链表(初始化为head原链表)
        ListNode dummy = new ListNode(-1, head);
        // 定义链表指针
        ListNode cur = dummy;

        // 定义栈
        Stack<ListNode> stack = new Stack<ListNode>();

        // 1.依次入栈
        while (cur != null) {
            stack.push(cur);
            cur = cur.next; // 指针后移
        }

        // 2.依次出栈，当第n个位置则剔除
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        // 获取到倒数第n-1的节点，更新其next值即可
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        return dummy.next;
    }

}

