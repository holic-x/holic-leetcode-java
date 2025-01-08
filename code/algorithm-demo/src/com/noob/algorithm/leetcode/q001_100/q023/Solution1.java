package com.noob.algorithm.leetcode.q001_100.q023;

import com.noob.algorithm.base.dataStructure.linkedList.ListNode;

/**
 * 🔴 023 合并K个升序链表 - https://leetcode.cn/problems/merge-k-sorted-lists/description/
 */
public class Solution1 {

    /**
     * 思路：两两合并后归并
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode base = lists[0];
        for (int i = 1; i < lists.length; i++) {
            ListNode newList = mergeTwoList(base, lists[i]); // 两两合并
            base = newList; // 更新base作为下一次合并基础
        }

        // 返回最终合并的结果
        return base;
    }

    /**
     * 两两合并链表
     */
    public ListNode mergeTwoList(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        // 定义指针分别遍历l1、l2
        ListNode pointer1 = l1;
        ListNode pointer2 = l2;
        while (pointer1 != null && pointer2 != null) {
            // 比较值的大小，选择较小的一边
            if (pointer1.val <= pointer2.val) {
                cur.next = new ListNode(pointer1.val);
                // 指针移动
                cur = cur.next;
                pointer1 = pointer1.next;
            } else {
                cur.next = new ListNode(pointer2.val);
                // 指针移动
                cur = cur.next;
                pointer2 = pointer2.next;
            }
        }

        // 判断是否有剩余尾巴，直接拼接
        if (pointer1 != null) {
            cur.next = pointer1;
        }
        if (pointer2 != null) {
            cur.next = pointer2;
        }

        // 返回构建的新链表
        return dummy.next;
    }
}
