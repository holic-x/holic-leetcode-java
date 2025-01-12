package com.noob.algorithm.leetcode.q801_q900.q876;

import com.noob.algorithm.base.dataStructure.linkedList.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 🟢 876 链表的中间节点 - https://leetcode.cn/problems/middle-of-the-linked-list/description/
 */
public class Solution2 {
    /**
     * 思路：集合处理
     */
    public ListNode middleNode(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }

        // 返回中间节点
        return list.get(list.size() / 2);
    }

}
