package com.noob.algorithm.leetcode.q215;


import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<int[]> caseList = new ArrayList<>();
    static List<Integer> kList = new ArrayList<>();

    // 初始化测试用例
    public static void initCase() {

        // todo 补充测试用例集合
        caseList.add(new int[]{3, 2, 1, 5, 6, 4}); // 5
        kList.add(2);

        caseList.add(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}); // 4
        kList.add(4);

    }

    public static void testSolution1() {

        for (int i = 0; i < caseList.size(); i++) {
            // ① 调用算法
            Solution1 solution = new Solution1();
            int res = solution.findKthLargest(caseList.get(i), kList.get(i));

            // ② 打印数据
            System.out.println(res);

            // 分隔符
            System.out.println("********************");

        }

    }


    public static void testSolution2() {

        for (int i = 0; i < caseList.size(); i++) {
            // ① 调用算法
            Solution2 solution = new Solution2();
            int res = solution.findKthLargest(caseList.get(i), kList.get(i));

            // ② 打印数据
            System.out.println(res);

            // 分隔符
            System.out.println("********************");

        }

    }


    public static void testSolution3() {

        for (int i = 0; i < caseList.size(); i++) {
            // ① 调用算法
            Solution3 solution = new Solution3();
            int res = solution.findKthLargest(caseList.get(i), kList.get(i));

            // ② 打印数据
            System.out.println(res);

            // 分隔符
            System.out.println("********************");

        }

    }


    public static void main(String[] args) {

        // 参数初始化
        initCase();

        System.out.println("---------- 算法①调用测试 ----------");

        testSolution1();

        System.out.println("---------- 算法②调用测试 ----------");

        testSolution2();

        System.out.println("---------- 算法③调用测试 ----------");

        testSolution3();

    }
}
