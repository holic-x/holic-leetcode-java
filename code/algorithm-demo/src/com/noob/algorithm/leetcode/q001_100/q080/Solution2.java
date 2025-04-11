package com.noob.algorithm.leetcode.q001_100.q080;

/**
 * 🟡 080 删除有序数组中的重复项II - https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/
 */
public class Solution2 {

    public int removeDuplicates(int[] nums) {
        return removeDuplicates(nums, 2); // 2表示最多允许重复次数
    }

    /**
     * 通用思路：双指针（最多允许K个重复）
     */
    private int removeDuplicates(int[] nums, int k) {
        if (nums.length <= k) {
            return nums.length;
        }
        // slow 慢指针：指向当前要写入的位置（最多允许K个重复，因此不需要关注前K个元素是否重复，直接从K位置开始写入）
        int slow = k;
        // fast 快指针：指向当前读取的位置，判断fast与slow-k位置的元素是否相同，如果不相同则进行覆盖并且指针移动，相同则跳过继续遍历下一位
        for (int fast = k; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow - k]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
