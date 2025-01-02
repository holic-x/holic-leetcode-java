package com.noob.algorithm.leetcode.q031;

import com.noob.algorithm.base.util.PrintUtil;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // 初始化测试用例
    public static List<int[]> initCase() {
        List<int[]> caseList = new ArrayList<>();

        // todo 补充测试用例集合
        caseList.add(new int[]{1, 2, 3});
        caseList.add(new int[]{3, 2, 1});
        caseList.add(new int[]{1, 1, 5});

        return caseList;
    }

    public static void testSolution1(List<int[]> caseList) {
        Solution1 solution = new Solution1();
        for (int[] nums : caseList) {
            solution.nextPermutation(nums);
            PrintUtil.print(nums); // 输出原地修改后的内容
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
