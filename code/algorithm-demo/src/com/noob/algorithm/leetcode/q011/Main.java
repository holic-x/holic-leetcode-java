package com.noob.algorithm.leetcode.q011;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // 初始化测试用例
    public static List<int[]> initCase() {
        List<int[]> caseList = new ArrayList<>();
        caseList.add(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        caseList.add(new int[]{1, 1});
        return caseList;
    }

    public static void testSolution1(List<int[]> caseList) {
        Solution1 s = new Solution1();
        for (int[] height : caseList) {
            System.out.println(s.maxArea(height));
        }
    }


    public static void testSolution2() {

    }


    public static void main(String[] args) {
        List<int[]> caseList = initCase();

        testSolution1(caseList);

        System.out.println("----------------------------");
    }
}
