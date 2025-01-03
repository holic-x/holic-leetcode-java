package com.noob.algorithm.leetcode.q045;


import java.util.ArrayList;
import java.util.List;

public class Main {

    // 初始化测试用例
    public static List<int[]> initCase() {
        List<int[]> caseList = new ArrayList<>();

        // todo 补充测试用例集合
        caseList.add(new int[]{2, 3, 1, 1, 4});
        caseList.add(new int[]{2, 3, 0, 1, 4});

        return caseList;
    }

    public static void testSolution1(List<int[]> caseList) {

        for (int[] nums : caseList) {
            Solution1 solution = new Solution1();
            int res = solution.jump(nums);
            System.out.println(res);
        }

    }


    public static void testSolution2(List<int[]> caseList) {

        for (int[] nums : caseList) {
            Solution2 solution = new Solution2();
            int res = solution.jump(nums);
            System.out.println(res);
        }

    }


    public static void main(String[] args) {
        List<int[]> caseList = initCase();

        testSolution1(caseList);

        System.out.println("-------------------------------");

        testSolution2(caseList);

    }
}
