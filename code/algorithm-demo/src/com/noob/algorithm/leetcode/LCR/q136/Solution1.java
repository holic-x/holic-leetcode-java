package com.noob.algorithm.leetcode.LCR.q136;

import com.noob.algorithm.base.dataStructure.linkedList.ListNode;

/**
 * 🟡 lcr 136: 删除链表的节点
 */
public class Solution1 {

    /**
     * 思路分析：构建虚拟头节点，遍历节点校验nxt
     */
    public ListNode deleteNode(ListNode head, int val) {
        // 构建虚拟头节点
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;
        // 遍历链表，删除链表节点
        while (cur != null && cur.next != null) {
            // 校验cur.next节点是否为待删除节点，如果是则修改cur相关指针
            if (cur.next.val == val) {
                cur.next = cur.next.next; // 此时cur指向待删除节点的前一个节点，修改其next指针
            }
            cur = cur.next;
        }
        // 返回修改后的链表
        return dummy.next;
    }
}
