package com.noob.algorithm.leetcode.q206;

import java.util.List;
import java.util.Stack;

/**
 * 206.反转链表
 * 思路：栈
 */
public class Solution2 {
    public ListNode reverseList(ListNode head) {

        // 定义结果
        ListNode res = new ListNode(0);
        // 定义当前节点指针
        ListNode cur = res;

        // 定义栈存放中间结果
        Stack<ListNode> stack = new Stack<ListNode>();

        // 遍历链表元素，入栈
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        // 依次出栈构建新链表
        while(!stack.isEmpty()) {
            cur.next = stack.pop();
            cur = cur.next; // 更新节点
        }
        cur.next = null; // 需设置尾节点为null，否则提示（Error - Found cycle in the ListNode）
        return res.next; // 排除第一个初始化的节点（初始化起始值为0，需从其下一个节点遍历）
    }
}


