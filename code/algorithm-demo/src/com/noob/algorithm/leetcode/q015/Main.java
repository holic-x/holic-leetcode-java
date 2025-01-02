package com.noob.algorithm.leetcode.q015;

public class Main {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        Solution1 solution1 = new Solution1(); // 方案超时
        System.out.println(solution1.threeSum(nums));

        System.out.println("-----------------------------------------");

        Solution2 solution2 = new Solution2(); // 优化去重、剪枝处理
        System.out.println(solution2.threeSum(nums));
    }

}
