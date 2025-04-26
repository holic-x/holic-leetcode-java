package com.noob.algorithm.leetcode.q001_100.q027;

/**
 * 🟢 027 移除元素 - https://leetcode.cn/problems/remove-element/description/
 */
public class Solution027_01 {
    /**
     * 思路分析：双指针思路，覆盖数据概念
     */
    public int removeElement(int[] nums, int val) {
        // 定义指针用于指向当前覆盖位置
        int curIdx = 0;
        // 遍历数组，校验当前遍历元素是否为val，如果为val则跳过，非val则将当前元素覆盖到curIdx指向位置
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[curIdx] = nums[i];
                curIdx++; // 指针移动指向下一个位置
            }
        }
        return curIdx;
    }
}
