package com.noob.algorithm.leetcode.q001_100.q001;

import com.noob.algorithm.base.util.PrintUtil;

public class Main {

    public void initCase() {

    }

    public static void testSolution1(int[] nums, int target) {
        Solution1 solution1 = new Solution1();
        int[] res = solution1.twoSum(nums, target);
        PrintUtil.print(res);
    }

    public static void testSolution2(int[] nums, int target) {
        Solution2 solution2 = new Solution2();
        int[] res = solution2.twoSum(nums, target);
        PrintUtil.print(res);
    }

    public static void main(String[] args) {
        // 测试用例
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;

        testSolution1(nums, target);
        System.out.println("----------------------------------");
        testSolution2(nums, target);

    }
}
