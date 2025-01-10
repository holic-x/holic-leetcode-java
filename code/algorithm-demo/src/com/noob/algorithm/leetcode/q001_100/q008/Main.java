package com.noob.algorithm.leetcode.q001_100.q008;


import com.noob.algorithm.base.util.PrintListUtil;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<String> caseList = new ArrayList<>();

    // 初始化测试用例
    public static List<String> initCase() {
        // 初始化测试用例集合
        caseList = new ArrayList<>();

        // todo 补充测试用例集合
        caseList.add("");
        caseList.add("     ");
        caseList.add("42");
        caseList.add("   -042");
        caseList.add("1337c0d3");
        caseList.add("0-1");
        caseList.add("words and 987");
        caseList.add("   -42  hi");

        return caseList;
    }

    public static void testSolution1() {
        // 参数初始化
        initCase();

        for (String str : caseList) {
            // ① 调用算法
            Solution1 solution = new Solution1();
            int res = solution.myAtoi(str);

            // ② 打印数据
            System.out.println(res);

            // 分隔符
            System.out.println("********************");

        }

    }


    public static void testSolution2() {
        // 参数初始化
        initCase();

        for (String str : caseList) {
            // ① 调用算法
            Solution1 solution = new Solution1();
            int res = solution.myAtoi(str);

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
