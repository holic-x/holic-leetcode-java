package com.noob.algorithm.leetcode.q002;

import com.noob.algorithm.base.dataStructure.linkedList.ListNode;
import com.noob.algorithm.base.util.LinkedListUtil;

public class Main {

    public static void main(String[] args) {

        // 构建测试用例
        /*
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(4);
        node4.next = node5;
        node5.next = node6;
         */

        ListNode head1 = LinkedListUtil.createLink(new int[]{2,4,3});
        ListNode head2 = LinkedListUtil.createLink(new int[]{5,6,4});

        Solution1 solution1 = new Solution1();
        ListNode res1 = solution1.addTwoNumbers(head1,head2);
        LinkedListUtil.printLink(res1);

        System.out.println("------------------------------------------");
        Solution2 solution2 = new Solution2();
        ListNode res2 = solution2.addTwoNumbers(head1,head2);
        LinkedListUtil.printLink(res2);
    }


}
