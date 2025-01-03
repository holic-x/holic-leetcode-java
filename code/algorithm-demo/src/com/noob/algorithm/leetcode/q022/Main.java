package com.noob.algorithm.leetcode.q022;

import com.noob.algorithm.base.util.PrintUtil;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // 初始化测试用例
    public static List<Integer> initCase() {
        List<Integer> caseList = new ArrayList<>();
        caseList.add(3);
        caseList.add(1);
        return caseList;
    }

    public static void testSolution1(List<Integer> caseList) {
        Solution1 solution = new Solution1();
        for (int n : caseList) {
            List<String> res = solution.generateParenthesis(n);
            PrintUtil.print(res);
        }
    }

    public static void testSolution2(List<Integer> caseList) {
        Solution2 solution = new Solution2();
        for (int n : caseList) {
            List<String> res = solution.generateParenthesis(n);
            PrintUtil.print(res);
        }
    }


    public static void main(String[] args) {
        List<Integer> caseList = initCase();

        testSolution1(caseList);

        System.out.println("-------------------------------");

        testSolution2(caseList);

    }
}
