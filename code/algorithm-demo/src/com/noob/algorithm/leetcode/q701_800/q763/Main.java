package com.noob.algorithm.leetcode.q701_800.q763;


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
        caseList.add("ababcbacadefegdehijhklij"); // [9,7,8]
        caseList.add("eccbbbbdec"); // [10]

        return caseList;
    }

    public static void testSolution1() {
        // 参数初始化
        initCase();

        for (String s : caseList) {
            // ① 调用算法
            Solution1 solution = new Solution1();
            List<Integer> res = solution.partitionLabels(s);

            // ② 打印数据
            PrintListUtil<Integer> printListUtil = new PrintListUtil<>();
            printListUtil.print(res);

            // 分隔符
            System.out.println("********************");

        }

    }


    public static void testSolution2() {

        // 参数初始化
        initCase();

        for (String s : caseList) {
            // ① 调用算法
            Solution2 solution = new Solution2();
            List<Integer> res = solution.partitionLabels(s);

            // ② 打印数据
            PrintListUtil<Integer> printListUtil = new PrintListUtil<>();
            printListUtil.print(res);

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
