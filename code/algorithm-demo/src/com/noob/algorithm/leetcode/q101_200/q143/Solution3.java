package com.noob.algorithm.leetcode.q101_200.q143;

import com.noob.algorithm.base.dataStructure.linkedList.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 🟡 143 重排链表 - https://leetcode.cn/problems/reorder-list/description/
 */
public class Solution3 {

    /**
     * 思路：寻找中点 + 后半段逆序 + 合并链表
     */
    public void reorderList(ListNode head) {
        // ① 寻找链表中点并切割链表为两部分（left，right）
        ListNode midNode = findMidNode(head);

        ListNode right = midNode.next;
        midNode.next = null;
        ListNode left = head;

        // ② 将后半段链表进行逆序
        ListNode reverseRight = reverseList(right);

        // ③ 合并left、reverseRight
        ListNode merge = mergeList(left, reverseRight);

        // 返回结果
        // return merge;
        head = merge;
    }


    // 寻找链表中点
    public ListNode findMidNode(ListNode head) {
        // 定义快慢指针寻找链表中点
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 原地反转链表
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            // 记录cur.next
            ListNode nxt = cur.next;
            // 反转指针
            cur.next = pre;
            // 滚动更新指针
            pre = cur;
            cur = nxt;
        }
        // 返回反转后的链表
        return pre;
    }

    // 合并两个链表
    public ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        // 定义指针遍历两个链表
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null && p2 != null) {
            // 载入l1链表元素
            cur.next = p1;
            cur = cur.next;
            p1 = p1.next;
            // 载入l2链表元素
            cur.next = p2;
            cur = cur.next;
            p2 = p2.next;
        }
        if (p1 != null) {
            cur.next = p1;
        }
        if (p2 != null) {
            cur.next = p2;
        }

        // 返回合并后的链表
        return dummy.next;
    }

}
