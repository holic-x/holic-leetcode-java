package com.noob.algorithm.leetcode.q101_200.q143;

import com.noob.algorithm.base.dataStructure.linkedList.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 🟡 143 重排链表 - https://leetcode.cn/problems/reorder-list/description/
 */
public class Solution2 {

    /**
     * 思路：遍历链表，装载所有链表节点，然后按照奇偶数位来拼接链表
     */
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }

        // 重新处理链表节点的连接关系
        ListNode pre = list.get(0);
        int evenIdx = 0, oddIdx = list.size() - 1;
        for (int i = 0; i < list.size(); i++) {
            if (i % 2 == 0) {
                pre.next = list.get(evenIdx);
                pre = pre.next;
                evenIdx++;
            } else if (i % 2 == 1) {
                pre.next = list.get(oddIdx);
                pre = pre.next;
                oddIdx--;
            }
        }
        pre.next = null; // handle cycle
    }
}
