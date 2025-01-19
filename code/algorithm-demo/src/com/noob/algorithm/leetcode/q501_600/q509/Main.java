package com.noob.algorithm.leetcode.q501_600.q509;


import com.noob.algorithm.base.util.PrintListUtil;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Integer> caseList = new ArrayList<>();

    // 初始化测试用例
    public static List<Integer> initCase() {
        // 初始化测试用例集合
        caseList = new ArrayList<>();

        // todo 补充测试用例集合
        caseList.add(0); // 0
        caseList.add(1); // 1
        caseList.add(2); // 1
        caseList.add(3); // 2
        caseList.add(4); // 3
        caseList.add(10); // 55

        return caseList;
    }

    public static void testSolution1() {
        // 参数初始化
        initCase();

        for (int n : caseList) {
            // ① 调用算法
            Solution1 solution = new Solution1();
            int res = solution.fib(n);

            // ② 打印数据
            System.out.println(res);

            // 分隔符
            System.out.println("********************");

        }

    }


    public static void testSolution2() {
        // 参数初始化
        initCase();

        for (int n : caseList) {
            // ① 调用算法
            Solution2 solution = new Solution2();
            int res = solution.fib(n);

            // ② 打印数据
            System.out.println(res);

            // 分隔符
            System.out.println("********************");

        }
    }


    public static void main(String[] args) {

        System.out.println("---------- 算法①调用测试 ----------");

        testSolution1();

        System.out.println("---------- 算法②调用测试 ----------");

        testSolution2();

    }
}
