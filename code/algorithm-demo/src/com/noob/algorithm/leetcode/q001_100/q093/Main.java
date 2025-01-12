package com.noob.algorithm.leetcode.q001_100.q093;


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
        caseList.add("25525511135");
        caseList.add("0000");
        caseList.add("101023");

        return caseList;
    }

    public static void testSolution1() {
        // 参数初始化
        initCase();

        for (String s : caseList) {
            // ① 调用算法
            Solution1 solution = new Solution1();
            List<String> res = solution.restoreIpAddresses(s);

            // ② 打印数据
            PrintListUtil<String> printListUtil = new PrintListUtil<>();
            printListUtil.print(res);

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
