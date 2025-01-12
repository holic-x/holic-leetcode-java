package com.noob.algorithm.leetcode.q001_100.q082;

import com.noob.algorithm.base.dataStructure.linkedList.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 🟡 082 删除排序链表中的重复元素II - https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/description/
 */
public class Solution2 {

    /**
     * 模拟法：找出重复出现的元素并记录，然后逐个按照其出现次数执行单个删除节点的方法删除元素
     */
    public ListNode deleteDuplicates(ListNode head) {
        // 记录重复出现的元素
        Map<Integer, Integer> map = new HashMap<>();
        ListNode cur = head;
        while (cur != null) {
            map.put(cur.val, map.getOrDefault(cur.val, 0) + 1); // 记录每个元素出现的次数
            cur = cur.next;
        }

        // 校验元素集合，如果出现次数超过1次则删除
        Set<Integer> keySet = map.keySet();
        for (int key : keySet) {
            if (map.get(key) > 1) {
                int cnt = map.get(key);
                while (cnt-- > 0) {
                    head = delete(head, key); // 删除节点
                }
            }
        }

        return head; // 返回更新后的节点
    }

    private ListNode delete(ListNode head, int target) {
        // 构建虚拟头节点
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;
        while (cur != null && cur.next != null) {
            if (cur.next.val == target) {
                cur.next = cur.next.next;
            }
            cur = cur.next; // 指针后移
        }
        return dummy.next;
    }

}
