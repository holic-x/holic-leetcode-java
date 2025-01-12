package com.noob.algorithm.leetcode.q001_100.q073;


import com.noob.algorithm.base.util.PrintListUtil;
import com.noob.algorithm.base.util.PrintUtil;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // 初始化测试用例
    public static List<int[][]> initCase() {
        List<int[][]> caseList = new ArrayList<>();

        // todo 补充测试用例集合
        caseList.add(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}});
        caseList.add(new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}});

        return caseList;
    }

    public static void testSolution1(List<int[][]> caseList) {

        for (int[][] matrix : caseList) {
            Solution1 solution = new Solution1();
            solution.setZeroes(matrix);

            // 打印数据
            PrintUtil printUtil = new PrintUtil();
            printUtil.printMatrix(matrix);
            System.out.println("********************");
        }

    }


    public static void testSolution2(List<int[][]> caseList) {

    }


    public static void main(String[] args) {
        List<int[][]> caseList = initCase();

        testSolution1(caseList);

        System.out.println("-------------------------------");

        testSolution2(caseList);

    }
}
