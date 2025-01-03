package com.noob.algorithm.base.template;


import com.noob.algorithm.base.util.PrintListUtil;
import com.noob.algorithm.base.util.PrintUtil;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // 初始化测试用例
    public static List<int[]> initCase() {
        List<int[]> caseList = new ArrayList<>();

        // todo 补充测试用例集合
        caseList.add(new int[]{1, 2, 3});

        return caseList;
    }

    public static void testSolution1(List<int[]> caseList) {

        for (int[] nums : caseList) {

            // 打印数据
            PrintListUtil<String> printListUtil = new PrintListUtil<>();
            // printListUtil.printMatrix(res);
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
