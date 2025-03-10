package com.noob.algorithm.leetcode.q201_300.q279;



import java.util.ArrayList;
import java.util.List;

public class Main {

    // 初始化测试用例
    public static List<Integer> initCase() {
        List<Integer> caseList = new ArrayList<>();

        // todo 补充测试用例集合
        caseList.add(12);
        caseList.add(13);

        return caseList;
    }

    public static void testSolution1(List<Integer> caseList) {

        for (int n : caseList) {
            // ① 调用算法
            Solution1 solution = new Solution1();
            int res = solution.numSquares(n);

            // ② 打印数据
            System.out.println(res);

            // 分隔符
            System.out.println("********************");

        }

    }


    public static void testSolution2(List<Integer> caseList) {

    }


    public static void main(String[] args) {

        // 参数初始化
        List<Integer> caseList = initCase();

        System.out.println("---------- 算法①调用测试 ----------");

        testSolution1(caseList);

        System.out.println("---------- 算法②调用测试 ----------");

        testSolution2(caseList);

    }
}
