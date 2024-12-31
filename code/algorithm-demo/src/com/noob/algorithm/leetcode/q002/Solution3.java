package com.noob.algorithm.leetcode.q002;

import com.noob.algorithm.base.dataStructure.tree.ListNode;

/**
 * 2-两数相加
 * 思路：将各个节点的值进行相加，处理相应的进位关系
 */
public class Solution3 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // 定义链表
        ListNode res = new ListNode(0);

        // 定义链表指针
        ListNode cur = res;

        // 边界值处理（l1为null，或者l2为null）
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        // 定义进位标识
        boolean carry = false;
        // 循环遍历两个链表
        while (l1 != null || l2 != null || carry) {
            // 可能会有个链表先为空，需做空指针处理
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;

            // 获取对应节点值之和，需要处理进位关系
            int currentVal = carry ? (a + b + 1) : (a + b); // 如果carry为true需要加上进位
            // 处理当前节点存储数据和进位配置(如果currentVal>=10表示需要进位，当前节点直接存储取模后的数字)
            cur.next = new ListNode(currentVal % 10);
            carry = currentVal >= 10 ? true : false;

            // 指针后移
            cur = cur.next;

            // 判断是否有下一个节点
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        // 处理最后的进位(也可加进位条件加入循环，而不需此处额外处理)
        /*
        if (carry) {
            cur.next = new ListNode(1);
        }
         */

        // 返回链表结果
        return res.next;
    }


    /*
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // 定义链表
        ListNode res = new ListNode(0);

        // 定义链表指针
        ListNode cur = res;

        // 边界值处理（l1为null，或者l2为null）
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        // 定义进位标识
        boolean carry = false;
        // 循环遍历两个链表
        while (l1 != null && l2 != null) {
            // 获取对应节点值之和，需要处理进位关系
            int currentVal = carry ? (l1.val + l2.val + 1) : (l1.val + l2.val); // 如果carry为true需要加上进位
            // 处理当前节点存储数据和进位配置(如果currentVal>=10表示需要进位，当前节点直接存储取模后的数字)
            cur.next = new ListNode(currentVal % 10);
            carry = currentVal >= 10 ? true : false;

            // 指针后移
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        // 判断是否有剩余节点，直接进行追加，还是需处理进位关系（可以将其放入到上述循环，然后做空指针处理）
        if (l1 != null) {
            l1 = l1.next;
        }
        if (l2 != null) {
            l2 = l2.next;
        }

        // 返回链表结果
        return res.next;
    }
     */
}