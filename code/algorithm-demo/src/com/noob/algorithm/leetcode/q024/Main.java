package com.noob.algorithm.leetcode.q024;

import com.noob.algorithm.base.dataStructure.linkedList.ListNode;
import com.noob.algorithm.base.util.LinkedListUtil;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // 初始化测试用例
    public static List<int[]> initCase() {
        List<int[]> caseList = new ArrayList<>();
        caseList.add(new int[]{1, 2, 3, 4});
        caseList.add(new int[]{});
        caseList.add(new int[]{1});
        caseList.add(new int[]{1, 2, 3});
        return caseList;
    }

    public static void testSolution1(List<int[]> caseList) {
        Solution1 solution = new Solution1();
        for (int[] nums : caseList) {
            // 构建链表
            ListNode head = LinkedListUtil.createLink(nums);
            // 调用算法
            ListNode res = solution.swapPairs(head);
            // 打印结果
            LinkedListUtil.printLink(res);
        }
    }


    public static void testSolution2(List<int[]> caseList) {

    }


    public static void main(String[] args) {
        List<int[]> caseList = initCase();

        testSolution1(caseList);

        System.out.println("-------------------------------");

        testSolution2(caseList);

    }
}
