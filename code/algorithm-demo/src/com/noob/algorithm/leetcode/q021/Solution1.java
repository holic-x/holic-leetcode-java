package com.noob.algorithm.leetcode.q021;

import com.noob.algorithm.base.dataStructure.linkedList.ListNode;

/**
 * 🟢 21-合并链表 - https://leetcode.cn/problems/merge-two-sorted-lists/description/
 */
public class Solution1 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        // 定义虚拟节点头
        ListNode res = new ListNode(0); // 这个链表头节点可以为任意，因为不需要用到这个头节点的值

        // 定义对应链表指针
        ListNode cur = res;

        // 边界值确认（l1、l2为空的情况）
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        // l1、l2都不为空的情况,遍历链表（不断比较l1、l2各个节点的值）
        while (l1 != null && l2 != null) {
            // 如果l1当前节点的值小于l2当前节点
            if (l1.val <= l2.val) {
                cur.next = l1;// 让指针指向当前这个较小的节点链表
                l1 = l1.next; // l1 指向下一个节点（l1向后移动）
            } else {
                cur.next = l2;// 让指针指向当前这个较小的节点链表
                l2 = l2.next; // l2 指向下一个节点（l2向后移动）
            }
            // 指针向后移动
            cur = cur.next;
        }

        // 如果l1、l2还有没有覆盖到的节点（因为不知道l1、l2哪个长，所以上述操作循环结束，可能长的链表中还有节点没有覆盖到）
        if (l1 != null) {
            cur.next = l1; // 将当前l1剩下的节点全部进行追加
        }
        if (l2 != null) {
            cur.next = l2; // 将当前l2剩下的节点全部进行追加
        }
        // 最后返回虚拟节点头的next指针
        return res.next;
    }

}

