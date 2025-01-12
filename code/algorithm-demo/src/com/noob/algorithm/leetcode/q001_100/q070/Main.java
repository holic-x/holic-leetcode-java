package com.noob.algorithm.leetcode.q001_100.q070;


import com.noob.algorithm.base.util.PrintListUtil;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // 初始化测试用例
    public static List<Integer> initCase() {
        List<Integer> caseList = new ArrayList<>();

        // todo 补充测试用例集合
        caseList.add(1);
        caseList.add(2);
        caseList.add(3);

        return caseList;
    }

    public static void testSolution1(List<Integer> caseList) {

        Solution1 solution = new Solution1();
        for (int n : caseList) {
            int res = solution.climbStairs(n);
            System.out.println(res);
        }

    }


    public static void testSolution2(List<Integer> caseList) {

        Solution2 solution = new Solution2();
        for (int n : caseList) {
            int res = solution.climbStairs(n);
            System.out.println(res);
        }

    }

    public static void testSolution3(List<Integer> caseList) {

        Solution3 solution = new Solution3();
        for (int n : caseList) {
            int res = solution.climbStairs(n);
            System.out.println(res);
        }

    }


    public static void main(String[] args) {
        List<Integer> caseList = initCase();

        testSolution1(caseList);

        System.out.println("-------------------------------");

        testSolution2(caseList);

        System.out.println("-------------------------------");

        testSolution3(caseList);

    }
}
