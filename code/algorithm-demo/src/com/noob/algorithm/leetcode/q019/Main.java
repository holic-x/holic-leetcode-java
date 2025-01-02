package com.noob.algorithm.leetcode.q019;

import com.noob.algorithm.base.dataStructure.linkedList.ListNode;
import com.noob.algorithm.base.util.LinkedListUtil;


public class Main {

    public static void testCase1() {
        int[] nums1 = new int[]{1, 2, 3, 4, 5};
        int[] nums2 = new int[]{1};
        int[] nums3 = new int[]{1, 2};

        Solution1 solution1 = new Solution1();
        ListNode head1 = LinkedListUtil.createLink(nums1);
        ListNode head2 = LinkedListUtil.createLink(nums2);
        ListNode head3 = LinkedListUtil.createLink(nums3);

        ListNode res21 = solution1.removeNthFromEnd(head1, 2);
        ListNode res22 = solution1.removeNthFromEnd(head2, 1);
        ListNode res23 = solution1.removeNthFromEnd(head3, 1);
        LinkedListUtil.printLink(res21);
        LinkedListUtil.printLink(res22);
        LinkedListUtil.printLink(res23);

    }


    public static void testCase2() {

        int[] nums1 = new int[]{1, 2, 3, 4, 5};
        int[] nums2 = new int[]{1};
        int[] nums3 = new int[]{1, 2};

        Solution2 solution2 = new Solution2();
        ListNode head1 = LinkedListUtil.createLink(nums1);
        ListNode head2 = LinkedListUtil.createLink(nums2);
        ListNode head3 = LinkedListUtil.createLink(nums3);

        ListNode res21 = solution2.removeNthFromEnd(head1, 2);
        ListNode res22 = solution2.removeNthFromEnd(head2, 1);
        ListNode res23 = solution2.removeNthFromEnd(head3, 1);
        LinkedListUtil.printLink(res21);
        LinkedListUtil.printLink(res22);
        LinkedListUtil.printLink(res23);

    }

    public void testCase01() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        Solution2 solution2 = new Solution2();
        ListNode result = solution2.removeNthFromEnd(head, 2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next; // 指针后移
        }
    }


    public static void main(String[] args) {

        testCase1();

        System.out.println("----------------------------------------------");

        testCase2();
    }

}
