package com.noob.algorithm.leetcode.q141;

import com.noob.algorithm.base.dataStructure.linkedList.ListNode;

import java.util.HashSet;

/**
 * 🟢 141-环形链表 - https://leetcode.cn/problems/linked-list-cycle/
 */
public class Solution1 {

    /**
     * 思路：哈希表  迭代、标记，校验next是否已被标记
     */
    public boolean hasCycle(ListNode head) {

        // 定义HashSet存储元素
        HashSet<ListNode> set = new HashSet<ListNode>();

        // 遍历链表，校验next是否已存在标记
        while(head != null) {
            if(set.contains(head)) {
                return true;
            }
            // 将当前节点进行标记
            set.add(head);
            // 迭代下一个元素
            head = head.next;
        }
        return false;

    }

}
