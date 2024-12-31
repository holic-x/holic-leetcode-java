package com.noob.algorithm.leetcode.q19;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 2-删除倒数第N个节点（链表）
 * 思路2：利用栈的先进后出特性，第1次遍历依次进栈、第2次遍历依次出栈
 * 需要注意的是，不需要设定为将节点加入新链表，主要是定位到那个要删除的节点的前一个节点prev，然后设置`prev.next=prev.next.next`
 */
public class Solution2 {



    public ListNode removeNthFromEnd(ListNode head, int n) {

        // 定义链表(初始化为head原链表)
        ListNode dummy = new ListNode(0,head);
        // 定义链表指针
        ListNode cur = dummy;

        // 定义栈
        Stack<ListNode> stack = new Stack<ListNode>();

        // 1.依次入栈
        while (head != null) {
            stack.push(head);
            head = head.next; // 指针后移
        }

        // 2.依次出栈，当第n个位置则剔除
        for(int i = 0; i < n; i++) {
            stack.pop();
        }
        // 获取到倒数第n-1的节点，更新其next值即可
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        return dummy.next;
    }

    /*
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; ++i) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        ListNode ans = dummy.next;
        return ans;
    }
     */



    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        Solution2 solution2 = new Solution2();
        ListNode result = solution2.removeNthFromEnd(head, 2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next; // 指针后移
        }
    }

}

