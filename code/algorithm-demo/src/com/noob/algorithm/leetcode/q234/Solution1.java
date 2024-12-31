package com.noob.algorithm.leetcode.q234;

import java.util.Stack;

/**
 * 234.回文链表
 * 思路：栈
 */
public class Solution1 {

    public boolean isPalindrome(ListNode head) {

        // 指定stack存储类型
        Stack<Integer> stack = new Stack<>();

        // 记录链表节点指针
        ListNode cur = head;

        // 依次入栈
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }

        // 遍历链表，和出栈元素依次进行比较，如果出现不一致则认为非回文
        while (head != null) {
            if (head.val != stack.pop()) {
                return false;
            }
            // 继续指向下一个
            head = head.next;
        }

        // 返回
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.isPalindrome(head));
    }
}


/**
 * 链表节点定义
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}