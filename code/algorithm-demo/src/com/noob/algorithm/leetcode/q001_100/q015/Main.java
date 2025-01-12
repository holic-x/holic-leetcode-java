package com.noob.algorithm.leetcode.q001_100.q015;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // 初始化测试用例
    public static List<int[]> initCase() {
        List<int[]> caseList = new ArrayList<>();
        caseList.add(new int[]{-1, 0, 1, 2, -1, -4});
        caseList.add(new int[]{0, 1, 1});
        caseList.add(new int[]{0, 0, 0});
        return caseList;
    }

    public static void testSolution1(List<int[]> caseList) {
        Solution1 solution1 = new Solution1(); // 方案超时
        for (int[] nums : caseList) {
            System.out.println(solution1.threeSum(nums));
        }
    }


    public static void testSolution2(List<int[]> caseList) {
        Solution2 solution2 = new Solution2(); // 优化去重、剪枝处理
        for (int[] nums : caseList) {
            System.out.println(solution2.threeSum(nums));
        }
    }


    public static void main(String[] args) {
        List<int[]> caseList = initCase();

        testSolution1(caseList);
        System.out.println("-----------------------------------------");
        testSolution2(caseList);

    }

}
