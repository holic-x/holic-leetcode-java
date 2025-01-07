package com.noob.algorithm.leetcode.q287;


import java.util.ArrayList;
import java.util.List;

public class Main {

    // 初始化测试用例
    public static List<int[]> initCase() {
        List<int[]> caseList = new ArrayList<>();

        // todo 补充测试用例集合
        caseList.add(new int[]{1, 3, 4, 2, 2});
        caseList.add(new int[]{3, 1, 3, 4, 2});
        caseList.add(new int[]{3, 3, 3, 3, 3});

        return caseList;
    }

    public static void testSolution1(List<int[]> caseList) {

        for (int[] nums : caseList) {
            // ① 调用算法
            Solution1 solution = new Solution1();
            int res1 = solution.findDuplicate1(nums);
            //  int res2 = solution.findDuplicate2(nums);
            //  int res3 = solution.findDuplicate3(nums);
            //  int res4 = solution.findDuplicate4(nums);
            //  int res5 = solution.findDuplicate5(nums);


            // ② 打印数据
            System.out.println(res1);
//            System.out.println(res2);
//            System.out.println(res3);
//            System.out.println(res4);
//            System.out.println(res5);

            // 分隔符
            System.out.println("********************");

        }
    }

    public static void testSolution2(List<int[]> caseList) {

        for (int[] nums : caseList) {
            // ① 调用算法
            Solution2 solution = new Solution2();
            int res1 = solution.findDuplicate1(nums);
//            int res2 = solution.findDuplicate2(nums);

            // ② 打印数据
            System.out.println(res1);
//            System.out.println(res2);

            // 分隔符
            System.out.println("********************");

        }

    }


    public static void main(String[] args) {
        // todo 注意测试用例static的作用范围，初始化用例
        // 参数初始化
        List<int[]> caseList1 = initCase();
        List<int[]> caseList2 = initCase();

        System.out.println("---------- 算法①调用测试 ----------");

        testSolution1(caseList1);

        System.out.println("---------- 算法②调用测试 ----------");

        testSolution2(caseList2);

    }
}
