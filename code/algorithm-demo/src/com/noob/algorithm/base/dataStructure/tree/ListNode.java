package com.noob.algorithm.base.dataStructure.tree;

/**
 * 链表节点定义
 */
public class ListNode {
    public int val; // 节点值
    public ListNode next; // next 节点

    // 构造方法（无参构造器）
    public ListNode() {
    }

    // 构造方法（初始化节点值）
    public ListNode(int val) {
        this.val = val;
    }

    // 构造方法（初始化节点值和next指针，头插概念）
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}