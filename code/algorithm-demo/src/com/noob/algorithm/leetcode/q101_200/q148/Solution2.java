package com.noob.algorithm.leetcode.q101_200.q148;

import com.noob.algorithm.base.dataStructure.linkedList.ListNode;

/**
 * 🟡 148-单链表排序 - https://leetcode.cn/problems/sort-list/
 */
public class Solution2 {

    /**
     * 归并排序思路：
     * ① 找中点、拆分两个链表
     * ② 分：分别对两个链表进行排序
     * ③ 合：将排序后的两个链表进行合并（参考【合并两个有序链表思路】）
     */
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        // 寻找链表中点
        ListNode midNode = findMid(head);

        // 拆分链表,并对拆分的链表分别进行排序
        ListNode right = sortList(midNode.next);
        midNode.next = null;
        ListNode left = sortList(head);

        // 合并排序后的链表
        ListNode mergeNode = merge(left, right);

        return mergeNode;

    }

    // 寻找链表中点（快慢指针思路）
    private ListNode findMid(ListNode head) {
        // 定义快慢指针寻找中点
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 返回中点
        return slow;
    }


    // 合并两个有序链表（双指针）
    private ListNode merge(ListNode l1, ListNode l2) {
        // 构建虚拟头节点
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        // 定义指针分别遍历两个链表
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null && p2 != null) {
            // 选择较小的值载入
            if (p1.val <= p2.val) {
                cur.next = p1;
                cur = cur.next;
                p1 = p1.next;
            } else {
                cur.next = p2;
                cur = cur.next;
                p2 = p2.next;
            }
        }
        // 处理尾巴
        if (p1 != null) {
            cur.next = p1;
        }
        if (p2 != null) {
            cur.next = p2;
        }

        // 返回构建的新链表
        return dummy.next;

    }

}
