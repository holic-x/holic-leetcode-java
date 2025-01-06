package com.noob.algorithm.leetcode.q053;


import java.util.ArrayList;
import java.util.List;

public class Main {

    // 初始化测试用例
    public static List<int[]> initCase() {
        List<int[]> caseList = new ArrayList<>();

        // todo 补充测试用例集合
        caseList.add(new int[]{1, 2, 3});
        caseList.add(new int[]{-1});
        caseList.add(new int[]{-1, -2});
        caseList.add(new int[]{1, 2});
        caseList.add(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        caseList.add(new int[]{5, 4, -1, 7, 8});

        return caseList;
    }

    public static void testSolution1(List<int[]> caseList) {

        Solution1 solution = new Solution1();
        for (int[] nums : caseList) {
            int res = solution.maxSubArray(nums);
            System.out.println(res);
        }

    }


    public static void testSolution2(List<int[]> caseList) {
        Solution2 solution = new Solution2();
        for (int[] nums : caseList) {
            int res = solution.maxSubArray(nums);
            System.out.println(res);
        }
    }

    public static void testSolution3(List<int[]> caseList) {
        Solution3 solution = new Solution3();
        for (int[] nums : caseList) {
            int res = solution.maxSubArray(nums);
            System.out.println(res);
        }
    }

    public static void main(String[] args) {
        List<int[]> caseList = initCase();

        testSolution1(caseList);

        System.out.println("-------------------------------");

        testSolution2(caseList);

        System.out.println("-------------------------------");

        testSolution3(caseList);

    }
}
