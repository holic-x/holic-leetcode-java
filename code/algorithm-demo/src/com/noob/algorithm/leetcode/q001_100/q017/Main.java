package com.noob.algorithm.leetcode.q001_100.q017;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // 初始化测试用例
    public static List<String> initCase() {
        List<String> caseList = new ArrayList<>();
        caseList.add("23");
        caseList.add("");
        caseList.add("2");
        return caseList;
    }

    public static void testSolution1(List<String> caseList) {
        Solution1 solution1 = new Solution1();
        for (String digits : caseList) {
            System.out.println(solution1.letterCombinations(digits));
        }
    }

    public static void testSolution2(List<String> caseList) {
        Solution2 solution2 = new Solution2();
        for (String digits : caseList) {
            System.out.println(solution2.letterCombinations(digits));
        }
    }

    public static void main(String[] args) {
        List<String> caseList = initCase();

        testSolution1(caseList);
        System.out.println("-----------------------------------------------");
        testSolution1(caseList);
    }

}
