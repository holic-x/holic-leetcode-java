package com.noob.algorithm.leetcode.q19;

/**
 * 2-删除倒数第N个节点（链表）
 * 思路1：两次链表遍历，第1次获取链表长度，第2次在对应L-n+1做删除操作（即让当前节点的next指向下下个节点）
 * 需要注意的是，不需要设定为将节点加入新链表，主要是定位到那个要删除的节点的前一个节点prev，然后设置`prev.next=prev.next.next`
 */
public class Solution1 {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        // 定义链表(初始化为原链表)
        ListNode res = new ListNode(0, head);

        // 定义链表指针
        ListNode cur = res;

        // 1.获取链表长度（注意不要用同一个指针）
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }

        // 2.遍历链表,删除第L-N+1个节点(去掉链表初始节点)
        for (int i = 1; i < len - n + 1; i++) {
            cur = cur.next; // 指针移动
        }
        // 当前指针移动向下下个节点（表示删除下个节点）
        cur.next = cur.next.next;
        return res.next;
    }
}


/**
 * 链表节点定义
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}