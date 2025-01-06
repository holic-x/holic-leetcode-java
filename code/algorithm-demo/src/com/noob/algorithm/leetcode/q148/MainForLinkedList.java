package com.noob.algorithm.leetcode.q148;


import com.noob.algorithm.base.dataStructure.linkedList.ListNode;
import com.noob.algorithm.base.util.LinkedListUtil;
import com.noob.algorithm.leetcode.q279.Solution;

import java.util.ArrayList;
import java.util.List;

public class MainForLinkedList {

    // 初始化测试用例
    public static List<int[]> initCase() {
        List<int[]> caseList = new ArrayList<>();

        // todo 补充测试用例集合
        caseList.add(new int[]{4, 2, 1, 3});
        caseList.add(new int[]{-1, 5, 3, 4, 0});
        caseList.add(new int[]{});

        return caseList;
    }

    public static void testSolution1(List<int[]> caseList) {

        for (int[] nums : caseList) {
            // 基于数组元素构建链表
            ListNode head = LinkedListUtil.createLink(nums);

            // ① 调用算法
            Solution1 solution = new Solution1();
            ListNode res = solution.sortList(head);

            // ② 打印数据
            LinkedListUtil.printLink(res);

            // 分隔符
            System.out.println("********************");

        }

    }


    public static void testSolution2(List<int[]> caseList) {

    }


    public static void main(String[] args) {

        // 参数初始化
        List<int[]> caseList = initCase();

        System.out.println("---------- 算法①调用测试 ----------");

        testSolution1(caseList);

        System.out.println("---------- 算法②调用测试 ----------");

        testSolution2(caseList);

    }
}
