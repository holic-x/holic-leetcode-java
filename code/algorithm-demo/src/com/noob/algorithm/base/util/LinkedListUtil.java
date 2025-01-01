package com.noob.algorithm.base.util;

import com.noob.algorithm.base.dataStructure.linkedList.ListNode;

/**
 * 链表辅助工具类：构建链表、打印链表数据等
 */
public class LinkedListUtil {

    // 传入数组，构建链表，返回头节点
    public static ListNode createLink(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        // 构建链表
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy; // 定义遍历指针
        for (int i = 0; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
        // 返回构建的链表
        return dummy.next;
    }

    // 打印链表数据
    public static void printLink(ListNode head){
        ListNode cur = head;
        while(cur!=null){
            System.out.print("[" + cur.val + "]" + "->");
            cur = cur.next;
        }
        System.out.println("[end]");
    }

}
