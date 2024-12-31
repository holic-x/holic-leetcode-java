package com.noob.algorithm.leetcode.q002;

import com.noob.algorithm.base.dataStructure.linkedList.ListNode;
import com.sun.source.tree.Tree;

/**
 * 🟡 2-两数相加（超出内存限制）
 * https://leetcode.cn/problems/add-two-numbers/
 * 思路：将链表组成的数字相加，然后再放在一个新链表中，链表中每个节点存一个数字）
 */
public class Solution1 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 定义链表
        ListNode dummy = new ListNode(0);
        // 定义链表指针
        ListNode cur = dummy;

        // 分别遍历链表，组合数字(数字是逆序存放的)
        StringBuffer sb1 = new StringBuffer();
        while (l1 != null) {
            sb1.append(l1.val);
            l1 = l1.next;
        }
        StringBuffer sb2 = new StringBuffer();
        while (l2 != null) {
            sb2.append(l2.val);
            l2 = l2.next;
        }
        // 计算数字之和
        long sum = Long.valueOf(sb1.reverse().toString()) + Long.valueOf(sb2.reverse().toString()); // handle NumberFormatException 需注意大数处理

        // 将构建好的数字加入新链表(逆序存放)
        StringBuffer sumStr = new StringBuffer(String.valueOf(sum)).reverse();
        for (int i = 0; i < sumStr.length(); i++) {
            cur.next = new ListNode(sumStr.charAt(i) - '0'); // 将char类型转化为int
            cur = cur.next;
        }

        // 返回链表
        return dummy.next;
    }
}