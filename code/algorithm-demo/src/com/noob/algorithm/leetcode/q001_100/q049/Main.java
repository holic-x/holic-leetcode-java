package com.noob.algorithm.leetcode.q001_100.q049;


import com.noob.algorithm.base.util.PrintListUtil;
import com.noob.algorithm.base.util.PrintUtil;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // 初始化测试用例
    public static List<String[]> initCase() {
        List<String[]> caseList = new ArrayList<>();

        // todo 补充测试用例集合
        caseList.add(new String[]{"abc", "cbb", "acb"});

        return caseList;
    }

    public static void testSolution1(List<String[]> caseList) {

        for (String[] strs : caseList) {
            Solution1 solution = new Solution1();
            List<List<String>> res = solution.groupAnagrams(strs);
            // 打印数据
            PrintListUtil<String> printListUtil = new PrintListUtil<>();
            printListUtil.printMatrix(res);
        }

    }


    public static void testSolution2(List<String[]> caseList) {

    }


    public static void main(String[] args) {
        List<String[]> caseList = initCase();

        testSolution1(caseList);

        System.out.println("-------------------------------");

        testSolution2(caseList);

    }
}
