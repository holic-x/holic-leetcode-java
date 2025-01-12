package com.noob.algorithm.leetcode.q001_100.q075;


import com.noob.algorithm.base.util.PrintUtil;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // 初始化测试用例
    public static List<int[]> initCase() {
        List<int[]> caseList = new ArrayList<>();

        // todo 补充测试用例集合
        caseList.add(new int[]{2,0,2,1,1,0});
        caseList.add(new int[]{2,0,1});

        return caseList;
    }

    public static void testSolution1(List<int[]> caseList) {

        for (int[] nums : caseList) {
            Solution1 solution = new Solution1();
            solution.sortColors(nums);
            // 打印数据
            PrintUtil printUtil = new PrintUtil();
            printUtil.print(nums);
            System.out.println("********************");
        }

    }


    public static void testSolution2(List<int[]> caseList) {

        for (int[] nums : caseList) {
            Solution1 solution = new Solution1();
            solution.sortColors(nums);
            // 打印数据
            PrintUtil printUtil = new PrintUtil();
            printUtil.print(nums);
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
