package com.noob.algorithm.leetcode.q201_300.q209;

/**
 * 🟡 209 长度最小的子数组 - https://leetcode.cn/problems/minimum-size-subarray-sum/
 * 求满足数组中其总和大于等于target的长度最小的子数组
 */
public class Solution209_02 {

    /**
     * 思路分析：
     * 滑动窗口思路：用双指针圈定滑动范围
     */
    public int minSubArrayLen(int target, int[] nums) {
        // 定义满足条件的最小长度
        int minLen = Integer.MAX_VALUE;

        // 定义滑动窗口边界(初始化为0个元素，逐步移入元素)
        int winLeft = 0, winRight = 0;

        // 定义滑动窗口内子数组的元素总和
        int curSum = 0;

        while (winRight < nums.length) {
            // 移入右侧元素
            curSum += nums[winRight];

            // 判断curSum与target
            while (curSum >= target) {
                // 更新minLen
                minLen = Math.min(minLen, winRight - winLeft + 1);
                // 将左侧指针指向元素移出
                curSum -= nums[winLeft];
                winLeft++;
            }

            // right 指针移动（指向下一个要纳入的元素，放在最后执行，避免联动变更影响）
            winRight++;
        }

        // 返回结果
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

}
