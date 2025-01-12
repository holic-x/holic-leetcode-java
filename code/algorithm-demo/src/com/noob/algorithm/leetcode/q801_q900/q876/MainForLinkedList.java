package com.noob.algorithm.leetcode.q801_q900.q876;


import com.noob.algorithm.base.dataStructure.linkedList.ListNode;
import com.noob.algorithm.base.util.LinkedListUtil;

import java.util.ArrayList;
import java.util.List;

public class MainForLinkedList {

    // 初始化测试用例
    public static List<int[]> initCase() {
        List<int[]> caseList = new ArrayList<>();

        // todo 补充测试用例集合
        caseList.add(new int[]{1, 2, 3, 4, 5}); // 奇数个元素的链表，返回中间节点3
        caseList.add(new int[]{1, 2, 3, 4, 5, 6}); // 偶数个元素的链表，返回第2个中间节点

        return caseList;
    }

    public static void testSolution1(List<int[]> caseList) {

        for (int[] nums : caseList) {
            // 基于数组元素构建链表
            ListNode head = LinkedListUtil.createLink(nums);

            // ① 调用算法
            Solution1 solution = new Solution1();
            ListNode res = solution.middleNode(head);

            // ② 打印数据
            System.out.println("当前中间结点：" + res.val);

            // 分隔符
            System.out.println("********************");

        }

    }


    public static void testSolution2(List<int[]> caseList) {
        for (int[] nums : caseList) {
            // 基于数组元素构建链表
            ListNode head = LinkedListUtil.createLink(nums);

            // ① 调用算法
            Solution2 solution = new Solution2();
            ListNode res = solution.middleNode(head);

            // ② 打印数据
            System.out.println("当前中间结点：" + res.val);

            // 分隔符
            System.out.println("********************");

        }
    }


    public static void testSolution3(List<int[]> caseList) {
        for (int[] nums : caseList) {
            // 基于数组元素构建链表
            ListNode head = LinkedListUtil.createLink(nums);

            // ① 调用算法
            Solution3 solution = new Solution3();
            ListNode res = solution.middleNode(head);

            // ② 打印数据
            System.out.println("当前中间结点：" + res.val);

            // 分隔符
            System.out.println("********************");

        }
    }


    public static void main(String[] args) {

        // 参数初始化
        List<int[]> caseList = initCase();

        System.out.println("---------- 算法①调用测试 ----------");

        testSolution1(caseList);

        System.out.println("---------- 算法②调用测试 ----------");

        testSolution2(caseList);

        System.out.println("---------- 算法③调用测试 ----------");

        testSolution3(caseList);

    }
}
