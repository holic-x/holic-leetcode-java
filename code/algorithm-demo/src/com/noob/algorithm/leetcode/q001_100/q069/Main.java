package com.noob.algorithm.leetcode.q001_100.q069;


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
        caseList.add(4);
        caseList.add(8);
        caseList.add(125313515);

        return caseList;
    }

    public static void testSolution1() {
        // 参数初始化
        initCase();

        for (int x : caseList) {
            // ① 调用算法
            Solution1 solution = new Solution1();
            int res = solution.mySqrt(x);

            // ② 打印数据
            System.out.println(res);

            // 分隔符
            System.out.println("********************");

        }

    }


    public static void testSolution2() {
        // 参数初始化
        initCase();

        for (int x : caseList) {
            // ① 调用算法
            Solution1 solution = new Solution1();
            int res = solution.mySqrt(x);

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
