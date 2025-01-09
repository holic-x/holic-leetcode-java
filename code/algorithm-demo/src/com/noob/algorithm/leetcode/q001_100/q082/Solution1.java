package com.noob.algorithm.leetcode.q001_100.q082;

import com.noob.algorithm.base.dataStructure.linkedList.ListNode;

/**
 * 🟡 082 删除排序链表中的重复元素II - https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/description/
 */
public class Solution1 {

    /**
     * 思路：一次遍历
     */
    public ListNode deleteDuplicates(ListNode head) {
        // 构建虚拟头节点
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy; // cur 初始化指向虚拟头节点
        // 对链表进行遍历
        while (cur.next != null && cur.next.next != null) {
            int val = cur.next.val; // 记录元素
            if (cur.next.next.val == val) { // 如果出现重复，则不断校验并删除这个重复的元素
                while (cur.next != null && cur.next.val == val) {
                    cur.next = cur.next.next;
                }
            } else {
                // 当cur.next 元素 不等于 cur.next.next 此时说明链表中只有一个值为cur.next的节点，因此此时可以将cur指向cur.next
                cur = cur.next;
            }
        }
        // 链表遍历完成，返回哑节点的下一个节点
        return dummy.next;
    }
}
