package com.noob.algorithm.leetcode.q701_800.q739;


import com.noob.algorithm.base.util.PrintListUtil;
import com.noob.algorithm.base.util.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static List<int[]> caseList = new ArrayList<>();

    // 初始化测试用例
    public static List<int[]> initCase() {
        // 初始化测试用例集合
        caseList = new ArrayList<>();

        // todo 补充测试用例集合
        caseList.add(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        caseList.add(new int[]{30, 40, 50, 60});
        caseList.add(new int[]{30, 60, 90});

        return caseList;
    }

    public static void testSolution1() {
        // 参数初始化
        initCase();

        for (int[] nums : caseList) {
            // ① 调用算法
            Solution1 solution = new Solution1();
            int[] res = solution.dailyTemperatures(nums);

            // ② 打印数据
            System.out.println(Arrays.toString(res));

            // 分隔符
            System.out.println("********************");

        }

    }


    public static void testSolution2() {
        // 参数初始化
        initCase();

        for (int[] nums : caseList) {
            // ① 调用算法
            Solution2 solution = new Solution2();
            int[] res = solution.dailyTemperatures(nums);

            // ② 打印数据
            System.out.println(Arrays.toString(res));

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
