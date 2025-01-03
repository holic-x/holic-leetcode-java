package com.noob.algorithm.leetcode.q046;


import com.noob.algorithm.base.util.PrintUtil;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // 初始化测试用例
    public static List<int[]> initCase() {
        List<int[]> caseList = new ArrayList<>();

        // todo 补充测试用例集合
        caseList.add(new int[]{1, 2, 3});
        caseList.add(new int[]{0, 1});
        caseList.add(new int[]{1});

        return caseList;
    }

    public static void testSolution1(List<int[]> caseList) {

        for (int[] nums : caseList) {
            Solution1 solution = new Solution1();
            List<List<Integer>> res = solution.permute(nums);
            PrintUtil.printMatrix(res);
        }

    }


    public static void testSolution2(List<int[]> caseList) {

    }


    public static void main(String[] args) {
        List<int[]> caseList = initCase();

        testSolution1(caseList);

        System.out.println("-------------------------------");

        testSolution2(caseList);

    }
}
