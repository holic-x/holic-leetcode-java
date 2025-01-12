package com.noob.algorithm.leetcode.q001_100.q083;

import com.noob.algorithm.base.dataStructure.linkedList.ListNode;
import com.noob.algorithm.base.util.LinkedListUtil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 🟢 083 删除排序链表中的重复元素 - https://leetcode.cn/problems/remove-duplicates-from-sorted-list/description/
 */
public class Solution1 {

    /**
     * 思路分析：一次遍历，基于已排序的链表，删除连续出现的元素
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        // 构建虚拟头节点
        ListNode cur = head;

        // 此处链表本身有序，校验cur和cur.next是否连续重复，如果出现连续重复则删除cur.next
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next; // 删除cur.next，则cur指向的是当前待删除节点的前一个节点，修改其next指针
            } else {
                cur = cur.next; // 指针后移，遍历下一个元素
            }
        }
        return head;
    }

}
