package com.noob.algorithm.leetcode.q141;

import java.util.HashSet;

/**
 * 141-环形链表
 * 思路：哈希表  迭代、标记，校验next是否已被标记
 */
public class Solution1 {

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


/**
 * 链表节点定义
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}