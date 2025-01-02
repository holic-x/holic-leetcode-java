package com.noob.algorithm.leetcode.q021;

import com.noob.algorithm.base.dataStructure.linkedList.ListNode;
import com.noob.algorithm.base.util.LinkedListUtil;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // 初始化测试用例
    public static List<List<int[]>> initCase() {
        List<List<int[]>> caseList = new ArrayList<>();
        List<int[]> case1 = new ArrayList<>();
        case1.add(new int[]{1, 2, 4});
        case1.add(new int[]{1, 3, 4});
        caseList.add(case1);

        return caseList;
    }

    public static void testSolution1(List<List<int[]>> caseList) {
        Solution1 solution1 = new Solution1();
        for (List<int[]> tempCase : caseList) {
            // 构建链表
            ListNode head1 = LinkedListUtil.createLink(tempCase.get(0));
            ListNode head2 = LinkedListUtil.createLink(tempCase.get(1));
            ListNode res = solution1.mergeTwoLists(head1, head2);
            // 打印结果
            LinkedListUtil.printLink(res);
        }
    }


    public static void testSolution2(List<List<int[]>> caseList) {

    }


    public static void main(String[] args) {
        List<List<int[]>> caseList = initCase();

        testSolution1(caseList);

        System.out.println("-------------------------------");

        testSolution2(caseList);

    }
}
