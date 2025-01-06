package com.noob.algorithm.leetcode.q118;


import com.noob.algorithm.base.util.PrintListUtil;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // 初始化测试用例
    public static List<Integer> initCase() {
        List<Integer> caseList = new ArrayList<>();

        // todo 补充测试用例集合
        caseList.add(5);
        caseList.add(1);

        return caseList;
    }

    public static void testSolution1(List<Integer> caseList) {

        for (int n : caseList) {
            // ① 调用算法
            Solution1 solution = new Solution1();
            List<List<Integer>> res = solution.generate(n);

            // ② 打印数据
            PrintListUtil<Integer> printListUtil = new PrintListUtil<>();
            printListUtil.printMatrix(res);

            // 分隔符
            System.out.println("********************");

        }

    }


    public static void testSolution2(List<Integer> caseList) {

        for (int n : caseList) {
            // ① 调用算法
            Solution2 solution = new Solution2();
            List<List<Integer>> res = solution.generate(n);

            // ② 打印数据
            PrintListUtil<Integer> printListUtil = new PrintListUtil<>();
            printListUtil.printMatrix(res);

            // 分隔符
            System.out.println("********************");

        }

    }


    public static void main(String[] args) {

        // 参数初始化
        List<Integer> caseList = initCase();

        System.out.println("---------- 算法①调用测试 ----------");

        testSolution1(caseList);

        System.out.println("---------- 算法②调用测试 ----------");

        testSolution2(caseList);

    }
}
