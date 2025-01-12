package com.noob.algorithm.leetcode.q001_100.q074;


import com.noob.algorithm.base.util.PrintListUtil;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<int[][]> caseList = new ArrayList<>();
    static List<Integer> targetList = new ArrayList<>();

    // 初始化测试用例
    public static void initCase() {

        // todo 补充测试用例集合
        caseList.add(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}});
        targetList.add(3);

        caseList.add(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}});
        targetList.add(13);


    }

    public static void testSolution1(List<int[][]> caseList, List<Integer> targetList) {

        for (int i = 0; i < caseList.size(); i++) {
            Solution1 solution = new Solution1();
            boolean res = solution.searchMatrix(caseList.get(i), targetList.get(i));
            System.out.println(res);
        }

    }


    public static void testSolution2(List<int[][]> caseList, List<Integer> targetList) {
        for (int i = 0; i < caseList.size(); i++) {
            Solution2 solution = new Solution2();
            boolean res = solution.searchMatrix(caseList.get(i), targetList.get(i));
            System.out.println(res);
        }

    }

    public static void testSolution3(List<int[][]> caseList, List<Integer> targetList) {
        for (int i = 0; i < caseList.size(); i++) {
            Solution3 solution = new Solution3();
            boolean res = solution.searchMatrix(caseList.get(i), targetList.get(i));
            System.out.println(res);
        }

    }


    public static void main(String[] args) {

        initCase();


        testSolution1(caseList, targetList);

        System.out.println("-------------------------------");

        testSolution2(caseList, targetList);

        System.out.println("-------------------------------");

        testSolution3(caseList, targetList);

    }
}
