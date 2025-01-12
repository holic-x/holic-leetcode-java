package com.noob.algorithm.leetcode.q001_100.q023;


import com.noob.algorithm.base.dataStructure.linkedList.ListNode;
import com.noob.algorithm.base.util.LinkedListUtil;

import java.util.ArrayList;
import java.util.List;

public class MainForLinkedList {

    // 初始化测试用例
    public static List<List<int[]>> initCase() {
        List<List<int[]>> caseList = new ArrayList<>();

        // todo 补充测试用例集合
        List<int[]> case1 = new ArrayList<>();
        case1.add(new int[]{1, 4, 5});
        case1.add(new int[]{1, 3, 4});
        case1.add(new int[]{2, 6});
        caseList.add(case1);


        return caseList;
    }

    public static void testSolution1(List<List<int[]>> caseList) {

        for (List<int[]> caseItem : caseList) {
            // 基于数组元素构建链表
            ListNode[] headArr = new ListNode[caseItem.size()];
            int idx = 0;
            for (int[] nums : caseItem) {
                headArr[idx++] = LinkedListUtil.createLink(nums);
            }

            // ① 调用算法
            Solution1 solution = new Solution1();
            ListNode res = solution.mergeKLists(headArr);

            // ② 打印数据
            LinkedListUtil.printLink(res);

            // 分隔符
            System.out.println("********************");

        }

    }


    public static void testSolution2(List<List<int[]>> caseList) {

        for (List<int[]> caseItem : caseList) {
            // 基于数组元素构建链表
            ListNode[] headArr = new ListNode[caseItem.size()];
            int idx = 0;
            for (int[] nums : caseItem) {
                headArr[idx++] = LinkedListUtil.createLink(nums);
            }

            // ① 调用算法
            Solution2 solution = new Solution2();
            ListNode res = solution.mergeKLists(headArr);

            // ② 打印数据
            LinkedListUtil.printLink(res);

            // 分隔符
            System.out.println("********************");

        }

    }


    public static void testSolution3(List<List<int[]>> caseList) {

        for (List<int[]> caseItem : caseList) {
            // 基于数组元素构建链表
            ListNode[] headArr = new ListNode[caseItem.size()];
            int idx = 0;
            for (int[] nums : caseItem) {
                headArr[idx++] = LinkedListUtil.createLink(nums);
            }

            // ① 调用算法
            Solution3 solution = new Solution3();
            ListNode res = solution.mergeKLists(headArr);

            // ② 打印数据
            LinkedListUtil.printLink(res);

            // 分隔符
            System.out.println("********************");

        }

    }


    public static void main(String[] args) {

        // 参数初始化
        List<List<int[]>> caseList = initCase();

        System.out.println("---------- 算法①调用测试 ----------");

        testSolution1(caseList);

        System.out.println("---------- 算法②调用测试 ----------");

        testSolution2(caseList);

        System.out.println("---------- 算法③调用测试 ----------");

        testSolution3(caseList);

    }
}
