package com.noob.algorithm.leetcode.q201_300.q238;


import com.noob.algorithm.base.util.PrintUtil;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // 初始化测试用例
    public static List<int[]> initCase() {
        List<int[]> caseList = new ArrayList<>();

        // todo 补充测试用例集合
        caseList.add(new int[]{1, 2, 3, 4});
        caseList.add(new int[]{-1, 1, 0, -3, 3});

        return caseList;
    }

    public static void testSolution1(List<int[]> caseList) {

        for (int[] nums : caseList) {
            // ① 调用算法
            Solution1 solution = new Solution1();
            int[] res = solution.productExceptSelf(nums);

            // ② 打印数据
            PrintUtil.print(res);

            // 分隔符
            System.out.println("********************");

        }

    }

    public static void testSolution2(List<int[]> caseList) {

        for (int[] nums : caseList) {
            // ① 调用算法
            Solution2 solution = new Solution2();
            int[] res = solution.productExceptSelf(nums);

            // ② 打印数据
            PrintUtil.print(res);

            // 分隔符
            System.out.println("********************");

        }

    }

    public static void testSolution3(List<int[]> caseList) {

        for (int[] nums : caseList) {
            // ① 调用算法
            Solution3 solution = new Solution3();
            int[] res = solution.productExceptSelf(nums);

            // ② 打印数据
            PrintUtil.print(res);

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

        System.out.println("---------- 算法②调用测试 ----------");

        testSolution3(caseList);

    }
}
