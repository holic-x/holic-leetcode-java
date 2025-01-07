package com.noob.algorithm.leetcode.q101_200.q131;


import com.noob.algorithm.base.util.PrintListUtil;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // 初始化测试用例
    public static List<String> initCase() {
        List<String> caseList = new ArrayList<>();

        // todo 补充测试用例集合
        caseList.add("aab");
        caseList.add("a");

        return caseList;
    }

    public static void testSolution1(List<String> caseList) {

        for (String str : caseList) {
            // ① 调用算法
            Solution1 solution = new Solution1();
            List<List<String>> res = solution.partition(str);

            // ② 打印数据
            PrintListUtil<String> printListUtil = new PrintListUtil<>();
            printListUtil.printMatrix(res);

            // 分隔符
            System.out.println("********************");

        }

    }


    public static void testSolution2(List<String> caseList) {

    }


    public static void main(String[] args) {

        // 参数初始化
        List<String> caseList = initCase();

        System.out.println("---------- 算法①调用测试 ----------");

        testSolution1(caseList);

        System.out.println("---------- 算法②调用测试 ----------");

        testSolution2(caseList);

    }
}
