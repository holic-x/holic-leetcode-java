package com.noob.algorithm.leetcode.q401_500.q445;


import com.noob.algorithm.base.dataStructure.linkedList.ListNode;

import java.util.Stack;

/**
 * 🟡 445 两数相加 - https://leetcode.cn/problems/add-two-numbers-ii/description/
 */
public class Solution1 {

    /**
     * 不同于顺序相加的操作，此处是高位在左、低位在右，因此需要考虑将数据压栈，然后依次取出
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // 将两个链表的数据依次压栈
        Stack<Integer> st1 = new Stack<>();
        while (l1 != null) {
            st1.push(l1.val);
            l1 = l1.next;
        }
        Stack<Integer> st2 = new Stack<>();
        while (l2 != null) {
            st2.push(l2.val);
            l2 = l2.next;
        }

        ListNode dummy = null;// 构建虚拟头节点 new ListNode(-1),新节点头插方式插入

        // 依次取出栈数据
        boolean carry = false; // carry 表示进位
        while (!st1.isEmpty() || !st2.isEmpty() || carry) {
            int val1 = st1.isEmpty() ? 0 : st1.pop();
            int val2 = st2.isEmpty() ? 0 : st2.pop();
            int sum = val1 + val2 + (carry ? 1 : 0);
            // 处理存储值和进位
            int val = sum % 10;
            carry = (sum / 10 == 1);
            // 头插
            ListNode node = new ListNode(val,dummy);
            dummy = node ;
        }

        // 返回构建的链表
        return dummy;

    }
}
