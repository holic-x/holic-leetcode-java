package com.noob.algorithm.leetcode.q001;

import com.noob.algorithm.base.util.PrintUtil;

public class Main {

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        Solution2 solution2 = new Solution2();

        int[] nums = new int[]{2, 7, 11, 15};
        int[] res1 = solution1.twoSum(nums, 9);
        PrintUtil.print(res1);

        int[] res2 = solution2.twoSum(nums, 9);
        PrintUtil.print(res2);
    }
}
