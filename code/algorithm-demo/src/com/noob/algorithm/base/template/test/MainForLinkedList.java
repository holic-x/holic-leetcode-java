package com.noob.algorithm.base.template.test;


import com.noob.algorithm.base.dataStructure.linkedList.ListNode;
import com.noob.algorithm.base.util.LinkedListUtil;
import com.noob.algorithm.base.util.PrintListUtil;

import java.util.ArrayList;
import java.util.List;

public class MainForLinkedList {

    // 初始化测试用例
    public static List<int[]> initCase() {
        List<int[]> caseList = new ArrayList<>();

        // todo 补充测试用例集合
        caseList.add(new int[]{1, 2, 3});

        return caseList;
    }

    public static void testSolution1(List<int[]> caseList) {

        for (int[] nums : caseList) {
            // 基于数组元素构建链表
            ListNode head = LinkedListUtil.createLink(nums);

            // ① 调用算法


            // ② 打印数据
            // LinkedListUtil.printLink(head);

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
