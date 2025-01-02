package com.noob.algorithm.leetcode.q001;

import com.noob.algorithm.base.util.PrintUtil;

public class Main {

    public void initCase() {

    }

    public static void testCase1(int[] nums, int target) {
        Solution1 solution1 = new Solution1();
        int[] res = solution1.twoSum(nums, target);
        PrintUtil.print(res);
    }

    public static void testCase2(int[] nums, int target) {
        Solution2 solution2 = new Solution2();
        int[] res = solution2.twoSum(nums, target);
        PrintUtil.print(res);
    }

    public static void main(String[] args) {
        // 测试用例
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;

        testCase1(nums, target);
        System.out.println("----------------------------------");
        testCase2(nums, target);

    }
}
