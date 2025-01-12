package com.noob.algorithm.leetcode.q001_100.q054;


import com.noob.algorithm.base.util.PrintListUtil;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // 初始化测试用例
    public static List<int[][]> initCase() {
        List<int[][]> caseList = new ArrayList<>();

        // todo 补充测试用例集合
        caseList.add(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        caseList.add(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});

        return caseList;
    }

    public static void testSolution1(List<int[][]> caseList) {

        Solution1 solution = new Solution1();

        for (int[][] matrix : caseList) {
            List<Integer> res = solution.spiralOrder(matrix);

            // 打印数据
            PrintListUtil<Integer> printListUtil = new PrintListUtil<>();
            printListUtil.print(res);

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
