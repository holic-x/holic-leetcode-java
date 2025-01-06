package com.noob.algorithm.leetcode.q056;


import com.noob.algorithm.base.util.PrintArrUtil;
import com.noob.algorithm.base.util.PrintListUtil;
import com.noob.algorithm.base.util.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    // 初始化测试用例
    public static List<int[][]> initCase() {
        List<int[][]> caseList = new ArrayList<>();

        // todo 补充测试用例集合
        caseList.add(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        caseList.add(new int[][]{{1, 4}, {4, 5}});

        return caseList;
    }

    public static void testSolution1(List<int[][]> caseList) {

        Solution1 solution = new Solution1();
        for (int[][] intervals : caseList) {
            int[][] res = solution.merge(intervals);
            // 打印数据
            PrintUtil printUtil = new PrintUtil();
            printUtil.printMatrix(res);
            System.out.println("******************");
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
