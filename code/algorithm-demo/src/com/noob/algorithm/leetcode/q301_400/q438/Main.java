package com.noob.algorithm.leetcode.q301_400.q438;


import com.noob.algorithm.base.util.PrintListUtil;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<int[]> caseList = new ArrayList<>();

    // 初始化测试用例
    public static List<int[]> initCase() {
        // 初始化测试用例集合
        caseList = new ArrayList<>();

        // todo 补充测试用例集合
        caseList.add(new int[]{1, 2, 3});

        return caseList;
    }

    public static void testSolution1() {
        // 参数初始化
        initCase();

        for (int[] nums : caseList) {
            // ① 调用算法

            // ② 打印数据
            PrintListUtil<String> printListUtil = new PrintListUtil<>();
            // printListUtil.printMatrix(res);


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
