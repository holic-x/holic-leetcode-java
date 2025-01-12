package com.noob.algorithm.leetcode.q101_200.q142;

import com.noob.algorithm.base.dataStructure.linkedList.ListNode;

import java.util.HashSet;

/**
 * 🟡 142-环形链表II - https://leetcode.cn/problems/linked-list-cycle-ii/
 */
public class Solution2 {

    /**
     * 思路：快慢指针（先判断是否存在环，如果存在则让指针和当前slow同时同步触发，再次相遇即为环入口）
     */
    public ListNode detectCycle(ListNode head) {

        ListNode slow = head, fast = head;

        boolean hasCycle = false;
        // 指针同时出发
        while (fast != null && fast.next != null) { // 如果fast先走到链表末尾则说明不存在环
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true; // 存在环
                break; // 如果两个指针相遇则说明存在环，跳出循环
            }
        }

        // 判断是否存在环（确认上述循环跳出条件）
        if (!hasCycle) {
            return null; // 链表无环，返回null
        }

        // 链表有环，寻找环入口
        ListNode cur = head; // cur指针从链表头出发，slow从当前位置出发
        while (cur != slow) {
            cur = cur.next;
            slow = slow.next;
        }
        // 两者相遇则为环入口
        return cur;
    }

}