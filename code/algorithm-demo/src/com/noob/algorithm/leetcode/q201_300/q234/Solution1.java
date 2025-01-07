package com.noob.algorithm.leetcode.q201_300.q234;

import com.noob.algorithm.base.dataStructure.linkedList.ListNode;

import java.util.Stack;

/**
 * 🟢 234.回文链表 - https://leetcode.cn/problems/palindrome-linked-list/description/
 */
public class Solution1 {

    /**
     * 思路：栈 (将链表转化为集合进行校验)
     */
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

}
