package com.noob.algorithm.leetcode.q160;

import com.noob.algorithm.base.dataStructure.linkedList.ListNode;

/**
 * 🟢 160-相交链表 - https://leetcode.cn/problems/intersection-of-two-linked-lists/
 */
public class Solution1 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode common = null;
        // 判断边界（链表为NULL的情况）
        if (headA == null || headB == null) {
            return null;
        }

        // 初始化指针(pointA、pointB分别指向A、B链表头节点)
        ListNode pointA = headA;
        ListNode pointB = headB;

        // 两个指针指向同一个节点，遍历结束（根据这个共同节点判断是否为null进而确定是否存在公共节点）
        while (pointA != pointB) {
            // 遍历A链表
            if (pointA != null) {
                // 如果pointA不为NULL则不断向后移动
                pointA = pointA.next;
            } else {
                // 如果pointA为NULL则跳到B链表
                pointA = headB;
            }

            // 遍历B链表
            if (pointB != null) {
                // 如果pointB不为NULL则不断向后移动
                pointB = pointB.next;
            } else {
                // 如果pointB为NULL则跳到A链表
                pointB = headA;
            }
        }

        // pointA、pointB最终都指向同一个节点,要么是公共节点、要么是NULL,所以此处返回任意一个都可以
        return pointA;
    }
}
