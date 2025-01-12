package com.noob.algorithm.leetcode.q101_200.q121;


import com.noob.algorithm.leetcode.q101_200.q122.Solution1;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // 初始化测试用例
    public static List<int[]> initCase() {
        List<int[]> caseList = new ArrayList<>();

        // todo 补充测试用例集合
        caseList.add(new int[]{7, 1, 5, 3, 6, 4});
        caseList.add(new int[]{7, 6, 4, 3, 1});

        return caseList;
    }

    public static void testSolution1(List<int[]> caseList) {

        for (int[] prices : caseList) {
            // ① 调用算法
            Solution1 solution = new Solution1();
            int res = solution.maxProfit(prices);

            // ② 打印数据
            System.out.println(res);

            // 分隔符
            System.out.println("********************");

        }

    }


    public static void testSolution2(List<int[]> caseList) {

        for (int[] prices : caseList) {
            // ① 调用算法
            Solution2 solution = new Solution2();
            int res = solution.maxProfit(prices);

            // ② 打印数据
            System.out.println(res);

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

    }
}
