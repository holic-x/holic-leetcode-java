package com.noob.algorithm.leetcode.q002;

import com.noob.algorithm.base.dataStructure.tree.ListNode;

/**
 * 2-两数相加
 * 思路：错误思路（此处并不是将每个链表对应位置数字相加然后放入链表节点，实际上应该要将链表组成的数字相加，然后再放在一个新链表中，链表中每个节点存一个数字）
 * 错误实现
 */
public class Solution1 {

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

        // 循环遍历两个链表
        while (l1 != null && l2 != null) {
            // 获取对应节点值之和，然后将存入新链表(每个节点只能存一位数字，直接对10取模)
            cur.next = new ListNode((l1.val + l2.val) % 10);
            // 指针后移
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        // 判断是否有剩余节点，直接进行追加
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }

        // 返回链表结果
        return res.next;
    }
}


