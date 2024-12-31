package com.noob.algorithm.leetcode.q148;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * 148-单链表排序
 * 思路1：暴力法（遍历链表节点、排序、根据排序结果回写）
 */
public class Solution1 {

    public ListNode sortList(ListNode head) {
        // 定义结果
        ListNode res = new ListNode(0);

        // 定义指针
        ListNode cur = head;

        // 定义集合存储
        ArrayList<Integer> list = new ArrayList<Integer>();

        // 步骤①：遍历链表
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next; // 指针后移
        }

        // 排序
        Collections.sort(list); // 借助工具类进行排序

        // 初始化新链表指针
        cur = res;
        // 回写链表
        for (int i : list) {
            cur.next = new ListNode(i);
            cur = cur.next;// 指针后移
        }
        // 返回结果
        return res.next;
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