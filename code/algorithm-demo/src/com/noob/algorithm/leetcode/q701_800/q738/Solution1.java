package com.noob.algorithm.leetcode.q701_800.q738;

/**
 * 🟡 738 单调递增的数字 - https://leetcode.cn/problems/monotone-increasing-digits/description/
 */
public class Solution1 {

    // 贪心：找到非单调递增的标记位
    public int monotoneIncreasingDigits(int n) {
        char[] nums = String.valueOf(n).toCharArray();
        // ① 逆序遍历每个数字,如果发现当前数字大于下一位数字,就将当前数字-1,记录这个位置
        int idx = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            // 逆序遍历，如果发现当前数字大于下一个位数字，则将当前数字-1，并记录这个位置
            if (nums[i] > nums[i + 1]) {
                nums[i]--; // 继续下一步遍历，当前变更的结果需要作为下个位置校验的参考（待下次校验的时候才能利用到上次比较的结果）
                idx = i; // 记录这个位置
            }
        }

        // ② 上述操作完成，确认idx是否存在，如果存在则从当前位置开始将当前idx位置往后的数字都置为9
        if (idx != -1) {
            for (int i = idx + 1; i < nums.length; i++) {
                nums[i] = '9';
            }
        }

        // ③ 返回处理好的结果
        return Integer.valueOf(String.valueOf(nums));
    }
}
