package com.noob.algorithm.leetcode.q300;


import java.util.ArrayList;
import java.util.List;

public class Main {

    // 初始化测试用例
    public static List<int[]> initCase() {
        List<int[]> caseList = new ArrayList<>();

        // todo 补充测试用例集合
        caseList.add(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
        caseList.add(new int[]{0, 1, 0, 3, 2, 3});
        caseList.add(new int[]{7, 7, 7, 7, 7, 7, 7});

        return caseList;
    }

    public static void testSolution1() {
        // 参数初始化
        List<int[]> caseList = initCase();

        for (int[] nums : caseList) {
            // ① 调用算法
            Solution1 solution = new Solution1();
            int res = solution.lengthOfLIS(nums);

            // ② 打印数据
            System.out.println(res);

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
