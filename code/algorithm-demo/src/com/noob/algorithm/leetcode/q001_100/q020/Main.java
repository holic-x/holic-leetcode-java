package com.noob.algorithm.leetcode.q001_100.q020;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // 初始化测试用例集合
    public static List<String> initCase() {
        List<String> caseList = new ArrayList<>();
        caseList.add("()");
        caseList.add("()[]{}");
        caseList.add("(]");
        caseList.add("([])");
        caseList.add("");
        return caseList;
    }

    public static void testSolution1(List<String> strList) {
        Solution1 solution1 = new Solution1();
        for (String str : strList) {
            System.out.println(solution1.isValid(str));
        }
    }

    public static void testSolution2(List<String> strList) {
        Solution2 solution2 = new Solution2();
        for (String str : strList) {
            System.out.println(solution2.isValid(str));
        }
    }

    public static void main(String[] args) {
        List<String> caseList = initCase();

        testSolution1(caseList);

        System.out.println("-------------------------------");

        testSolution2(caseList);
    }

}
