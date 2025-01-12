package com.noob.algorithm.leetcode.q801_q900.q876;

import com.noob.algorithm.base.dataStructure.linkedList.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 🟢 876 链表的中间节点 - https://leetcode.cn/problems/middle-of-the-linked-list/description/
 */
public class Solution3 {
    /**
     * 思路：单指针
     */
    public ListNode middleNode(ListNode head) {
        // ① 第1次遍历：获取链表长度n
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }

        // ② 第2次遍历：根据链表长度获取中间节点
        int midIdx = n / 2;
        ListNode pt = head;
        while (midIdx-- > 0) {
            pt = pt.next;
        }
        return pt;
    }

}
