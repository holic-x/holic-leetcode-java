package com.noob.algorithm.leetcode.q401_500.q406;


import com.noob.algorithm.base.util.PrintUtil;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<int[][]> caseList = new ArrayList<>();

    // 初始化测试用例
    public static List<int[][]> initCase() {
        // 初始化测试用例集合
        caseList = new ArrayList<>();

        // todo 补充测试用例集合
        caseList.add(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
        caseList.add(new int[][]{{6, 0}, {5, 0}, {4, 0}, {3, 2}, {2, 2}, {1, 4}});

        return caseList;
    }

    public static void testSolution1() {
        // 参数初始化
        initCase();

        for (int[][] people : caseList) {
            // ① 调用算法
            Solution1 solution = new Solution1();
            int[][] res = solution.reconstructQueue(people);

            // ② 打印数据
            PrintUtil.printMatrix(res);

            // 分隔符
            System.out.println("********************");

        }

    }


    public static void testSolution2() {

    }


    public static void main(String[] args) {

        System.out.println("---------- 算法①调用测试 ----------");

        testSolution1();

        System.out.println("---------- 算法②调用测试 ----------");

        testSolution2();

    }
}
