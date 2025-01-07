package com.noob.algorithm.leetcode.q283;


import com.noob.algorithm.base.util.PrintListUtil;
import com.noob.algorithm.base.util.PrintUtil;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // 初始化测试用例
    public static List<int[]> initCase() {
        List<int[]> caseList = new ArrayList<>();

        // todo 补充测试用例集合
        caseList.add(new int[]{0, 1, 0, 3, 12}); // [1]-[3]-[12]-[0]-[0]
        caseList.add(new int[]{0}); // [0]

        return caseList;
    }

    public static void testSolution1(List<int[]> caseList) {

        for (int[] nums : caseList) {
            // ① 调用算法
            Solution1 solution = new Solution1();
            solution.moveZeroes(nums);


            // ② 打印数据
            PrintUtil.print(nums);

            // 分隔符
            System.out.println("********************");

        }

    }


    public static void testSolution2(List<int[]> caseList) {

    }


    public static void main(String[] args) {

        // 参数初始化
        List<int[]> caseList = initCase();

        System.out.println("---------- 算法①调用测试 ----------");

        testSolution1(caseList);

        System.out.println("---------- 算法②调用测试 ----------");

        testSolution2(caseList);

    }
}
