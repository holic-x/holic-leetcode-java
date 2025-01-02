package com.noob.algorithm.leetcode.q019;

import com.noob.algorithm.base.dataStructure.linkedList.ListNode;
import com.noob.algorithm.base.util.LinkedListUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Main {

    // 初始化测试用例
    public static List<int[]> initCase() {
        List<int[]> caseList = new ArrayList<>();
        caseList.add(new int[]{1, 2, 3, 4, 5});
        caseList.add(new int[]{1});
        caseList.add(new int[]{1, 2});
        return caseList;
    }

    public static void testSolution1(List<int[]> caseList, List<Integer> nList) {
        Solution1 solution1 = new Solution1();
        for (int i = 0; i < caseList.size(); i++) {
            ListNode head = LinkedListUtil.createLink(caseList.get(i)); // 构建链表
            ListNode res = solution1.removeNthFromEnd(head, nList.get(i)); // 调用算法
            LinkedListUtil.printLink(res); // 打印执行结果
        }
    }


    public static void testSolution2(List<int[]> caseList, List<Integer> nList) {
        Solution2 solution = new Solution2();
        for (int i = 0; i < caseList.size(); i++) {
            ListNode head = LinkedListUtil.createLink(caseList.get(i)); // 构建链表
            ListNode res = solution.removeNthFromEnd(head, nList.get(i)); // 调用算法
            LinkedListUtil.printLink(res); // 打印执行结果
        }
    }

    public static void main(String[] args) {
        List<int[]> caseList = initCase();
        List<Integer> nList = Arrays.stream(new int[]{2, 1, 1}).boxed().collect(Collectors.toList());

        testSolution1(caseList, nList);

        System.out.println("----------------------------------------------");

        testSolution2(caseList, nList);
    }

    public void testSolutionDefault() {
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

}
