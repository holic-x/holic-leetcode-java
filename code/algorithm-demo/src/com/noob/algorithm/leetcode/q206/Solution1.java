package com.noob.algorithm.leetcode.q206;

/**
 * 206.反转链表
 * 思路：直接颠倒（头插）
 */
public class Solution1 {
    public ListNode reverseList(ListNode head) {

        // 定义结果
        ListNode res = null;

        // 遍历链表
        for(ListNode cur = head; cur != null; cur = cur.next) {
            // 传入指定值和链表，创建一个ListNode进行初始化，其next指向指定链表（可以理解为头插法的一种体现）
            res = new ListNode(cur.val,res);
        }

        // 返回结果
        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println("遍历前：");
        for(ListNode cur = head; cur != null; cur = cur.next) {
            System.out.println(cur.val);
        }
        // 遍历后
        System.out.println("遍历后：");
        ListNode res = new Solution1().reverseList(head);
        for(ListNode cur = res; cur != null; cur = cur.next) {
            System.out.println(cur.val);
        }
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


