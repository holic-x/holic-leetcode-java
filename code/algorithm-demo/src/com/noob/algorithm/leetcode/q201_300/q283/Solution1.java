package com.noob.algorithm.leetcode.q201_300.q283;

import java.util.Arrays;

/**
 * 🟢 283.移动零 - https://leetcode.cn/problems/move-zeroes/description/
 */
public class Solution1 {
    /**
     * 思路：双指针
     * 双指针概念：一个指针用于遍历非0元素，一个指针用于跟踪当前覆盖位置
     */
    public void moveZeroes(int[] nums) {
        // 循环遍历，依次进行覆盖（指针记录当前覆盖的位置，指针后面的用0补齐）
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // 非0，覆盖
                nums[current] = nums[i];
                // 当前覆盖位置后移
                current++;
            }
        }
        // 从当前指针位置补0
        for (int i = current; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
