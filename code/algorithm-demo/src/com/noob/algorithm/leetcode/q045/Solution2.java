package com.noob.algorithm.leetcode.q045;

/**
 * 🟡 045.跳跃游戏II - https://leetcode.cn/problems/jump-game-ii/
 */
public class Solution2 {

    /**
     * 生成的测试用例是可以到达nums[n-1]位置的，贪心思路每次选择覆盖范围内最远的那个距离
     */
    public int jump(int[] nums) {
        int maxCover = 0; // 最大覆盖范围(当前位置i可跳的最大位置)
        int jumpPointer = 0; // 上一跳指定的可跳的最大位置 preStepMaxTarget
        int cnt = 0; // 跳跃次数

        for (int i = 0; i < nums.length - 1; i++) { // 此处遍历不必访问最后一个元素（考虑边界跳的情况）
            // 遍历过程中不断更新有效的覆盖范围
            maxCover = Math.max(maxCover, i + nums[i]);

            // 每次都选上一步可达到的最远的位置跳
            if (i == jumpPointer) {
                cnt++; // 跳
                jumpPointer = maxCover; // 当前可覆盖的最大范围作为下一个跳跃目标位置
            }
        }

        // 返回结果
        return cnt;
    }
}
