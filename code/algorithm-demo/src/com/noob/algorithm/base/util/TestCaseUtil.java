package com.noob.algorithm.base.util;

import com.noob.algorithm.base.dataStructure.linkedList.ListNode;
import com.noob.algorithm.leetcode.q019.Solution1;

import java.util.ArrayList;
import java.util.List;

public class TestCaseUtil {

    public static void testCase1(List<int[]> cases, List<Integer> nList) {
        List<ListNode> headList = new ArrayList<>();
        for(int i=0;i<cases.size();i++){
            ListNode head = LinkedListUtil.createLink(cases.get(i));
            headList.add(head);
        }

        Solution1 solution1 = new Solution1();
        System.out.println("测试结果：");
        /*
        for(int i=0;i<cases.size();i++){
            ListNode res = solution1.removeNthFromEnd(cases.get(i),2);
        }
        ListNode res11 = solution1.removeNthFromEnd(head1, 2);
        ListNode res12 = solution1.removeNthFromEnd(head2, 1);
        ListNode res13 = solution1.removeNthFromEnd(head3, 1);
        LinkedListUtil.printLink(res11);
        LinkedListUtil.printLink(res12);
        LinkedListUtil.printLink(res13);
         */

    }


}
